/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.util.ArrayList;
import java.io.Serializable;

/**
 *
 * @author Joe
 */
//Container for data packets to be transfered over the sockets. 
//@param T is data type
public class DataPacket implements Serializable {

    public String command, username;
    public int ID;
    //private String Data;
    //private ArrayList<String> dataArray=new ArrayList();

    //Constructors
    //public void buildDataPacket (String Command, String Data, ArrayList dataArray){this.Command=Command; this.Data=Data; this.dataArray=dataArray;}
    public DataPacket() {
    }

    public DataPacket(String Command) {
        this.command = Command;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public DataPacket(String command, String username) {
        this.command = command;
        this.username = username;
    }
}
