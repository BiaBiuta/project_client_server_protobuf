package org.example.protobuffprotocol;


import org.example.*;
import org.example.javaFiles.CompetitionProtobuf;
import org.example.javaFiles.CompetitionRequest;
import org.example.javaFiles.CompetitionResponse;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProtoChatProxy implements ICompetitionServices {
    private String host;
      private int port;

      private ICompetitionObserver client;

      private InputStream input;
      private OutputStream output;
      private Socket connection;

      private BlockingQueue<CompetitionResponse> qresponses;
      private volatile boolean finished;
      public ProtoChatProxy(String host, int port) {
          this.host = host;
          this.port = port;
          qresponses=new LinkedBlockingQueue<CompetitionResponse>();
      }



      private void closeConnection() {
          finished=true;
          try {
              input.close();
              output.close();
              connection.close();
              client=null;
          } catch (IOException e) {
              e.printStackTrace();
          }

      }

      private void sendRequest(CompetitionRequest request)throws CompetitionException{
          try {
              System.out.println("Sending request ..."+request);
              //request.writeTo(output);
              request.writeDelimitedTo(output);
              output.flush();
              System.out.println("Request sent.");
          } catch (IOException e) {
              throw new CompetitionException("Error sending object "+e);
          }

      }

      private CompetitionResponse readResponse() throws CompetitionException{
          CompetitionResponse response=null;
          try{
              response=qresponses.take();

          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          return response;
      }
      private void initializeConnection() throws CompetitionException{
           try {
              connection=new Socket(host,port);
              output=connection.getOutputStream();
              //output.flush();
              input=connection.getInputStream();     //new ObjectInputStream(connection.getInputStream());
              finished=false;
              startReader();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      private void startReader(){
          Thread tw=new Thread(new ReaderThread());
          tw.start();
      }
    private boolean isUpdate(CompetitionResponse.Type_Response response){
        return response== CompetitionResponse.Type_Response.NEW_Response ;
    }

      private void handleUpdate(CompetitionResponse updateResponse){
          switch (updateResponse.getTypeResponse()){
//              case FriendLoggedIn:{
//                  User friend=ProtoUtils.getUser(updateResponse);
//                  System.out.println("Friend logged in "+friend);
//                  try {
//                      client.friendLoggedIn(friend);
//                  } catch (CompetitionException e) {
//                      e.printStackTrace();
//                  }
//                  break;
//              }
//              case FriendLoggedOut:{
//                  User friend=ProtoUtils.getUser(updateResponse);
//                  System.out.println("Friend logged out "+friend);
//                  try {
//                      client.friendLoggedOut(friend);
//                  } catch (CompetitionException e) {
//                      e.printStackTrace();
//                  }
//
//                  break;
//              }
//              case NewMessage:{
//                  Message message=ProtoUtils.getMessage(updateResponse);
//                  try {
//                      client.messageReceived(message);
//                  } catch (CompetitionException e) {
//                      e.printStackTrace();
//                  }
//                  break;
//              }
//              if(updateResponse.getTypeResponse()==CompetitionResponse.Type_Response.NEW_Response){
//                  try {
//                      client.participantsRegistered();
//                  } catch (CompetitionException e) {
//                      e.printStackTrace();
//                  }
//              }

          }

      }

    @Override
    public org.example.Child findChild(String name) throws CompetitionException {
        sendRequest(ProtoUtils.createFindChildRequest(name));
        CompetitionResponse response=readResponse();
        if (response.getTypeResponse()==CompetitionResponse.Type_Response.ERROR_Response){
            String errorText=ProtoUtils.getError(response);
            throw new CompetitionException(errorText);
        }
        return ProtoUtils.getChild(response);
    }

    @Override
    public org.example.Organizing findOrganizing(String username, String password) throws CompetitionException {
        sendRequest(ProtoUtils.createFindOrganizingRequest(username,password));
        CompetitionResponse response=readResponse();
          if (response.getTypeResponse()==CompetitionResponse.Type_Response.ERROR_Response){
            String errorText=ProtoUtils.getError(response);
            throw new CompetitionException(errorText);
        }
          return ProtoUtils.getOrganizing(response);
    }

    @Override
    public Iterable<org.example.Sample> findAllSamples() throws CompetitionException {
      sendRequest((ProtoUtils.createAllSamplesRequest()));
        CompetitionResponse response=readResponse();
        if (response.getTypeResponse()==CompetitionResponse.Type_Response.ERROR_Response){
            String errorText=ProtoUtils.getError(response);
            throw new CompetitionException(errorText);
        }
        return ProtoUtils.getSamples(response);
    }

    @Override
    public org.example.Child saveChild(String name, int age) throws CompetitionException {
        sendRequest(ProtoUtils.createSaveChildRequest(name,age));
        CompetitionResponse response=readResponse();
        if (response.getTypeResponse()==CompetitionResponse.Type_Response.ERROR_Response){
            String errorText=ProtoUtils.getError(response);
            throw new CompetitionException(errorText);
        }
        return ProtoUtils.getChild(response);
    }

    @Override
    public org.example.Sample findSample(String ageCategory, String desen) throws CompetitionException {
        sendRequest(ProtoUtils.createFindSampleRequest(ageCategory,desen));
        CompetitionResponse response=readResponse();
        if (response.getTypeResponse()==CompetitionResponse.Type_Response.ERROR_Response){
            String errorText=ProtoUtils.getError(response);
            throw new CompetitionException(errorText);
        }
        return ProtoUtils.getSample(response);
    }

    @Override
    public List<org.example.Child> listChildrenForSample(org.example.Sample sample) throws CompetitionException {
        sendRequest(ProtoUtils.createListChildrenForSampleRequest(sample));
        CompetitionResponse response=readResponse();
        if (response.getTypeResponse()==CompetitionResponse.Type_Response.ERROR_Response){
            String errorText=ProtoUtils.getError(response);
            throw new CompetitionException(errorText);
        }
        return ProtoUtils.getChildren(response);
    }

    @Override
    public org.example.Registration registerChild(org.example.Child child, org.example.Sample sample) throws CompetitionException {
        Child ch= findChild(child.getName());
        if(ch==null){
            ch=saveChild(child.getName(),child.getAge());
        }
        Sample sample1=findSample(sample.getAgeCategory().getCategoryName(),sample.getSampleCategory().getCategoryName());
        sendRequest(ProtoUtils.createRegisterChildRequest(ch,sample1));
        CompetitionResponse response=readResponse();
        if (response.getTypeResponse()==CompetitionResponse.Type_Response.ERROR_Response){
            String errorText=ProtoUtils.getError(response);
            throw new CompetitionException(errorText);
        }
        return ProtoUtils.getRegistration(response);

    }

    @Override
    public int numberOfChildrenForSample(org.example.Sample sample) throws CompetitionException {
        sendRequest(ProtoUtils.createNumberOfChildrenForSampleRequest(sample));
        CompetitionResponse response=readResponse();
        if (response.getTypeResponse()==CompetitionResponse.Type_Response.ERROR_Response){
            String errorText=ProtoUtils.getError(response);
            throw new CompetitionException(errorText);
        }
        return ProtoUtils.getNumberOfChildren(response);
    }

    @Override
    public void logout(org.example.Organizing user, ICompetitionObserver observer) throws CompetitionException {
            sendRequest(ProtoUtils.createLogoutRequest(user));
            CompetitionResponse response=readResponse();
        closeConnection();
            if (response.getTypeResponse()==CompetitionResponse.Type_Response.ERROR_Response){
                String errorText=ProtoUtils.getError(response);
                throw new CompetitionException(errorText);
            }
    }

    @Override
    public org.example.Organizing login(org.example.Organizing org, ICompetitionObserver onserver) throws CompetitionException {
        initializeConnection();
        System.out.println("Login request ...");
       sendRequest(ProtoUtils.createLoginRequest(org));
        CompetitionResponse response=readResponse();
        if (response.getTypeResponse()==CompetitionResponse.Type_Response.ERROR_Response){
            String errorText=ProtoUtils.getError(response);
            throw new CompetitionException(errorText);
        }
        return ProtoUtils.getOrganizing(response);
    }

    private class ReaderThread implements Runnable{
          public void run() {
              while(!finished){
                  try {
                      CompetitionResponse response=CompetitionResponse.parseDelimitedFrom(input);
                      System.out.println("response received "+response);

                      if (isUpdate(response.getTypeResponse())){
                           handleUpdate(response);
                      }else{
                          try {
                              qresponses.put(response);
                          } catch (InterruptedException e) {
                              e.printStackTrace();
                          }
                      }
                  } catch (IOException e) {
                      System.out.println("Reading error "+e);
                  }
              }
          }
      }


}
