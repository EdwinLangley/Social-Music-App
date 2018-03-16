/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatserver;

import java.io.IOException;

/**
 *
 * @author jcgri
 */
public class ChatServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ChatUI ui = new ChatUI();
        ui.setVisible(true);
        new Thread(new OutboundServer(ui)).start();
        new Thread(new InboundServer(ui)).start();
    }
}
