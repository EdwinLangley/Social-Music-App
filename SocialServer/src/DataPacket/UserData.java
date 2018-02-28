/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataPacket;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author jcgri
 */
public class UserData extends LoginData {

    public String firstName, lastName, email;
    public ArrayList<String> genreList;
    public byte[] profileImage;

    public void buildByteArray(File inputImage) {
        ByteArrayOutputStream baos = null;
        try {
            FileInputStream inputImageStream = new FileInputStream(inputImage);
            baos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            for (int len; (len = inputImageStream.read(buffer)) != -1;) {
                baos.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e2) {
            System.err.println(e2.getMessage());
        }
        this.profileImage = baos != null ? baos.toByteArray() : null;
        //return baos != null ? baos.toByteArray() : null;
    }

    public BufferedImage buildImage(byte[] inputArray) throws IOException {
        BufferedImage returnImage = ImageIO.read(new ByteArrayInputStream(inputArray));
        return returnImage;
    }

}
