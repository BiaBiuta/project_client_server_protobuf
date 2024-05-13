package org.example.protobuffprotocol;


import org.example.Child;
import org.example.Organizing;
import org.example.Registration;
import org.example.Sample;
import org.example.javaFiles.*;

import java.util.List;


public class ProtoUtils {
    public static CompetitionRequest createLoginRequest(Organizing user){
        OrganizingDTO userDTO=OrganizingDTO.newBuilder().setPassword(user.getPassword()).setUsername(user.getUsername()).build();
        CompetitionRequest request= CompetitionRequest.newBuilder().setType(CompetitionRequest.Type.LOGIN)
                .setOrganizing(userDTO).build();
        return request;
    }
    public static CompetitionRequest createLogoutRequest(Organizing user){
       OrganizingDTO userDTO=OrganizingDTO.newBuilder().setId(user.getId().toString()).build();
       CompetitionRequest request= CompetitionRequest.newBuilder().setType(CompetitionRequest.Type.LOGOUT)
                .setOrganizingLogout(userDTO).build();
        return request;
    }

    public static CompetitionRequest createFindChildRequest(String name){
         ChildDTO messageDTO=ChildDTO.newBuilder().setName(name).build();
        CompetitionRequest request= CompetitionRequest.newBuilder().setType(CompetitionRequest.Type.FIND_CHILD)
                .setChild(messageDTO).build();
        return request;
    }

//    public static CompetitionRequest createLoggedFriendsRequest(User user){
//        User userDTO=User.newBuilder().setId(user.getId()).build();
//        ChatRequest request= ChatRequest.newBuilder()
//                .setType(ChatRequest.Type.GetLoggedFriends)
//                .setUser(userDTO).build();
//        return request;
//    }


    public static CompetitionResponse createOkResponse(){
        CompetitionResponse response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.OK_Response).build();
        return response;
    }

    public static CompetitionResponse createErrorResponse(String text){
        CompetitionResponse response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.ERROR_Response)
                .setError(text).build();
        return response;
    }

//    public static CompetitionResponse createFriendLoggedInResponse(User user){
//        User userDTO=User.newBuilder().setId(user.getId()).build();
//
//        CompetitionResponse response=CompetitionResponse.newBuilder()
//                .setType(CompetitionResponse.Type.FriendLoggedIn)
//                .setUser(userDTO).build();
//        return response;
//    }

   // public static CompetitionResponse createFriendLoggedOutResponse(User user){
//        User userDTO=User.newBuilder().setId(user.getId()).build();
//
//        CompetitionResponse response=CompetitionResponse.newBuilder()
//                .setType(CompetitionResponse.Type.FriendLoggedOut)
//                .setUser(userDTO).build();
//        return response;
//    }
//    public static CompetitionResponse createNewMessageResponse(Message message){
//        Message messageDTO=Message.newBuilder()
//                .setSenderId(message.getSender().getId())
//                .setReceiverId(message.getReceiver().getId())
//                .setText(message.getText())
//                .build();
//
//        CompetitionResponse response=CompetitionResponse.newBuilder()
//                .setType(CompetitionResponse.Type.NewMessage)
//                .setMessage(messageDTO).build();
//        return response;
//    }

//    public static CompetitionResponse createLoggedFriendsResponse(User[] users){
//        CompetitionResponse.Builder response=CompetitionResponse.newBuilder()
//                .setType(CompetitionResponse.Type.GetLoggedFriends);
//        for (User user: users){
//            User userDTO=User.newBuilder().setId(user.getId()).build();
//              response.addFriends(userDTO);
//        }
//
//        return response.build();
//    }

    public static String getError(CompetitionResponse response){
        String errorMessage=response.getError();
        return errorMessage;
    }

//    public static User getUser(CompetitionResponse response){
//        User user=new User();
//        user.setId(response.getUser().getId());
//        return user;
//    }

