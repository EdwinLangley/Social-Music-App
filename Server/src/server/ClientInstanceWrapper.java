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
public class ClientInstanceWrapper extends ClientInstance implements Runnable {
    private Socket socket=null;
    public ClientInstanceWrapper(Socket socket) {
	super();
        this.socket = socket;
    }
    
    public void run(){
        //insert client listener in here
    }
}
