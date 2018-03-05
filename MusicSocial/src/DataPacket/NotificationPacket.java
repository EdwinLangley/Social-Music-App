/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

/**
 *
 * @author jcgri
 */
public class NotificationPacket extends DataPacket {

    public String notification;

    public NotificationPacket(String notification, String Command) {
        super(Command);
        this.notification = notification;
    }
    
   
    public NotificationPacket(String notification) {
        this.notification = notification;
    }

    public NotificationPacket() {
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
