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
    
}
