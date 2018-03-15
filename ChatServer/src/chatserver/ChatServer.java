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
public class ChatServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean running=true;
        //int portNumber=Integer.parseInt(args[0]);
	int portNumber=9091;
        try (ServerSocket serverSocket = new ServerSocket(portNumber)){
            while (running){
            //Do server stuff
	    new Thread(new ChatHandler(serverSocket.accept())).start();
            System.out.println("New thread");
            }
        } catch (IOException e){
            System.err.println("Error on port"+portNumber+e);
            System.exit(-1);
        }
    }
    
}
