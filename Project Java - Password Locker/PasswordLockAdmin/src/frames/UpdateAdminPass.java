
package frames;

import databaseConection.ConnectionJDBC;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Admin;
import security.Hashing;


public class UpdateAdminPass extends javax.swing.JFrame {
    ArrayList<Admin> adminList = new ArrayList<>(); 
    int adminID;
    
    public UpdateAdminPass(int id,ArrayList<Admin> list) {
        initComponents();
        adminList = list;
        adminID = id;
    }

    public boolean checkOldPassword(){
        boolean ok = false;
        String comparison = txt_UpdateOldPass.getText();
        comparison = Hashing.getHash(comparison.getBytes());
        for(Admin a : adminList){
            if(adminID == a.getId()){
                if(a.getAdminPass().equals(comparison)){
                    ok = true;
                }else{
                    lbl_UpdateNote.setText("Password does not match");
                    lbl_UpdateNote.setVisible(true);               
                }
            }
        }
        return ok;
    }
    
    public boolean newPasswordsMatch(){
        boolean ok = false;
        if(txt_UpdateConfirm.getText().length()>0){
            ok = txt_UpdateNewPass.getText().equals(txt_UpdateConfirm.getText());  
            if(!ok){
                lbl_UpdateNote.setText("new passwords do not match");
                lbl_UpdateNote.setVisible(true);
            }       
        }
        return ok;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        txt_UpdateOldPass = new javax.swing.JTextField();
        txt_UpdateConfirm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btn_UpdateCancelAdmin = new javax.swing.JButton();
        btn_UpdateAdminPass = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbl_UpdateNote = new javax.swing.JLabel();
        txt_UpdateNewPass = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("New Password:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 20));

        txt_UpdateOldPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_UpdateOldPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_UpdateOldPassFocusLost(evt);
            }
        });
        getContentPane().add(txt_UpdateOldPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 231, 20));
        getContentPane().add(txt_UpdateConfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 231, 20));

        jLabel3.setText("Confirm new Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 20));

        btn_UpdateCancelAdmin.setBackground(new java.awt.Color(50, 136, 203));
        btn_UpdateCancelAdmin.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_UpdateCancelAdmin.setForeground(new java.awt.Color(0, 0, 102));
        btn_UpdateCancelAdmin.setText("Cancel");
        btn_UpdateCancelAdmin.setBorder(null);
        btn_UpdateCancelAdmin.setBorderPainted(false);
        btn_UpdateCancelAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_UpdateCancelAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateCancelAdminActionPerformed(evt);
            }
        });
        getContentPane().add(btn_UpdateCancelAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 110, 30));

        btn_UpdateAdminPass.setBackground(new java.awt.Color(50, 136, 203));
        btn_UpdateAdminPass.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_UpdateAdminPass.setForeground(new java.awt.Color(0, 0, 102));
        btn_UpdateAdminPass.setText("Update");
        btn_UpdateAdminPass.setBorder(null);
        btn_UpdateAdminPass.setBorderPainted(false);
        btn_UpdateAdminPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_UpdateAdminPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateAdminPassActionPerformed(evt);
            }
        });
        getContentPane().add(btn_UpdateAdminPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 110, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Update Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 340, 20));

        lbl_UpdateNote.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        lbl_UpdateNote.setForeground(new java.awt.Color(255, 51, 51));
        lbl_UpdateNote.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_UpdateNote.setText("User already exists");
        getContentPane().add(lbl_UpdateNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 260, 20));

        txt_UpdateNewPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_UpdateNewPassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_UpdateNewPassFocusLost(evt);
            }
        });
        getContentPane().add(txt_UpdateNewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 231, 20));

        jLabel5.setText("Old password:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_UpdateCancelAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateCancelAdminActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_UpdateCancelAdminActionPerformed

    private void btn_UpdateAdminPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateAdminPassActionPerformed

        if(newPasswordsMatch()&&checkOldPassword()){
            ConnectionJDBC gestor = new ConnectionJDBC();
            gestor.updateAdminPass(txt_UpdateConfirm.getText(),adminID);
            JOptionPane.showMessageDialog(null,"Password has been updated","Confirmation",JOptionPane.PLAIN_MESSAGE);
            this.dispose();
        }

    }//GEN-LAST:event_btn_UpdateAdminPassActionPerformed

    private void txt_UpdateNewPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_UpdateNewPassFocusGained
       
    }//GEN-LAST:event_txt_UpdateNewPassFocusGained

    private void txt_UpdateNewPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_UpdateNewPassFocusLost
      
    }//GEN-LAST:event_txt_UpdateNewPassFocusLost

    private void txt_UpdateOldPassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_UpdateOldPassFocusGained
        lbl_UpdateNote.setVisible(false);
    }//GEN-LAST:event_txt_UpdateOldPassFocusGained

    private void txt_UpdateOldPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_UpdateOldPassFocusLost
        checkOldPassword();
    }//GEN-LAST:event_txt_UpdateOldPassFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_UpdateAdminPass;
    private javax.swing.JButton btn_UpdateCancelAdmin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_UpdateNote;
    private javax.swing.JTextField txt_UpdateConfirm;
    private javax.swing.JTextField txt_UpdateNewPass;
    private javax.swing.JTextField txt_UpdateOldPass;
    // End of variables declaration//GEN-END:variables
}
