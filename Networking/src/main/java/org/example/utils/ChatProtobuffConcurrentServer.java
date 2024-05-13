package org.example.utils;


import org.example.ICompetitionServices;
import org.example.protobuffprotocol.ProtoChatWorker;

import java.net.Socket;

public class ChatProtobuffConcurrentServer extends AbsConcurrentServer {
    private ICompetitionServices chatServer;
    public ChatProtobuffConcurrentServer(int port, ICompetitionServices chatServer) {
        super(port);
        this.chatServer = chatServer;
        System.out.println("Chat- ChatProtobuffConcurrentServer");
    }

    @Override
    protected Thread createWorker(Socket client) {
        ProtoChatWorker worker=new ProtoChatWorker(chatServer,client);
        Thread tw=new Thread(worker);
        return tw;
    }
}