/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.net.*;
import java.io.*;
/**
 *
 * @author Joe
 */
public class Server {

    public static int currentUsers=0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean running=true;
        int portNumber=Integer.parseInt(args[0]);
        try (ServerSocket serverSocket = new ServerSocket(portNumber)){
            while (running){
            //Do server stuff
	    new Thread(new ClientNetworkInterface(serverSocket.accept())).start();
	    currentUsers++;
            }
        } catch (IOException e){
            System.err.println("Error on port"+portNumber+e);
            System.exit(-1);
        }
    }
    
}
