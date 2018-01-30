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
//Container for data packets to be transfered over the sockets. 
//@param T is data type
public class DataPacket<T> {
    String Command;
    T data;
    public void buildDataPacket (String Command, T data){this.Command=Command; this.data=data;}
    public String getCommand(){return Command;}
    public T getData(){return data;}
}
