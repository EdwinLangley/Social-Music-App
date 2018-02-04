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
	DataPacket inputData=new DataPacket();
	DataPacket outputData=new DataPacket();
	while (openConnection){
	    inputData.buildDataPacket(null, null, null);
	    outputData.buildDataPacket(null, null, null);
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
		    newClient.setInputPacket(inputData);
		    outputData=newClient.clientControlBlock();
		    //Code to recieve data from client handler
		    outputData=newClient.getOutputPacket();
		    //Code to handle network output here
		    //Fills outputData with data from server
		    //If there is any data to send out
		    if("EXT".equals(outputData.getCommand())){
			openConnection=false;
			continue;//Think this may work;
		    }
		    if (outputData.getCommand()!=null){
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