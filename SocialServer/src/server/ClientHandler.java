/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
/**
 *    
 * @author Joe
 */
public class ClientHandler{
    int ID;
    java.net.InetAddress IPAddress;
    DataPacket inputPacket=null,outputPacket=null;
    //Insert commmands here
    public void testFunction(String data){
	DataPacket testpacket =new DataPacket();
//	testpacket.buildDataPacket("PCK",data,["hello","I'm an array"]); 
    }
    public void setUpClientInstance(java.net.Socket socket){this.ID=Server.currentUsers;this.IPAddress=socket.getInetAddress();}
    public void setInputPacket(DataPacket inputPacket){this.inputPacket=inputPacket;}
    public DataPacket getOutputPacket(){return outputPacket;}
    //Insert commands here
    public DataPacket clientControlBlock(){
	String command=this.inputPacket.getCommand();
	//Case statements for each command
	switch(command){
	    case "EXT":
		outputPacket.SetCommand("EXT");
	    break;
	    case "REG"://Register User
		//Call relevant function
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
}
