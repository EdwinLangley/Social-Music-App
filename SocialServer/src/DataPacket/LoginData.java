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
public class LoginData extends DataPacket {

    public String username, passsword;

    public LoginData() {
    }

    public LoginData(String username, String password) {
        this.Command = "LoginData";
        this.username = username;
        this.passsword = password;
    }
}
