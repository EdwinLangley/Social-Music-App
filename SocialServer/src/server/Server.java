/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import DataPacket.UserData;
import java.net.*;
import java.io.*;
import java.util.ArrayList;
/**
 *
 * @author Joe
 */
public class Server {

    public static ArrayList<UserData> currentUsers = new ArrayList<UserData>();
    /**
     * @param args the command line arguments
     * 
     * ASK ABOUT THREAD POOLS!!!!!
     * 
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean running=true;
        //int portNumber=Integer.parseInt(args[0]);
	int portNumber=9090;
        try (ServerSocket serverSocket = new ServerSocket(portNumber)){
            while (running){
            //Do server stuff
	    new Thread(new ClientNetworkInterface(serverSocket.accept())).start();
            System.out.println("New thread");
            }
        } catch (IOException e){
            System.err.println("Error on port"+portNumber+e);
            System.exit(-1);
        }
    }
    
}