//    public static Message getMessage(CompetitionResponse response){
//        User sender=new User();
//        sender.setId(response.getMessage().getSenderId());
//        User receiver=new User();
//        receiver.setId(response.getMessage().getReceiverId());
//        Message message=new Message(sender,response.getMessage().getText(), receiver);
//        return message;
//    }
//
//    public static User[] getFriends(CompetitionResponse response){
//        User[] friends=new User[response.getFriendsCount()];
//        for(int i=0;i<response.getFriendsCount();i++){
//            User userDTO=response.getFriends(i);
//            User user=new User();
//            user.setId(userDTO.getId());
//            friends[i]=user;
//        }
//        return friends;
//    }
//    public static User getUser(ChatRequest request){
//        User user=new User();
//        user.setId(request.getUser().getId());
//        user.setPasswd(request.getUser().getPasswd());
//        return user;
//    }
//
//    public static Message getMessage(ChatRequest request){
//            User sender=new User();
//            sender.setId(request.getMessage().getSenderId());
//            User receiver=new User();
//            receiver.setId(request.getMessage().getReceiverId());
//            Message message=new Message(sender,request.getMessage().getText(), receiver);
//            return message;
//        }

    public static Child getChild(CompetitionResponse response) {
        ChildDTO childDto=response.getChild();
        if (childDto.getId().isEmpty())
            return null;
        Child child =DTOUtils.getFromDTO(childDto);

        return child;
    }

    public static CompetitionRequest createFindOrganizingRequest(String username, String password) {
        OrganizingDTO orgDTO=OrganizingDTO.newBuilder().setUsername(username).setPassword(password).build();
        CompetitionRequest request= CompetitionRequest.newBuilder().setType(CompetitionRequest.Type.FIND_ORGANIZING)
                .setOrganizing(orgDTO).build();
        return request;
    }

    public static Organizing getOrganizing(CompetitionResponse response) {
        OrganizingDTO orgDto=response.getOrganizing();
        Organizing org =DTOUtils.getFromDTO(orgDto);
        return org;
    }
    public static Organizing getOrganizing(CompetitionRequest response) {
        OrganizingDTO orgDto=response.getOrganizing();
        Organizing org =DTOUtils.getFromDTO(orgDto);
        return org;
    }

    public static CompetitionRequest createAllSamplesRequest() {
        CompetitionRequest request= CompetitionRequest.newBuilder().setType(CompetitionRequest.Type.FIND_ALL_SAMPLES)
                .build();
        return request;
    }

    public static Iterable<Sample> getSamples(CompetitionResponse response) {
        Iterable<SampleDTO> samples=response.getSamplesResList();
        return DTOUtils.getFromDTOSamples(samples);
    }
