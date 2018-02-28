/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileTransfer;
import java.io.File;
/**
 *
 * @author jcgri
 */
public class FileTransfer {
    java.net.InetAddress IPAddress;
    String filepath; 
    public void setUpFileTransfer(java.net.Socket socket, String filepath){this.IPAddress=socket.getInetAddress();this.filepath=filepath;}
    private File createFile (String filepath){
        File returnFile= new File(filepath);
        return returnFile;
    }
    public void transferFile(){
        
    }

}
