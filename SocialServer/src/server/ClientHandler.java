/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import DataPacket.DataPacket;

/**
 *    
 * @author Joe
 */
public class ClientHandler{
    int ID;
    java.net.InetAddress IPAddress;
    DataPacket inputPacket,outputPacket;
    //Insert commmands here
    public void testFunction(String data){
	DataPacket testpacket =new DataPacket();
//	testpacket.buildDataPacket("PCK",data,["hello","I'm an array"]); 
    }
    public void setUpClientInstance(java.net.Socket socket){this.ID=Server.currentUsers;this.IPAddress=socket.getInetAddress();}
    public void setInputPacket(DataPacket inputPacket){this.inputPacket=inputPacket;}
    public DataPacket getOutputPacket(){return outputPacket;}
    //Insert commands here
    public DataPacket clientControlBlock(DataPacket dataPacket){
	String command=dataPacket.getCommand();
        System.out.println(command);
	//Case statements for each command
	switch(command){
	    case "EXT":
		outputPacket.SetCommand("EXT");
	    break;
	    case "REG"://Register User
                System.out.println("REG Switch hit");
		RegisterUser(dataPacket);
	    break;
	    case "LGN"://Login
		//Call relevant function
	    break;
	    case "SFR"://Search for Friend Recomendations
		//Call relevant function
	    break;
	    case "AFR"://Add Friend
		//Call relevant function
	    break;
	    case "FFR"://Friend Request Response
		//Call relevant function
	    break;
	    case "PST"://Push Posts to other clients
		//Call relevant function
	    break;
	    case "PYM"://Play music?
		//Call relevant function
	    break;
	    case "UPS"://Upload Song
		//Call relevant function
	    break;
	    case "RSL"://Request song list
		//Call relevant function
	    break;
	    case "RPD"://Request profile data
		//Call relevant function
	    break;
	    case "UFL"://Update Friends list
		//Call relevant function
	    break;
	    case "UPL"://Update Post List
		//Call relevant function
	    break;
	    case "SCT"://Start chat
		//Call relevant function
	    break;
	    default: 
		outputPacket.buildDataPacket(null, null, null);
	}
	return outputPacket;
    }
    private void RegisterUser(DataPacket inputData){
        System.out.println(inputData.getData());
    }
}
