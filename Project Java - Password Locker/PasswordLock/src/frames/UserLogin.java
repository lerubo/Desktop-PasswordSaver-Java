
package frames;

import databaseConection.ConnectionJDBC;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


public class UserLogin extends javax.swing.JFrame {
    boolean correctUser = false;
    boolean correctPassword = false;
    boolean login = false;
    
    int chosenAccount;          //para test
    
    public UserLogin() {
        initComponents();
        lbl_UserMissing.setVisible(false);
        lbl_InvalidPass.setVisible(false);
    }

    public static void main(String[] args){
       UserLogin ul = new UserLogin();
       ul.setLocationRelativeTo(null);
       ul.setVisible(true);       
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_LoginImage = new javax.swing.JLabel();
        lbl_BlueUser = new javax.swing.JLabel();
        lbl_UserMissing = new javax.swing.JLabel();
        tb_Username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbl_BluePass = new javax.swing.JLabel();
        lbl_InvalidPass = new javax.swing.JLabel();
        tb_Password = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        bt_SignIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(400, 600));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_LoginImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/logo.png"))); // NOI18N
        getContentPane().add(lbl_LoginImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, -1, -1));

        lbl_BlueUser.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        lbl_BlueUser.setForeground(new java.awt.Color(50, 136, 203));
        lbl_BlueUser.setText("Username:");
        getContentPane().add(lbl_BlueUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 100, 20));

        lbl_UserMissing.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        lbl_UserMissing.setForeground(new java.awt.Color(255, 51, 51));
        lbl_UserMissing.setText("Does not exist");
        getContentPane().add(lbl_UserMissing, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, -1, -1));

        tb_Username.setBackground(new java.awt.Color(240, 240, 240));
        tb_Username.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_Username.setForeground(new java.awt.Color(102, 102, 102));
        tb_Username.setText("Enter a username");
        tb_Username.setToolTipText("");
        tb_Username.setBorder(null);
        tb_Username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tb_UsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tb_UsernameFocusLost(evt);
            }
        });
        tb_Username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tb_UsernameActionPerformed(evt);
            }
        });
        tb_Username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_UsernameKeyPressed(evt);
            }
        });
        getContentPane().add(tb_Username, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 210, 40));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/user.png"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 30, 30));

        lbl_BluePass.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        lbl_BluePass.setForeground(new java.awt.Color(50, 136, 203));
        lbl_BluePass.setText("Password:");
        getContentPane().add(lbl_BluePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));

        lbl_InvalidPass.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        lbl_InvalidPass.setForeground(new java.awt.Color(255, 51, 51));
        lbl_InvalidPass.setText("Invalid");
        getContentPane().add(lbl_InvalidPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 410, -1, -1));

        tb_Password.setBackground(new java.awt.Color(240, 240, 240));
        tb_Password.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tb_Password.setForeground(new java.awt.Color(102, 102, 102));
        tb_Password.setText("......");
        tb_Password.setBorder(null);
        tb_Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tb_PasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tb_PasswordFocusLost(evt);
            }
        });
        tb_Password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tb_PasswordKeyPressed(evt);
            }
        });
        getContentPane().add(tb_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 150, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/password.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, -1, 30));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, 180, 20));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 180, 20));

        bt_SignIn.setBackground(new java.awt.Color(50, 136, 203));
        bt_SignIn.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        bt_SignIn.setForeground(new java.awt.Color(255, 255, 255));
        bt_SignIn.setText("Sign in");
        bt_SignIn.setBorder(null);
        bt_SignIn.setBorderPainted(false);
        bt_SignIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_SignIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_SignInActionPerformed(evt);
            }
        });
        bt_SignIn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bt_SignInKeyPressed(evt);
            }
        });
        getContentPane().add(bt_SignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 500, 100, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tb_UsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb_UsernameFocusGained
       
        if(tb_Username.getText().equals("Enter a username")){
            tb_Username.setText("");
        }

    }//GEN-LAST:event_tb_UsernameFocusGained

    private void tb_UsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb_UsernameFocusLost
       
        if(tb_Username.getText().length() == 0){
            tb_Username.setText("Enter a username");
        }else{
            try {
                ConnectionJDBC gestor = new ConnectionJDBC();
                int count = gestor.checkUsername(tb_Username.getText());
                if (count == 0 ){
                    lbl_UserMissing.setVisible(true);
                    correctUser = false;
                }else{
                    lbl_UserMissing.setVisible(false);
                    correctUser = true;
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
    }//GEN-LAST:event_tb_UsernameFocusLost

    private void tb_UsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_UsernameKeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            tb_Password.requestFocus();
        }
    }//GEN-LAST:event_tb_UsernameKeyPressed

    private void tb_PasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb_PasswordFocusGained
        
        if(tb_Password.getText().equals("......")){
            tb_Password.setText("");
        }

    }//GEN-LAST:event_tb_PasswordFocusGained

    private void tb_PasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tb_PasswordFocusLost
        
        if(tb_Password.getText().length() == 0){
            tb_Password.setText("......");
        }else{
            try {
                ConnectionJDBC gestor = new ConnectionJDBC();
                int count = gestor.checkCredentials(tb_Username.getText(),tb_Password.getText());
                if (count == 0 ){
                    lbl_InvalidPass.setVisible(true);
                    correctPassword = false;
                }else{
                    lbl_InvalidPass.setVisible(false);
                    correctPassword = true;
                    chosenAccount = gestor.loadID(tb_Username.getText(), tb_Password.getText());
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_tb_PasswordFocusLost

    private void tb_PasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tb_PasswordKeyPressed
       
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(tb_Password.getText().length() == 0){
            tb_Password.setText("......");
        }else{
            try {
                ConnectionJDBC gestor = new ConnectionJDBC();
                int count = gestor.checkCredentials(tb_Username.getText(),tb_Password.getText());
                if (count == 0 ){
                    lbl_InvalidPass.setVisible(true);
                    correctPassword = false;
                }else{
                    lbl_InvalidPass.setVisible(false);
                    correctPassword = true;
                    chosenAccount = gestor.loadID(tb_Username.getText(), tb_Password.getText());
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        bt_SignIn.doClick();
        }
    }//GEN-LAST:event_tb_PasswordKeyPressed

    private void tb_UsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tb_UsernameActionPerformed
        
    }//GEN-LAST:event_tb_UsernameActionPerformed

    private void bt_SignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_SignInActionPerformed
        
        if(correctUser && correctPassword){ 
            try {
                PasswordManagerScreen pms;
                pms = new PasswordManagerScreen(chosenAccount);
                pms.setLocationRelativeTo(null);
                pms.setVisible(true);
                tb_Username.setText("");
                tb_Password.setText("");
            } catch (NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | IOException | BadPaddingException | SQLException | InvalidKeySpecException ex) {
                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
    }//GEN-LAST:event_bt_SignInActionPerformed

    private void bt_SignInKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bt_SignInKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(correctUser && correctPassword){
            try {
                PasswordManagerScreen pms = new PasswordManagerScreen(chosenAccount);
                pms.setLocationRelativeTo(null);
                pms.setVisible(true);
                tb_Username.setText("");
                tb_Password.setText("");               
            } catch (SQLException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException | IllegalBlockSizeException | IOException | BadPaddingException | InvalidKeySpecException ex) {
                Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
    }//GEN-LAST:event_bt_SignInKeyPressed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_SignIn;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_BluePass;
    private javax.swing.JLabel lbl_BlueUser;
    private javax.swing.JLabel lbl_InvalidPass;
    private javax.swing.JLabel lbl_LoginImage;
    private javax.swing.JLabel lbl_UserMissing;
    private javax.swing.JPasswordField tb_Password;
    private javax.swing.JTextField tb_Username;
    // End of variables declaration//GEN-END:variables
}
