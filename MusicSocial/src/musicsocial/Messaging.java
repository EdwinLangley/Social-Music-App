package musicsocial;

import DataPacket.ChatData;
import DataPacket.ChatMessages;
import DataPacket.DataPacket;
import DataPacket.MainPageData;
import DataPacket.NetworkInterfaces;
import DataPacket.UserData;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javazoom.jl.converter.Converter;
import javazoom.jl.decoder.JavaLayerException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edwin
 */
public class Messaging extends javax.swing.JFrame {

    MainPageData mpd;
    DefaultListModel friendsModel = new DefaultListModel();
    String CurrentUser = "";
    UserData sendToUser = null;
    
    
    File attachImage = null;
    String artFilename = "";
    String extension = "";


    /**
     * Creates new form Messaging
     */
    public Messaging() {
        initComponents();

    }

    public Messaging(String UserName, UserData sendTo) throws IOException {
        initComponents();

        CurrentUser = UserName;
        sendToUser = sendTo;

        ChatLabel.setText("Chat: " + CurrentUser + " to " + sendToUser.username);
        this.setTitle("Chat: " + CurrentUser + " to " + sendToUser.username);

        setUserInfo();

        //File ImgDir = new File("IMG/" + userInfo.username + ".png");
        // String dbPathIMG = "IMG/" + userInfo.username + ".png";
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
//                        Socket someSocket;
                        Socket inboundSocket;
                        try {
//                            someSocket = new Socket(InetAddress.getLocalHost(), 9091);
                            inboundSocket = new Socket(InetAddress.getLocalHost(), 9092);
                            DataPacket chatRequest = new DataPacket("REC", CurrentUser, sendToUser.username);

                            NetworkInterfaces.SendDataPacket(inboundSocket, chatRequest);
                            ChatMessages chatData = NetworkInterfaces.RecieveChat(inboundSocket);

                            if (!chatData.isEmpty) {
                                chatData.messages.forEach((message) -> {
                                    TextReadArea.append(sendToUser.username + ":\t" + message.mesageContent + "\n");
                                    if (message.image != null) {
                                        //JOptionPane.showMessageDialog(null, "Data");
                                        try {
                                            File ImageDir = new File("./src/images/chatimage.png");

                                            byte[] imageData = message.image;
                                            FileOutputStream retreievdClientimage = new FileOutputStream(ImageDir);
                                            retreievdClientimage.write(imageData);
                                        } catch (IOException ex) {
                                            Logger.getLogger(Messaging.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        int reply = JOptionPane.showConfirmDialog(null, "An image has been recieved. Would you like to view it now?", "Display Image", JOptionPane.YES_NO_OPTION);
                                        if (reply == JOptionPane.YES_OPTION) {
                                            BufferedImage imageBuff = null;
                                            try {
                                                imageBuff = ImageIO.read(new File("./src/images/chatimage.png"));
                                            } catch (IOException ex) {
                                                Logger.getLogger(Messaging.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            JLabel picLabel = new JLabel(new ImageIcon(imageBuff));
                                            JOptionPane.showMessageDialog(null, picLabel, "Image", JOptionPane.PLAIN_MESSAGE, null);
                                        } else {

                                        }
                                    }
                                });
                            }
                            inboundSocket.close();
                        } catch (UnknownHostException ex) {
                            Logger.getLogger(Messaging.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Messaging.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } catch (InterruptedException ex) {
                        Logger.getLogger(Messaging.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            }
        }).start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        MessageComposerField = new javax.swing.JScrollPane();
        TextComposeArea = new javax.swing.JTextArea();
        SendButton = new javax.swing.JButton();
        AttatchmentButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TextReadArea = new javax.swing.JTextArea();
        ChatLabel = new javax.swing.JLabel();
        PPLabel = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        secondNameLabel = new javax.swing.JLabel();
        genreLabel = new javax.swing.JLabel();

        jButton1.setText("SEND");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chat");
        setResizable(false);

        TextComposeArea.setColumns(20);
        TextComposeArea.setRows(5);
        MessageComposerField.setViewportView(TextComposeArea);

        SendButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/send.png"))); // NOI18N
        SendButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SendButtonMouseClicked(evt);
            }
        });
        SendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SendButtonActionPerformed(evt);
            }
        });

        AttatchmentButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/attatchment.png"))); // NOI18N
        AttatchmentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AttatchmentButtonMouseClicked(evt);
            }
        });
        AttatchmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AttatchmentButtonActionPerformed(evt);
            }
        });

        TextReadArea.setEditable(false);
        TextReadArea.setColumns(20);
        TextReadArea.setRows(5);
        jScrollPane2.setViewportView(TextReadArea);

        ChatLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        ChatLabel.setText("Chat");

        PPLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        firstNameLabel.setText("jLabel1");

        secondNameLabel.setText("jLabel2");

        genreLabel.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(MessageComposerField, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AttatchmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ChatLabel)
                            .addComponent(firstNameLabel)
                            .addComponent(secondNameLabel)
                            .addComponent(genreLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ChatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(firstNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(secondNameLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genreLabel)
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(AttatchmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SendButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(MessageComposerField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void initTableListeners() {

    }

    private void setUserInfo() throws FileNotFoundException, IOException {
        File ImgDir = new File("src/images/" + "talkingToUser" + ".png");
        String toPullFrom = "src/images/" + "talkingToUser" + ".png";
        
        byte[] artData = sendToUser.image;
        FileOutputStream retreievdAlbumArt = new FileOutputStream(ImgDir);
        retreievdAlbumArt.write(artData);
        
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(toPullFrom));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(PPLabel.getWidth(), PPLabel.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        PPLabel.setIcon(icon);
        
        firstNameLabel.setText("First Name: " + sendToUser.firstName);
        secondNameLabel.setText("Last Name: " + sendToUser.lastName);
        genreLabel.setText("Genres: " + sendToUser.genreListString);
    }

    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SendButtonActionPerformed

    private void AttatchmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttatchmentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AttatchmentButtonActionPerformed

    private void SendButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendButtonMouseClicked
        String composedMessage = TextComposeArea.getText();
        TextComposeArea.setText("");
        if (!composedMessage.matches("") && !sendToUser.username.matches("")) {
            TextReadArea.append(CurrentUser + ":\t" + composedMessage + "\n");
            

            Socket someSocket = null;
            
            byte[] artDataByteArray = null;
            FileInputStream AlbumArt;
            
            try {

                AlbumArt = new FileInputStream(artFilename);
                artDataByteArray = new byte[AlbumArt.available()];
                AlbumArt.read(artDataByteArray);

            } catch (FileNotFoundException ex) { 
                Logger.getLogger(Messaging.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Messaging.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ChatData chatData = new ChatData(CurrentUser, sendToUser.username, composedMessage, extension, artDataByteArray);

            try {
                someSocket = new Socket(InetAddress.getLocalHost(), 9091);
                DataPacket chatRequest = new DataPacket("SND", CurrentUser);
                NetworkInterfaces.SendDataPacket(someSocket, chatRequest);
                NetworkInterfaces.SendChat(someSocket, chatData);
            } catch (UnknownHostException ex) {
                Logger.getLogger(Messaging.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Messaging.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_SendButtonMouseClicked

    private void AttatchmentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AttatchmentButtonMouseClicked
        JFileChooser fChooser = new JFileChooser();
        fChooser.showOpenDialog(null);
        
        attachImage = fChooser.getSelectedFile();
        artFilename = attachImage.getAbsolutePath();

        extension = getFileExtension(attachImage);

        if ((extension.equals("png"))) {
            attachImage = fChooser.getSelectedFile();
            artFilename = attachImage.getAbsolutePath();

        } else {
            attachImage = null;
            JOptionPane.showMessageDialog(null, "Only png files please!");
        }
    }//GEN-LAST:event_AttatchmentButtonMouseClicked

    
    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Messaging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Messaging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Messaging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Messaging.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Messaging().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AttatchmentButton;
    private javax.swing.JLabel ChatLabel;
    private javax.swing.JScrollPane MessageComposerField;
    private javax.swing.JLabel PPLabel;
    private javax.swing.JButton SendButton;
    private javax.swing.JTextArea TextComposeArea;
    private javax.swing.JTextArea TextReadArea;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JLabel genreLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel secondNameLabel;
    // End of variables declaration//GEN-END:variables
}
