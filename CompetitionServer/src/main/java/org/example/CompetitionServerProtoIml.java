package org.example;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompetitionServerProtoIml implements ICompetitionServices{
    private OrganizingRepository orgRepo;
    private RegistrationRepository regRepo;
    private ChildRepository childRepo;
    //private   childRepo;
    private SampleRepository sampleRepository;
    private Map<Integer , ICompetitionObserver> loggedClients;

    public CompetitionServerProtoIml(OrganizingRepository orgRepo, RegistrationRepository regRepo, ChildRepository childRepo, SampleRepository sampleRepository) {
        this.orgRepo = orgRepo;
        this.regRepo = regRepo;
        this.childRepo = childRepo;
        this.sampleRepository=sampleRepository;
        this.loggedClients = new java.util.concurrent.ConcurrentHashMap<>();
    }

    @Override
    public Child findChild(String name) {
        return childRepo.findByName(name);
    }

    @Override
    public  synchronized  Organizing login(Organizing org1,ICompetitionObserver observer) throws CompetitionException {
        Organizing org = orgRepo.findByName(org1.getUsername(),org1.getPassword());
        if (org != null) {
            if(loggedClients.get(org.getId())!=null)
                throw new CompetitionException("User already logged in.");

        } else {
            throw new CompetitionException("Authentication failed.");
        }
        loggedClients.put(org.getId(),observer);
        return org;

    }
    private final int defaultThreadsNo=5;
    @Override
    public synchronized void logout(Organizing user,ICompetitionObserver observer) throws CompetitionException {
        ICompetitionObserver localClient=loggedClients.remove(user.getId());
        if (localClient==null)
            throw new CompetitionException("User "+user.getUsername()+" is not logged in.");
        //nush daca sa fac notifyFriendsLoggedOut
    }
    public Organizing findOrganizing(String username, String password) {
        return orgRepo.findByName(username,password);
    }
    public Iterable<Sample> findAllSamples(){
        return sampleRepository.findAll();
    }

    @Override
    public Sample updateSample(Sample sample) throws CompetitionException {
        return sampleRepository.updateSample(sample);
    }

    @Override
    public Sample deleteSample(Sample sample) throws CompetitionException {
    return sampleRepository.deleteSample(sample);
    }

    @Override
    public Sample findSampleById(Integer id) throws CompetitionException {
        return sampleRepository.findOne(id);
    }

    @Override
    public Sample createSample(Sample sample) throws CompetitionException {

        return sampleRepository.save(sample);
    }

    @Override
    public Child saveChild(String name, int age) throws CompetitionException {
        return  childRepo.save(new Child(name,age));
    }

    public Sample findSample(String varsta, String proba){
        return sampleRepository.findOneByCategoryAndAge(proba,varsta);
    }
    public synchronized Registration registerChild(Child child , Sample sample) throws CompetitionException {
        Child childFound=childRepo.findOne(child.getId());
        if(childFound==null) {
//            try {
//                childValidator.validate(child);
//            } catch (ValidationException e) {
//                throw new RuntimeException(e);
//            }
            childFound = childRepo.save(child);
        }
        else{
            if(childFound.getNumberOfSamples()==2){
                //ControllerGuiAlert.showErrorMessage(null,"Copilul a fost inscris la 2 probe");
                return null;
            }
        }

        int x=childFound.getNumberOfSamples()+1;
        System.out.println(x);
        childFound.setNumberOfSamples(x);
        if(regRepo.findOneByChildAndSample(childFound.getId(),sample.getId())!=null){
            // ControllerGuiAlert.showErrorMessage(null,"Copilul a fost inscris la aceasta proba");
            return null;
        }
        Registration registration=new Registration(childFound,sample);

        childRepo.update(childFound);

        //  System.out.println("Child found "+childFound.getNumberOfSamples());
        Registration reg=regRepo.save(registration);
        int numar = regRepo.numberOfChildrenForSample(sample);
        //notifyObservers(new ChangeEventRegister(ChangeEvent.REGISTER,registration));
        notifyTheOthersAdded(sample.getId(),numar);
        return reg;
    }
    private void notifyTheOthersAdded(int sampleId, int org1) throws CompetitionException{
        Iterable<Organizing> orgs=orgRepo.findAll();
        ExecutorService executor= Executors.newFixedThreadPool(defaultThreadsNo);
        for(Organizing org:orgs){
            ICompetitionObserver client=loggedClients.get(org.getId());
            if(client!=null)
                executor.execute(()->{
                    try {

                        System.out.println("Notifying [" + org.getId()+ "] registration ["+org.getId()+"] add.");
                        client.participantsRegistered(sampleId,org1);

                    } catch (CompetitionException e) {
                        System.err.println("Error notifying friend "+e);
                    }
                });
        }
        executor.shutdown();
    }

    @Override
    public int numberOfChildrenForSample(Sample sample) {
        return regRepo.numberOfChildrenForSample(sample);
    }


    @Override
    public List<Child> listChildrenForSample(Sample sample) {
        return regRepo.listChildrenForSample(sample);
    }
}