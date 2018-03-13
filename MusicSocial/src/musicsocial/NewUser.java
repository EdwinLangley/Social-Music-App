package musicsocial;

import DataPacket.*;
import DataPacket.NetworkInterfaces;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Collections.list;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Edwin
 */
public class NewUser extends javax.swing.JFrame {

    
    File attachImage = null;
    /**
     * Creates new form NewUser
     */
    public NewUser() {
        initComponents();

        mandatoryLabel.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox14 = new javax.swing.JCheckBox();
        firstNameTextField = new javax.swing.JTextField();
        newUserTitle = new javax.swing.JLabel();
        firstNameLabel = new javax.swing.JLabel();
        lastNameLabel = new javax.swing.JLabel();
        CreateNewUserButton = new javax.swing.JButton();
        userNameTextField = new javax.swing.JTextField();
        newUserPasswordField = new javax.swing.JPasswordField();
        userNameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        rapCheckBox = new javax.swing.JCheckBox();
        rockCheckBox = new javax.swing.JCheckBox();
        rnbCheckBox = new javax.swing.JCheckBox();
        popCheckBox = new javax.swing.JCheckBox();
        countryCheckBox = new javax.swing.JCheckBox();
        kPopCheckBox = new javax.swing.JCheckBox();
        edmCheckBox = new javax.swing.JCheckBox();
        latinCheckBox = new javax.swing.JCheckBox();
        genresLabel = new javax.swing.JLabel();
        dnbCheckBox = new javax.swing.JCheckBox();
        jazzCheckBox = new javax.swing.JCheckBox();
        technoCheckBox = new javax.swing.JCheckBox();
        altrockCheckBox = new javax.swing.JCheckBox();
        bluesCheckBox = new javax.swing.JCheckBox();
        houseCheckBox = new javax.swing.JCheckBox();
        dubstepCheckBox = new javax.swing.JCheckBox();
        punkCheckBox = new javax.swing.JCheckBox();
        emailLabel = new javax.swing.JLabel();
        SoulCheckBox = new javax.swing.JCheckBox();
        reggaeCheckBox = new javax.swing.JCheckBox();
        funkCheckBox = new javax.swing.JCheckBox();
        metalCheckBox = new javax.swing.JCheckBox();
        lastNameTextField = new javax.swing.JTextField();
        emailField = new javax.swing.JTextField();
        mandatoryLabel = new javax.swing.JLabel();
        ProfilePicButton = new javax.swing.JButton();
        PPLabel = new javax.swing.JLabel();

        jCheckBox14.setText("Rap");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("New User");

        firstNameTextField.setToolTipText("First Name");
        firstNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameTextFieldActionPerformed(evt);
            }
        });

        newUserTitle.setFont(new java.awt.Font("Franklin Gothic Heavy", 0, 36)); // NOI18N
        newUserTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newUserTitle.setText("NEW USER");

        firstNameLabel.setText("FIRST NAME *");

        lastNameLabel.setText("LAST NAME *");

        CreateNewUserButton.setText("CREATE USER");
        CreateNewUserButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreateNewUserButtonMouseClicked(evt);
            }
        });
        CreateNewUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateNewUserButtonActionPerformed(evt);
            }
        });

        userNameTextField.setToolTipText("User Name");
        userNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameTextFieldActionPerformed(evt);
            }
        });

        newUserPasswordField.setToolTipText("Password");

        userNameLabel.setText("USERNAME *");

        passwordLabel.setText("PASSWORD *");

        rapCheckBox.setText("Rap");

        rockCheckBox.setText("Rock");

        rnbCheckBox.setText("R&B");

        popCheckBox.setText("Pop");

        countryCheckBox.setText("Country");

        kPopCheckBox.setText("K-Pop");

        edmCheckBox.setText("EDM");

        latinCheckBox.setText("Latin");

        genresLabel.setText("GENRES");

        dnbCheckBox.setText("D&B");

        jazzCheckBox.setText("Jazz");

        technoCheckBox.setText("Techno");

        altrockCheckBox.setText("Alt-Rock");

        bluesCheckBox.setText("Blues");

        houseCheckBox.setText("House");

        dubstepCheckBox.setText("Dubstep");
        dubstepCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dubstepCheckBoxActionPerformed(evt);
            }
        });

        punkCheckBox.setText("Punk");

        emailLabel.setText("EMAIL *");

        SoulCheckBox.setText("Soul");

        reggaeCheckBox.setText("Reggae");

        funkCheckBox.setText("Funk");

        metalCheckBox.setText("Metal");

        lastNameTextField.setToolTipText("Last Name");
        lastNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastNameTextFieldActionPerformed(evt);
            }
        });

        emailField.setToolTipText("Email");
        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });

        mandatoryLabel.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        mandatoryLabel.setText("These Fields Are Mandatory!");

        ProfilePicButton.setText("Add A Picture");
        ProfilePicButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProfilePicButtonMouseClicked(evt);
            }
        });

        PPLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(315, 315, 315)
                .addComponent(CreateNewUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(passwordLabel)
                                        .addComponent(userNameLabel))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(userNameTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(newUserPasswordField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(firstNameLabel)
                                        .addComponent(lastNameLabel))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(emailLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(mandatoryLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(genresLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rapCheckBox)
                            .addComponent(popCheckBox)
                            .addComponent(kPopCheckBox)
                            .addComponent(latinCheckBox)
                            .addComponent(metalCheckBox))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(funkCheckBox)
                                    .addComponent(rockCheckBox)
                                    .addComponent(rnbCheckBox)
                                    .addComponent(countryCheckBox)
                                    .addComponent(edmCheckBox))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(altrockCheckBox)
                                    .addComponent(jazzCheckBox)
                                    .addComponent(dnbCheckBox)
                                    .addComponent(SoulCheckBox)
                                    .addComponent(technoCheckBox))
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(reggaeCheckBox)
                                    .addComponent(bluesCheckBox)
                                    .addComponent(punkCheckBox)
                                    .addComponent(dubstepCheckBox)
                                    .addComponent(houseCheckBox)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ProfilePicButton)
                                .addGap(32, 32, 32)
                                .addComponent(PPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newUserTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newUserTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ProfilePicButton))
                    .addComponent(PPLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rapCheckBox)
                            .addComponent(rockCheckBox)
                            .addComponent(genresLabel)
                            .addComponent(dnbCheckBox)
                            .addComponent(dubstepCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rnbCheckBox)
                            .addComponent(popCheckBox)
                            .addComponent(jazzCheckBox)
                            .addComponent(punkCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryCheckBox)
                            .addComponent(kPopCheckBox)
                            .addComponent(technoCheckBox)
                            .addComponent(bluesCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(edmCheckBox)
                            .addComponent(latinCheckBox)
                            .addComponent(altrockCheckBox)
                            .addComponent(houseCheckBox))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(funkCheckBox)
                            .addComponent(SoulCheckBox)
                            .addComponent(metalCheckBox)
                            .addComponent(reggaeCheckBox))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(firstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(firstNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lastNameLabel)
                            .addComponent(lastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(userNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNameLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(newUserPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailLabel)
                            .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(mandatoryLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CreateNewUserButton)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void firstNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameTextFieldActionPerformed

    private void CreateNewUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateNewUserButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CreateNewUserButtonActionPerformed

    private void userNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameTextFieldActionPerformed

    private void dubstepCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dubstepCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dubstepCheckBoxActionPerformed

    private void CreateNewUserButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreateNewUserButtonMouseClicked

        ArrayList<String> genreList = new ArrayList<>();
        ArrayList<String> infoArray = new ArrayList<>();
        String newFirstName;
        String newLastName;
        String newUserName;
        String newEmail;

        newFirstName = firstNameTextField.getText();
        newLastName = lastNameTextField.getText();
        newUserName = userNameTextField.getText();
        newEmail = emailField.getText();
        String newPassword = new String(newUserPasswordField.getPassword());

        genreList = takeCheckBoxGenres();

        infoArray = constructInfoArray(newFirstName, newLastName, newUserName, newEmail, newPassword, genreList);
        UserData newUser = null;
        try {
            newUser = new UserData(0, newUserName, newPassword, newFirstName, newLastName, newEmail, genreList,attachImage);
        } catch (UnknownHostException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(infoArray);

        //DataPacket genreDataPacket = new DataPacket();
        //genreDataPacket.buildDataPacket("REG", null ,infoArray);
        DataPacket genreDataPacket = new DataPacket("REG");
        System.out.println(genreDataPacket.getCommand());
//        ServerNetworkInterface sendData = new ServerNetworkInterface();
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        Socket socket = null;
        try {
            socket = new Socket(address, 9090);
            //Send multiple bits of data over same socket connection should always be in pairs
            //First DataPacket preps server
            //Second sends data
            //Only close socket afterwards
            NetworkInterfaces.SendDataPacket(socket, genreDataPacket);
            NetworkInterfaces.SendUserData(socket, newUser);
        } catch (IOException ex) {
            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
        }

//        sendData.sendData(genreDataPacket);
        if (compulsoryFieldsFull() == false) {
            this.dispose();
            try {
                new MusicSocialUI(newUserName).setVisible(true);
            } catch (IOException ex) {
                Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            mandatoryLabel.setVisible(true);
        }
    }//GEN-LAST:event_CreateNewUserButtonMouseClicked

    private void lastNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastNameTextFieldActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void ProfilePicButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProfilePicButtonMouseClicked
        JFileChooser fChooser = new JFileChooser();
        fChooser.showOpenDialog(null);
        attachImage = fChooser.getSelectedFile();
        String filename = attachImage.getAbsolutePath();
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image dimg = img.getScaledInstance(PPLabel.getWidth(), PPLabel.getHeight(),
                Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(dimg);
        PPLabel.setIcon(icon);
    }//GEN-LAST:event_ProfilePicButtonMouseClicked

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
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateNewUserButton;
    private javax.swing.JLabel PPLabel;
    private javax.swing.JButton ProfilePicButton;
    private javax.swing.JCheckBox SoulCheckBox;
    private javax.swing.JCheckBox altrockCheckBox;
    private javax.swing.JCheckBox bluesCheckBox;
    private javax.swing.JCheckBox countryCheckBox;
    private javax.swing.JCheckBox dnbCheckBox;
    private javax.swing.JCheckBox dubstepCheckBox;
    private javax.swing.JCheckBox edmCheckBox;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel firstNameLabel;
    private javax.swing.JTextField firstNameTextField;
    private javax.swing.JCheckBox funkCheckBox;
    private javax.swing.JLabel genresLabel;
    private javax.swing.JCheckBox houseCheckBox;
    private javax.swing.JCheckBox jCheckBox14;
    private javax.swing.JCheckBox jazzCheckBox;
    private javax.swing.JCheckBox kPopCheckBox;
    private javax.swing.JLabel lastNameLabel;
    private javax.swing.JTextField lastNameTextField;
    private javax.swing.JCheckBox latinCheckBox;
    private javax.swing.JLabel mandatoryLabel;
    private javax.swing.JCheckBox metalCheckBox;
    private javax.swing.JPasswordField newUserPasswordField;
    private javax.swing.JLabel newUserTitle;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JCheckBox popCheckBox;
    private javax.swing.JCheckBox punkCheckBox;
    private javax.swing.JCheckBox rapCheckBox;
    private javax.swing.JCheckBox reggaeCheckBox;
    private javax.swing.JCheckBox rnbCheckBox;
    private javax.swing.JCheckBox rockCheckBox;
    private javax.swing.JCheckBox technoCheckBox;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JTextField userNameTextField;
    // End of variables declaration//GEN-END:variables

    private boolean compulsoryFieldsFull() {
        boolean wasItEmpty;

        if (firstNameTextField.getText().isEmpty() || lastNameTextField.getText().isEmpty()
                || userNameTextField.getText().isEmpty() || newUserPasswordField.getPassword().length == 0
                || emailField.getText().isEmpty()) {
            wasItEmpty = true;
        } else {
            wasItEmpty = false;
        }

        return wasItEmpty;
    }

    private ArrayList<String> takeCheckBoxGenres() {

        ArrayList<String> genreList = new ArrayList<>();

        if (rapCheckBox.isSelected()) {
            genreList.add("rap");
        }
        if (rockCheckBox.isSelected()) {
            genreList.add("rock");
        }
        if (rnbCheckBox.isSelected()) {
            genreList.add("rnb");
        }
        if (popCheckBox.isSelected()) {
            genreList.add("pop");
        }
        if (countryCheckBox.isSelected()) {
            genreList.add("country");
        }
        if (kPopCheckBox.isSelected()) {
            genreList.add("kPop");
        }
        if (edmCheckBox.isSelected()) {
            genreList.add("edm");
        }
        if (latinCheckBox.isSelected()) {
            genreList.add("latin");
        }
        if (dnbCheckBox.isSelected()) {
            genreList.add("dnb");
        }
        if (jazzCheckBox.isSelected()) {
            genreList.add("jazz");
        }
        if (technoCheckBox.isSelected()) {
            genreList.add("techno");
        }
        if (altrockCheckBox.isSelected()) {
            genreList.add("alt rock");
        }
        if (bluesCheckBox.isSelected()) {
            genreList.add("blues");
        }
        if (houseCheckBox.isSelected()) {
            genreList.add("house");
        }
        if (dubstepCheckBox.isSelected()) {
            genreList.add("dubstep");
        }
        if (punkCheckBox.isSelected()) {
            genreList.add("punk");
        }
        if (SoulCheckBox.isSelected()) {
            genreList.add("Soul");
        }
        if (reggaeCheckBox.isSelected()) {
            genreList.add("reggae");
        }
        if (funkCheckBox.isSelected()) {
            genreList.add("funk");
        }
        if (metalCheckBox.isSelected()) {
            genreList.add("metal");
        }

        return genreList;

    }

    private ArrayList<String> constructInfoArray(String newFirstName, String newLastName, String newUserName, String newEmail, String newPassword, ArrayList<String> genreList) {

        ArrayList<String> infoArray = new ArrayList<>();

        infoArray.add(newFirstName);
        infoArray.add(newLastName);
        infoArray.add(newUserName);
        infoArray.add(newPassword);
        infoArray.add(newEmail);

        for (String item : genreList) {
            infoArray.add(item);
        }

        return infoArray;
    }
}