//    public static Iterable<Sample> getSamples(CompetitionRequest response) {
//       response.getEmpty();
//        return DTOUtils.getFromDTOSamples(samples);
//    }

    public static CompetitionRequest createSaveChildRequest(String name, int age) {
        ChildDTO childDTO=ChildDTO.newBuilder().setName(name).setAge(String.valueOf(age)).build();
        CompetitionRequest request= CompetitionRequest.newBuilder().setType(CompetitionRequest.Type.SAVE_CHILD)
                .setChild(childDTO).build();
        return request;
    }

    public static CompetitionRequest createFindSampleRequest(String ageCategory, String desen) {
            SampleDTO sampleDTO=SampleDTO.newBuilder().setAgeCategory(ageCategory).setSampleCategory(desen).build();
            CompetitionRequest request= CompetitionRequest.newBuilder().setType(CompetitionRequest.Type.FIND_SAMPLE)
                    .setSample(sampleDTO).build();
            return request;
    }

    public static Sample getSample(CompetitionResponse response) {
        SampleDTO sampleDto=response.getSample();
        Sample sample =DTOUtils.getFromDTO(sampleDto);
        return sample;
    }

    public static Sample getSample(CompetitionRequest response) {
        SampleDTO sampleDto=response.getSample();
        Sample sample =DTOUtils.getFromDTO(sampleDto);
        return sample;
    }
    public static Sample getFindSample(CompetitionRequest response) {
        SampleDTO sampleDto=response.getSample();
        Sample sample =DTOUtils.getFromDTO(sampleDto);
        return sample;
    }

    public static CompetitionRequest createListChildrenForSampleRequest(Sample sample) {
        SampleDTO sampleDTO=SampleDTO.newBuilder().setId(sample.getId().toString()).setAgeCategory(sample.getAgeCategory().getCategoryName()).setSampleCategory(sample.getSampleCategory().getCategoryName()).build();
        CompetitionRequest request= CompetitionRequest.newBuilder().setType(CompetitionRequest.Type.LIST_CHILDREN_FOR_SAMPLE)
                .setSample(sampleDTO).build();
        return request;
    }

    public static List<Child> getChildren(CompetitionResponse response) {
        List<ChildDTO> children=response.getChildrenList();
        return DTOUtils.getFromDTOChild(children);
    }

    public static CompetitionRequest createRegisterChildRequest(Child child, Sample sample) {
        RegistrationDTO regDTO=RegistrationDTO.newBuilder().setChildId(child.getId().toString()).setSampleId(sample.getId().toString()).setAgeCategory(sample.getAgeCategory().getCategoryName()).setSampleCategory(sample.getSampleCategory().getCategoryName()).build();
        CompetitionRequest request= CompetitionRequest.newBuilder().setType(CompetitionRequest.Type.REGISTER_CHILD)
                .setRegistration(regDTO).build();
        return request;
    }

    public static Registration getRegistration(CompetitionResponse response) {
        RegistrationDTO regDto=response.getRegistration();
        Registration reg =DTOUtils.getFromDTO(regDto);
        return reg;
    }

    public static CompetitionRequest createNumberOfChildrenForSampleRequest(Sample sample) {
        SampleDTO sampleDTO=SampleDTO.newBuilder().setId(sample.getId().toString()).setAgeCategory(sample.getAgeCategory().getCategoryName()).setSampleCategory(sample.getSampleCategory().getCategoryName()).build();
        CompetitionRequest request= CompetitionRequest.newBuilder().setType(CompetitionRequest.Type.NUMBER_OF_CHILDREN_FOR_SAMPLE)
                .setSample(sampleDTO).build();
        return request;
    }

    public static int getNumberOfChildren(CompetitionResponse response) {
        return Integer.parseInt(response.getNumber());
    }
    public static Sample getNumberOfChildren(CompetitionRequest response) {
       SampleDTO sampleDTO=response.getSample();
        Sample sample =DTOUtils.getFromDTO(sampleDTO);
        return sample;
    }

    public static Organizing getOrganizingLogout(CompetitionRequest request) {
        OrganizingDTO organizingDTO=request.getOrganizingLogout();
        Organizing org =DTOUtils.getFromDTO(organizingDTO);
        return org;
    }

    public static Organizing getOrganizinfFind(CompetitionRequest request) {
        OrganizingDTO organizingDTO=request.getOrganizingFind();
       Organizing org =DTOUtils.getFromDTO(organizingDTO);
        return org;
    }

    public static CompetitionResponse createNumberOfChildrenResponse(int numberOfChildren) {
        CompetitionResponse response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.NUMBER_OF_CHILDREN_FOR_SAMPLE_Response)
                .setNumber(String.valueOf(numberOfChildren)).build();
        return response;
    }

    public static CompetitionResponse createFindOrganizingResponse(Organizing org) {
        String username = org.getUsername();
        String password = org.getPassword();
        OrganizingDTO orgDTO;
        if(org.getId()!=null){
            orgDTO=OrganizingDTO.newBuilder().setId(org.getId().toString()).setUsername(username).setPassword(password).build();

        }
        else {
            orgDTO = OrganizingDTO.newBuilder().setPassword(org.getPassword()).setUsername(org.getUsername()).build();
        }
         CompetitionResponse response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.FIND_ORGANIZING_Response)
                .setOrganizing(orgDTO).build();
        return response;
    }

    public static CompetitionResponse createFindAllSampleResponse(Iterable<Sample> samples) {
        CompetitionResponse.Builder response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.FIND_ALL_SAMPLES_Response);
        for (Sample sample: samples){
            SampleDTO sampleDTO=SampleDTO.newBuilder().setId(sample.getId().toString()).setAgeCategory(sample.getAgeCategory().getCategoryName()).setSampleCategory(sample.getSampleCategory().getCategoryName()).build();
            response.addSamplesRes(sampleDTO);
        }
        return response.build();
    }

    public static CompetitionResponse createFindSampleResponse(Sample sample) {
        SampleDTO sampleDTO;
        if(sample.getId()==null){
            String sampleCategory=sample.getSampleCategory().getCategoryName();
            String ageCategory=sample.getAgeCategory().getCategoryName();
            sampleDTO=SampleDTO.newBuilder().setSampleCategory(sampleCategory).setAgeCategory(ageCategory).build();
        }
        String id=sample.getId().toString();
        if(sample.getSampleCategory()==null|| sample.getAgeCategory()==null){
           sampleDTO=SampleDTO.newBuilder().setId(id).build();
        }
        else {
            String sampleCategory = sample.getSampleCategory().getCategoryName();
            String ageCategory = sample.getAgeCategory().getCategoryName();
            sampleDTO = SampleDTO.newBuilder().setId(sample.getId().toString()).setAgeCategory(sample.getAgeCategory().getCategoryName()).setSampleCategory(sample.getSampleCategory().getCategoryName()).build();

        }CompetitionResponse response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.FIND_SAMPLE_Response)
                .setSample(sampleDTO).build();
        return response;
    }

    public static Registration getRegisterChild(CompetitionRequest request) {
        RegistrationDTO regDTO=request.getRegistration();
        Registration reg =DTOUtils.getFromDTO(regDTO);
        return reg;
    }

    public static CompetitionResponse createRegisterChildResponse(Registration user) {
        RegistrationDTO regDTO=RegistrationDTO.newBuilder().setChildId(user.getChild().getId().toString()).setSampleId(user.getSample().getId().toString()).setAgeCategory(user.getSample().getAgeCategory().getCategoryName()).setSampleCategory(user.getSample().getSampleCategory().getCategoryName()).build();
        CompetitionResponse response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.REGISTER_CHILD_Response)
                .setRegistration(regDTO).build();
        return response;
    }

    public static Child getFindChild(CompetitionRequest request) {
        ChildDTO childDTO=request.getChild();
        Child child =DTOUtils.getFromDTO(childDTO);
        return child;
    }

    public static CompetitionResponse createFindChildResponse(Child user) {
        ChildDTO childDTO;
        if (user==null){
            childDTO = ChildDTO.newBuilder().build();
            return CompetitionResponse.newBuilder()
                    .setTypeResponse(CompetitionResponse.Type_Response.FIND_CHILD_Response)
                    .setChild(childDTO).build();
        }
        String name = user.getName();
        String age = user.getAge().toString();
        String numberOfSamples = String.valueOf(user.getNumberOfSamples());
        if (user.getId() == null){
            childDTO = ChildDTO.newBuilder().setName(user.getName()).setAge(String.valueOf(user.getAge())).setNumber(String.valueOf(user.getNumberOfSamples())).build();
        }
        else {
            childDTO = ChildDTO.newBuilder().setId(user.getId().toString()).setName(user.getName()).setAge(String.valueOf(user.getAge())).setNumber(String.valueOf(user.getNumberOfSamples())).build();
        }
        CompetitionResponse response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.FIND_CHILD_Response)
                .setChild(childDTO).build();
        return response;
    }

    public static Child getSaveChild(CompetitionRequest request) {
        ChildDTO childDTO=request.getChild();
        Child child =DTOUtils.getFromDTO(childDTO);
        return child;
    }

    public static CompetitionResponse createSaveChildResponse(Child user) {
        ChildDTO childDTO;
        String name = user.getName();
        String age = user.getAge().toString();
        String numberOfSamples = String.valueOf(user.getNumberOfSamples());
        if (user.getId() == null){
            childDTO = ChildDTO.newBuilder().setName(user.getName()).setAge(String.valueOf(user.getAge())).setNumber(String.valueOf(user.getNumberOfSamples())).build();
        }
        else {
            childDTO = ChildDTO.newBuilder().setId(user.getId().toString()).setName(user.getName()).setAge(String.valueOf(user.getAge())).setNumber(String.valueOf(user.getNumberOfSamples())).build();
        }
        CompetitionResponse response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.SAVE_CHILD_Response)
                .setChild(childDTO).build();
        return response;
    }

    public static CompetitionResponse createNewResponse(New stdto) {
        New org1 = New.newBuilder().setSampleId(stdto.getSampleId()).setNumber(stdto.getNumber()).build();
        CompetitionResponse response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.NEW_Response)
                .setNew(org1).build();
        return response;
    }

    public static Sample getSampleList(CompetitionRequest request) {
        SampleDTO sampleDTO=request.getSample();
        Sample sample =DTOUtils.getFromDTO(sampleDTO);
        return sample;
    }

    public static CompetitionResponse createListChildrenResponse(List<Child> participants) {
        CompetitionResponse.Builder response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.LIST_CHILDREN_Response);
        for (Child child: participants){
            ChildDTO childDTO=ChildDTO.newBuilder().setId(child.getId().toString()).setName(child.getName()).setAge(String.valueOf(child.getAge())).setNumber(String.valueOf(child.getNumberOfSamples())).build();
            response.addChildren(childDTO);
        }
        return response.build();
    }

    public static CompetitionResponse createLoginResponse(Organizing org) {
        OrganizingDTO orgDTO=OrganizingDTO.newBuilder().setId(org.getId().toString()).setUsername(org.getUsername()).setPassword(org.getPassword()).build();
        CompetitionResponse response=CompetitionResponse.newBuilder()
                .setTypeResponse(CompetitionResponse.Type_Response.ORGANIZING_LOGGED_IN_Response)
                .setOrganizing(orgDTO).build();
        return response;
    }
}
