package org.example.protobuffprotocol;


import org.example.*;
import org.example.javaFiles.*;

import java.io.*;
import java.net.Socket;
import java.util.List;


public class ProtoChatWorker implements Runnable, ICompetitionObserver {
    private ICompetitionServices server;
     private Socket connection;

     private InputStream input;
     private OutputStream output;
     private volatile boolean connected;
     public ProtoChatWorker(ICompetitionServices server, Socket connection) {
         this.server = server;
         this.connection = connection;
         try{
             output=connection.getOutputStream() ;//new ObjectOutputStream(connection.getOutputStream());
             input=connection.getInputStream(); //new ObjectInputStream(connection.getInputStream());
             connected=true;
         } catch (IOException e) {
             e.printStackTrace();
         }
     }

     public void run() {

         while(connected){
             try {
                // Object request=input.readObject();
                 System.out.println("Waiting requests ...");
                 CompetitionRequest request=CompetitionRequest.parseDelimitedFrom(input);
                 System.out.println("Request received: "+request);
                 CompetitionResponse response=handleRequest(request);
                 if (response!=null){
                    sendResponse(response);
                 }
             } catch (IOException e) {
                 e.printStackTrace();
             }
             try {
                 Thread.sleep(1000);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
         try {
             input.close();
             output.close();
             connection.close();
         } catch (IOException e) {
             System.out.println("Error "+e);
         }
     }

//     public void messageReceived(Message message) throws ChatException {
//         System.out.println("Message received  "+message);
//         try {
//             sendResponse(ProtoUtils.createNewMessageResponse(message));
//         } catch (IOException e) {
//             throw new ChatException("Sending error: "+e);
//         }
//     }
//
//     public void friendLoggedIn(User friend) throws ChatException {
//         System.out.println("Friend logged in "+friend);
//         try {
//             sendResponse(ProtoUtils.createFriendLoggedInResponse(friend));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
//
//     public void friendLoggedOut(User friend) throws ChatException {
//         System.out.println("Friend logged out "+friend);
//         try {
//             sendResponse(ProtoUtils.createFriendLoggedOutResponse(friend));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

     private CompetitionResponse handleRequest(CompetitionRequest request){
         CompetitionResponse response=null;
         switch (request.getType()){
             case LOGIN:{
                 System.out.println("Login request ...");
                 Organizing user=ProtoUtils.getOrganizing(request);
                 try {
                     Organizing org=server.login(user, this);
                     return ProtoUtils.createLoginResponse(org);
                 } catch (CompetitionException e) {
                     connected=false;
                     return ProtoUtils.createErrorResponse(e.getMessage());
                 }
             }
             case LOGOUT:{
                 System.out.println("Logout request");
                 Organizing user=ProtoUtils.getOrganizingLogout(request);
                 try {
                     server.logout(user, this);
                     connected=false;
                     return ProtoUtils.createOkResponse();

                 } catch (CompetitionException e) {
                     return ProtoUtils.createErrorResponse(e.getMessage());
                 }
             }
             case FIND_ORGANIZING:{
                 System.out.println("SendMessageRequest ...");
                 Organizing message=ProtoUtils.getOrganizinfFind(request);
                 try {
                     Organizing org=server.findOrganizing(message.getUsername(),message.getPassword());
                     return ProtoUtils.createFindOrganizingResponse(org);
                 } catch (CompetitionException e) {
                     return ProtoUtils.createErrorResponse(e.getMessage());
                 }
             }
             case NUMBER_OF_CHILDREN_FOR_SAMPLE:{
                 System.out.println("GetLoggedFriends Request ...");
                 Sample user=ProtoUtils.getNumberOfChildren(request);
                 try {
                     int numberOfChildren=server.numberOfChildrenForSample(user);
                     return ProtoUtils.createNumberOfChildrenResponse(numberOfChildren);
                 } catch (CompetitionException e) {
                     return ProtoUtils.createErrorResponse(e.getMessage());
                 }
             }
             case FIND_ALL_SAMPLES:{

                 try {
                     Iterable<Sample> samples=server.findAllSamples();
                     return ProtoUtils.createFindAllSampleResponse(samples);
                 } catch (CompetitionException e) {
                     return ProtoUtils.createErrorResponse(e.getMessage());
                 }

             }
             case FIND_SAMPLE:{
                 Sample stdto=ProtoUtils.getFindSample(request);
                    try {
                        Sample sample=server.findSample( stdto.getAgeCategory().getCategoryName(),stdto.getSampleCategory().getCategoryName()) ;
                        return ProtoUtils.createFindSampleResponse(sample);
                    } catch (CompetitionException e) {
                        return ProtoUtils.createErrorResponse(e.getMessage());
                    }
             }
             case REGISTER_CHILD: {
                 Registration reg = ProtoUtils.getRegisterChild(request);
                 try {
                     Registration user = server.registerChild(reg.getChild(), reg.getSample());
                     return ProtoUtils.createRegisterChildResponse(user);
                 } catch (CompetitionException e) {
                     return ProtoUtils.createErrorResponse(e.getMessage());
                 }
             }
             case FIND_CHILD:{
                    Child stdto=ProtoUtils.getFindChild(request);
                    try {
                        Child user=server.findChild(stdto.getName());
                        return ProtoUtils.createFindChildResponse(user);
                    } catch (CompetitionException e) {
                        return ProtoUtils.createErrorResponse(e.getMessage());
                    }

             }
             case SAVE_CHILD:{
                 Child stdto=ProtoUtils.getSaveChild(request);
                 try {
                     Child user=server.saveChild(stdto.getName(),stdto.getAge());
                     return ProtoUtils.createSaveChildResponse(user);
                 } catch (CompetitionException e) {
                     return ProtoUtils.createErrorResponse(e.getMessage());
                 }
             }
             case NEW:{
                 New stdto=request.getNew();
                 System.out.println("New request ...");
                 return ProtoUtils.createNewResponse(stdto);

                }
             case LIST_CHILDREN_FOR_SAMPLE:{
                    Sample sdto=ProtoUtils.getSampleList(request);
                    try {
                        Sample sample=server.findSample(sdto.getAgeCategory().getCategoryName(),sdto.getSampleCategory().getCategoryName());
                        List<Child> participants=server.listChildrenForSample(sample);
                        return ProtoUtils.createListChildrenResponse(participants);
                    } catch (CompetitionException e) {
                        return ProtoUtils.createErrorResponse(e.getMessage());
                    }
             }
         }
         return response;
     }

     private void sendResponse(CompetitionResponse response) throws IOException{
         System.out.println("sending response "+response);
         response.writeDelimitedTo(output);
         //output.writeObject(response);
         output.flush();
     }

    @Override
    public void participantsRegistered(int sampleId, int org) throws CompetitionException {
        System.out.println("Participants registered " + org);
        New org1 = New.newBuilder().setSampleId(String.valueOf(sampleId)).setNumber(String.valueOf(org)).build();
        CompetitionResponse response = ProtoUtils.createNewResponse(org1);
        try {
            sendResponse(response);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
