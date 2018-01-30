/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;
import java.lang.String;
/**
 *    
 * @author Joe
 */
public class ClientInstance{
    int ID;
    String IPAddress;
    //Insert commmands here
    public void testFunction(String data){
	DataPacket<String> testpacket =new DataPacket<>();
	testpacket.buildDataPacket("PCK",data);
    }
}
