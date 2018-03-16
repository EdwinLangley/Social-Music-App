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
    ChatUI ui;

    public InboundServer(ChatUI ui) {
        this.ui = ui;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(inboundPort);
            while (running) {
                new Thread(new InboundChatHandler(serverSocket.accept(), ui)).start();
                ui.outputToConsole("New thread: InboundChatServer");
            }
        } catch (IOException e) {
            System.err.println("Error on port" + inboundPort + e);
        }
    }
}
