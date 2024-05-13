package org.example;


import org.example.utils.AbstractServer;
import org.example.utils.ChatProtobuffConcurrentServer;

import java.io.IOException;
import java.util.Properties;

public class StartRpcServer {
    private static int defaultPort = 55556;

    public static void main(String[] args) {
        // UserRepository userRepo=new UserRepositoryMock();
        Properties serverProps = new Properties();
        try {
            serverProps.load(StartRpcServer.class.getResourceAsStream("/competitionserver.properties"));
            System.out.println("Server properties set. ");
            serverProps.list(System.out);
        } catch (IOException e) {
            System.err.println("Cannot find competitionserver.properties "+e);
            return;
        }
        OrganizingRepository organizingRepo = new OrganizingRepository(serverProps);
        SampleRepository sampleRepository=new SampleRepository(serverProps);
        //ChildRepository childRepository=new ChildRepository(serverProps);
        //ChildRepoHib childRepository=new ChildRepoHib(serverProps);
        ChildHibernateRepository childRepository=new ChildHibernateRepository(serverProps);
        //childRepository.findAll().forEach(System.out::println);
        childRepository.save(new Child("test",10));
        childRepository.findAll().forEach(System.out::println);
        RegistrationRepository registrationRepository = new RegistrationRepository(serverProps,childRepository,sampleRepository);
        ICompetitionServices competitionServerImpl = new CompetitionServerProtoIml(organizingRepo, registrationRepository, childRepository,sampleRepository);
        int competitionServerPort = defaultPort;
        try{
            competitionServerPort = Integer.parseInt(serverProps.getProperty("competition.server.port"));
        } catch (NumberFormatException nef) {
            System.err.println("Wrong  Port Number" + nef.getMessage());
            System.err.println("Using default port " + defaultPort);
        }
        System.out.println("Starting server on port: " + competitionServerPort);
        AbstractServer server = new ChatProtobuffConcurrentServer(competitionServerPort, competitionServerImpl);
        try {
            server.start();
        } catch (org.example.utils.ServerException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                server.stop();
            } catch (org.example.utils.ServerException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
