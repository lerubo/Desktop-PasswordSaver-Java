
package frames;

import databaseConection.ConnectionJDBC;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Admin;
import security.Hashing;

public class NewAdminAccount extends javax.swing.JFrame {
    ArrayList<Admin> adminList = new ArrayList<>(); //to check it doesn't already exist
    final int adminID;
   
    public NewAdminAccount(int id,ArrayList<Admin> list) {
        initComponents();        
        adminID = id;
        adminList = list;
        
        lbl_UserExists.setVisible(false);
    }

    public boolean checkUsername(){
        boolean exists = false;
        String value = Hashing.getHash(txt_NewAdUser.getText().getBytes());
        for(Admin a : adminList){
           if(a.getUserAdmin().equals(value)){
               exists = true;
           } 
        }          
    return exists;
    }
   
    public boolean passwordOK(){
        boolean ok = false;
        if(txt_NewAdPass.getText().length() > 4){
            ok = true;
            
        }else{
            lbl_UserExists.setText("Password too short");
            lbl_UserExists.setVisible(true);
                   
        }
        return ok;
    }
    
    public boolean userOK(){
         boolean ok = false;
        if(txt_NewAdUser.getText().length() > 0){
            ok = true;
            
        }else{
            lbl_UserExists.setText("Need to enter a username");
            lbl_UserExists.setVisible(true);
        }
        return ok;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txt_NewAdUser = new javax.swing.JTextField();
        txt_NewAdPass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_NewAdminCancel = new javax.swing.JButton();
        btn_NewCreateAdmin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_UserExists = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("New username:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        txt_NewAdUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_NewAdUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_NewAdUserFocusLost(evt);
            }
        });
        getContentPane().add(txt_NewAdUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 231, 20));
        getContentPane().add(txt_NewAdPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 231, 20));

        jLabel3.setText("Enter the password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        btn_NewAdminCancel.setBackground(new java.awt.Color(50, 136, 203));
        btn_NewAdminCancel.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_NewAdminCancel.setForeground(new java.awt.Color(0, 0, 102));
        btn_NewAdminCancel.setText("Cancel");
        btn_NewAdminCancel.setBorder(null);
        btn_NewAdminCancel.setBorderPainted(false);
        btn_NewAdminCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_NewAdminCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NewAdminCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_NewAdminCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 110, 30));

        btn_NewCreateAdmin.setBackground(new java.awt.Color(50, 136, 203));
        btn_NewCreateAdmin.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_NewCreateAdmin.setForeground(new java.awt.Color(0, 0, 102));
        btn_NewCreateAdmin.setText("Create Admin");
        btn_NewCreateAdmin.setBorder(null);
        btn_NewCreateAdmin.setBorderPainted(false);
        btn_NewCreateAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_NewCreateAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NewCreateAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btn_NewCreateAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 110, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Create new Admin");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 340, 20));

        lbl_UserExists.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        lbl_UserExists.setForeground(new java.awt.Color(255, 51, 51));
        lbl_UserExists.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_UserExists.setText("User already exists");
        getContentPane().add(lbl_UserExists, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 260, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NewAdminCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NewAdminCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_NewAdminCancelActionPerformed

    private void btn_NewCreateAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NewCreateAdminActionPerformed
        
        if(passwordOK()&&userOK()&&(!checkUsername())){
        ConnectionJDBC gestor = new ConnectionJDBC();
        gestor.insertAdmin(new Admin(txt_NewAdUser.getText(),txt_NewAdPass.getText()));
        JOptionPane.showMessageDialog(null,"NEW ADMIN HAS BEEN CREATED","Confirmation",JOptionPane.PLAIN_MESSAGE);
        this.dispose();
        }
        
    }//GEN-LAST:event_btn_NewCreateAdminActionPerformed

    private void txt_NewAdUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_NewAdUserFocusLost
      if(checkUsername()){
         lbl_UserExists.setVisible(true);
         lbl_UserExists.setText("user already exists");
      }
    }//GEN-LAST:event_txt_NewAdUserFocusLost

    private void txt_NewAdUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_NewAdUserFocusGained
        lbl_UserExists.setVisible(false);
    }//GEN-LAST:event_txt_NewAdUserFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_NewAdminCancel;
    private javax.swing.JButton btn_NewCreateAdmin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lbl_UserExists;
    private javax.swing.JTextField txt_NewAdPass;
    private javax.swing.JTextField txt_NewAdUser;
    // End of variables declaration//GEN-END:variables
}
