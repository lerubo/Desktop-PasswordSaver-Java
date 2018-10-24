
package frames;

import databaseConection.ConnectionJDBC;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import models.Password;


public class UpdatePassword extends javax.swing.JFrame {
    Password selectedPassword;
 
    public UpdatePassword(Password p ) {
        initComponents();
        selectedPassword = p;
        txt_UpdateName.setText(selectedPassword.getPassName());
        txt_UpdatePass.setText(new String(selectedPassword.getPass()));
        txt_UpdateDescription.setText(selectedPassword.getPassDescription());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_UpdateName = new javax.swing.JTextField();
        txt_UpdatePass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_UpdateDescription = new javax.swing.JTextArea();
        btn_UpdateCancel = new javax.swing.JButton();
        btn_UpdateAccept = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(430, 300));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Description:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, 20));

        jLabel2.setText("Name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, 20));
        getContentPane().add(txt_UpdateName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 231, 20));
        getContentPane().add(txt_UpdatePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 231, 20));

        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, 20));

        txt_UpdateDescription.setColumns(20);
        txt_UpdateDescription.setRows(5);
        jScrollPane1.setViewportView(txt_UpdateDescription);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 230, -1));

        btn_UpdateCancel.setBackground(new java.awt.Color(50, 136, 203));
        btn_UpdateCancel.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_UpdateCancel.setForeground(new java.awt.Color(0, 0, 102));
        btn_UpdateCancel.setText("Cancel");
        btn_UpdateCancel.setBorder(null);
        btn_UpdateCancel.setBorderPainted(false);
        btn_UpdateCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_UpdateCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_UpdateCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 110, 30));

        btn_UpdateAccept.setBackground(new java.awt.Color(50, 136, 203));
        btn_UpdateAccept.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_UpdateAccept.setForeground(new java.awt.Color(0, 0, 102));
        btn_UpdateAccept.setText("Update");
        btn_UpdateAccept.setBorder(null);
        btn_UpdateAccept.setBorderPainted(false);
        btn_UpdateAccept.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_UpdateAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateAcceptActionPerformed(evt);
            }
        });
        getContentPane().add(btn_UpdateAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 110, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Update Password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 200, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_UpdateCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_UpdateCancelActionPerformed

    private void btn_UpdateAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateAcceptActionPerformed
        try {
            ConnectionJDBC gestor = new ConnectionJDBC();
            Password pu = new Password();
            pu.setPassName(txt_UpdateName.getText());
            pu.setPass(txt_UpdatePass.getText().getBytes());
            pu.setPassDescription(txt_UpdateDescription.getText());
            gestor.updatePassword(pu,selectedPassword.getPid());
            JOptionPane.showMessageDialog(null,"Password updated","Confirmation",JOptionPane.PLAIN_MESSAGE);
            this.dispose();
        } catch (IOException | NoSuchAlgorithmException | InvalidKeySpecException | IllegalBlockSizeException | NoSuchPaddingException | InvalidKeyException | BadPaddingException ex) {
            Logger.getLogger(UpdatePassword.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btn_UpdateAcceptActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_UpdateAccept;
    private javax.swing.JButton btn_UpdateCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_UpdateDescription;
    private javax.swing.JTextField txt_UpdateName;
    private javax.swing.JTextField txt_UpdatePass;
    // End of variables declaration//GEN-END:variables
}
