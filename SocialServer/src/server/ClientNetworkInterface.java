/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import DataPacket.DataPacket;
import java.net.*;
import java.io.*;

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
        try(
		    //Client has to create this in the opposite order
		    ObjectOutputStream output= new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		    ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
		)
        {
	while (openConnection){
	    //inputData.buildDataPacket(null, null, null);
	    //outputData.buildDataPacket(null, null, null);
		    /*Code to handle network input here
		    Fills inputData with data from client
		    Only if there is data on the socket*/
		    if (input.read()!=-1){
                        System.out.println("GettingInput");
			try{
			    inputData=(DataPacket) input.readObject();
			} catch (IOException i){
			    i.printStackTrace();
			    return;
			} catch (ClassNotFoundException c){
			    System.out.println("Class not found");
			    c.printStackTrace();
			    return;
			}
                    }
		    //}
		    //input.close();
		    //Code to pass datapacket to client handler
		    newClient.setInputPacket(inputData);
		    //Code to recieve data from client handle
		    outputData=newClient.clientControlBlock(inputData);
		    //Code to handle network output here
		    //Fills outputData with data from server
		    //If there is any data to send out
		    if("EXT".equals(outputData.getCommand())){
                        System.out.println("Close Connection");
			break;
		    }
		    if (!"null".equals(outputData.getCommand())){
			try{
                            System.out.println("OutputData");
			    output.writeObject(outputData);
			} catch (IOException i){
			    i.printStackTrace();
			    return;
			}
		    } 
		    //output.close();
                    System.out.println("OutputClosed");
		}
	}
        catch (IOException e){
	e.printStackTrace();
	}
	Server.currentUsers--;
    }
}
