/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chat;
import java.net.*;
import java.io.*;

/**
 *
 * @author jcgri
 */
public class ChatServer implements Runnable{
    private Socket socket=null;
    public boolean openConnection=true;
    public ChatServer(Socket socket) {this.socket = socket;} 
    
    @Override
    public void run(){
        
    }
}
