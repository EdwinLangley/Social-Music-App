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
public class ClientNetworkInterface extends ClientHandler implements Runnable {
    private Socket socket=null;
    public boolean openConnection=true;
    public ClientNetworkInterface(Socket socket) {
        this.socket = socket;
	
    }    
    
    @Override
    public void run(){
        //insert client listener in here
	ClientHandler newClient=new ClientHandler();
	newClient.setUpClientInstance(socket);	    
	DataPacket inputData;
	DataPacket outputData;
	while (openConnection){
	    inputData=null;
	    outputData=null;
	    try(
		    //Client has to create this in the opposite order
		    ObjectOutputStream output= new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
		    ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
		)
		{
		    /*Code to handle network input here
		    Fills inputData with data from client
		    Only if there is data on the socket*/
		    if (input.read()!=-1){
			try{
			    inputData=(DataPacket) input.readObject();
			    input.close();
			} catch (IOException i){
			    i.printStackTrace();
			    return;
			} catch (ClassNotFoundException c){
			    System.out.println("Class not found");
			    c.printStackTrace();
			    return;
			}
		    }
		    //Code to pass datapacket to client handler
		    newClient.setInputPacket(inputPacket);
		    //Code to recieve data from client handler
		    outputData=newClient.getOutputPacket();
		    //Code to handle network output here
		    //Fills outputData with data from server
		    if (outputData!=null){
			try{
			    output.writeObject(outputData);
			    output.close();
			} catch (IOException i){
			    i.printStackTrace();
			    return;
			}
		    }
		}
	    catch (IOException e){
		e.printStackTrace();
	    }
	}
	Server.currentUsers--;
    }
}
