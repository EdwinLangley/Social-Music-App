/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * @author jcgri
 */
public class LoginData extends DataPacket {

    public String username, passsword;
    public InetAddress IPAddress;

    public LoginData() {
    }

    public LoginData(String username, String password) throws UnknownHostException {
        this.command = "LoginData";
        this.username = username;
        this.passsword = password;
        this.IPAddress = InetAddress.getLocalHost();
    }
}
