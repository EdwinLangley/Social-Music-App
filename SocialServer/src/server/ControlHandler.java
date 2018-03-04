/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import DataPacket.*;
import Database.SQLiteJDBCDriverConnection;
import java.io.IOException;
import java.sql.SQLException;

/**
 *
 * @author jcgri
 *
 * Contains a list of static methods that are used to control data flow for the
 * server Is only used in the switch statement in ClientNetworkInterface
 *
 */
public class ControlHandler {

    public static SQLiteJDBCDriverConnection databaseCheck = new SQLiteJDBCDriverConnection();
    
    public static void RegisterUser(UserData userInfo) throws IOException, SQLException {
        String imageInfo=new String(userInfo.image);
        databaseCheck.insertUser(userInfo.firstName, userInfo.lastName, userInfo.username, userInfo.email, userInfo.genreListString, imageInfo);
    }

    public static boolean Login(LoginData loginInfo) throws IOException, SQLException {
        
        return databaseCheck.isGoodLogin(loginInfo.username, loginInfo.passsword) == true;
    }

    public static void SearchForFriendRecommendations() {

    }
}
