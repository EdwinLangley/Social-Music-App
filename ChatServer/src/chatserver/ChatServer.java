/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketImpl;

/**
 *
 * @author jcgri
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
//        // TODO code application logic here
//        boolean running = true;
//        //int portNumber=Integer.parseInt(args[0]);
//        int inboundPort = 9091;
//        int outboundPort = 9092;
////        System.out.println("New thread");
//        try {
//            ServerSocket serverSocket = new ServerSocket(inboundPort);
//            ServerSocket outboundSocket = new ServerSocket(outboundPort);
//            while (running) {
//                //Do server stuff
////                new Thread(new ChatHandler(serverSocket.accept(),outboundSocket.accept())).start();
////                new Thread(new OutboundChatHandler)).start();
//                System.out.println("New thread");
//            }
//        } catch (IOException e) {
//            System.err.println("Error on port" + inboundPort + e);
//            System.exit(-1);
//        }
        new Thread(new OutboundServer()).start();
        new Thread(new InboundServer()).start();
    }
}
