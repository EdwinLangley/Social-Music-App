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
public class OutboundServer implements Runnable {

    boolean running = true;
    int outboundPort = 9092;

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(outboundPort);
            while (running) {
                //Do server stuff
                new Thread(new OutboundChatHandler(serverSocket.accept())).start();
                System.out.println("New thread");
            }
        } catch (IOException e) {
            System.err.println("Error on port" + outboundPort + e);
        }
    }
}
