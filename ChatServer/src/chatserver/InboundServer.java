/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author jcgri
 */
public class InboundServer implements Runnable {

    boolean running = true;
    int inboundPort = 9091;

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(inboundPort);
            while (running) {
                //Do server stuff
                new Thread(new InboundChatHandler(serverSocket.accept())).start();
                System.out.println("New thread");
            }
        } catch (IOException e) {
            System.err.println("Error on port" + inboundPort + e);
        }
    }
}
