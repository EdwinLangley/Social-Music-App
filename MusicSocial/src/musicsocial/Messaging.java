package musicsocial;

import DataPacket.ChatData;
import DataPacket.ChatMessages;
import DataPacket.DataPacket;
import DataPacket.MainPageData;
import DataPacket.NetworkInterfaces;
import DataPacket.UserData;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

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
    String sendToUser = "";

    /**
     * Creates new form Messaging
     */
    public Messaging() {
        initComponents();

    }

    public Messaging(String UserName, String sendTo) {
        initComponents();

        CurrentUser = UserName;
        sendToUser = sendTo;
        
        ChatLabel.setText("Chat: " + CurrentUser + " to " +sendToUser );
        this.setTitle("Chat: " + CurrentUser + " to " +sendToUser );

        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(2000);
                        Socket someSocket;
                        Socket inboundSocket;
                        try {
//                            someSocket = new Socket(InetAddress.getLocalHost(), 9091);
                            inboundSocket = new Socket(InetAddress.getLocalHost(),9092);
                            DataPacket chatRequest = new DataPacket("REC", CurrentUser, sendToUser);
                            NetworkInterfaces.SendDataPacket(inboundSocket, chatRequest);
                            ChatMessages chatData = NetworkInterfaces.RecieveChat(inboundSocket);
                            if (!chatData.isEmpty) {
                                chatData.messages.forEach((message) -> {
                                    TextReadArea.append(sendToUser + ":\t" + message.mesageContent + "\n");
                                });
                            }
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
                        .addGap(38, 38, 38)
                        .addComponent(ChatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(ChatLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
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


    private void SendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SendButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SendButtonActionPerformed

    private void AttatchmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AttatchmentButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AttatchmentButtonActionPerformed

    private void SendButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SendButtonMouseClicked
        String composedMessage = TextComposeArea.getText();
        TextComposeArea.setText("");
        if (!composedMessage.matches("") && !sendToUser.matches("")) {
            TextReadArea.append(CurrentUser + ":\t" + composedMessage + "\n");
            ChatData chatData = new ChatData(CurrentUser, sendToUser, composedMessage);

            Socket someSocket = null;

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
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
