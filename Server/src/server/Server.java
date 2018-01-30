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
	    new Thread(new ClientInstanceWrapper(serverSocket.accept())).start();
            }
        } catch (IOException e){
            System.err.println("Error on port"+portNumber);
            System.exit(-1);
        }
    }
    
}
