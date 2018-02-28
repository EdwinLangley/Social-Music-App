/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import DataPacket.DataPacket;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Joe
 */
public class ClientNetworkInterface extends ClientHandler implements Runnable {
    private Socket socket=null;
    public boolean openConnection=true;
    public ClientNetworkInterface(Socket socket) {this.socket = socket;}    
    
    @Override
    public void run(){
        //insert client listener in here
	ClientHandler newClient=new ClientHandler();
	newClient.setUpClientInstance(socket);	    
	DataPacket inputData=new DataPacket();
	DataPacket outputData=new DataPacket();
<<<<<<< HEAD
        ObjectOutputStream output=null;
=======
        ObjectOutputStream output = null;
>>>>>>> 0b433296b786fd696ca435baf1f00b97f0e478df
        ObjectInputStream input=null;
	while (openConnection){
            try{
		    //Client has to create this in the opposite order
		    //output = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		    input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
            }
            catch (IOException e){
                e.printStackTrace();
            }
            try {
                if (input.read() != -1) {
                    System.out.println("Getting Input");
                    try {
                        inputData = (DataPacket) input.readObject();
                    } catch (IOException i) {
                        i.printStackTrace();
                        return;
                    } catch (ClassNotFoundException c) {
                        System.out.println("Class not found");
                        c.printStackTrace();
                        return;
                    }
                    newClient.setInputPacket(inputData);
                    outputData = newClient.clientControlBlock(inputData);
                }
            } catch (IOException i) {
                i.printStackTrace();
                return;
            } 

            //Code to recieve data from client handle
            //Code to handle network output here
            //Fills outputData with data from server
            //If there is any data to send out
            if ("EXT".equals(outputData.getCommand())) {
                System.out.println("Close Connection");
                break;
            }
            if (!"null".equals(outputData.getCommand())) {
                try {
                    System.out.println("OutputData");
                    output.writeObject(outputData);
                } catch (IOException i) {
                    i.printStackTrace();
                    return;
                }
            }
            //output.close();
            System.out.println("OutputClosed");
        }
        
	Server.currentUsers--;
    }
}
