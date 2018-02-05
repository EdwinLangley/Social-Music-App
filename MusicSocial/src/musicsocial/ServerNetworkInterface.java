/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package musicsocial;

import DataPacket.DataPacket;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edwin
 */
public class ServerNetworkInterface {
    public Socket socket=null;
    public boolean openConnection=true;
    public void setSocket(InetAddress address, int port){this.socket = Socket(address,9090) ;}
    public void sendData(DataPacket data){
	DataPacket outputData=data;
	try(
	    ObjectOutputStream output= new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
	)
	 {
	      if (outputData.getCommand()!=null){
                try{
                    output.writeObject(outputData);
                    output.flush();
                    
                } catch (IOException i){
                    i.printStackTrace();
                    return;
                }
            }
	    output.close();
	 }catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public DataPacket recieveData(){
	DataPacket inputData=new DataPacket();
	  try(
                ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                )
        {
            if (input.read()!=-1){
                try{
                    inputData=(DataPacket) input.readObject();
                } catch (IOException i){
                    i.printStackTrace();
                    return null;
                } catch (ClassNotFoundException c){
                    System.out.println("Class not found");
                    c.printStackTrace();
                    return null;
                }
            }
            input.close();
	}
	    catch (IOException e) {
            e.printStackTrace();
	    }
	return inputData;
    }
    private void serverConnect(DataPacket data) {
        
        DataPacket inputData=new DataPacket();
        DataPacket outputData=new DataPacket();
        
        try(
                ObjectInputStream input = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
                ObjectOutputStream output= new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                )
        {
            if (input.read()!=-1){
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
            input.close();
            
            if (outputData.getCommand()!=null){
                try{
                    output.writeObject(outputData);
                    
                } catch (IOException i){
                    i.printStackTrace();
                    return;
                }
            }output.close();
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    private Socket Socket(InetAddress address, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
    
}
