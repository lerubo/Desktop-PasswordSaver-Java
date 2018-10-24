
package frames;

import databaseConection.ConnectionJDBC;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import models.Password;



public class NewPassword extends javax.swing.JFrame {
    ArrayList<Password> passwordList = new ArrayList<>(); //to check it doesn't already exist
    final int ID;
    byte[] secretKey;
   
    public NewPassword(ArrayList<Password> list, int id) {
        initComponents();
        passwordList = list;
        ID = id;
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_NewName = new javax.swing.JTextField();
        txt_NewPass = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_NewDescription = new javax.swing.JTextArea();
        btn_NewCancel = new javax.swing.JButton();
        btn_NewAccept = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Description:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, 20));

        jLabel2.setText("Write a related name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));
        getContentPane().add(txt_NewName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 231, 20));
        getContentPane().add(txt_NewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 231, 20));

        jLabel3.setText("Enter the password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 20));

        txt_NewDescription.setColumns(20);
        txt_NewDescription.setRows(5);
        jScrollPane1.setViewportView(txt_NewDescription);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 230, -1));

        btn_NewCancel.setBackground(new java.awt.Color(50, 136, 203));
        btn_NewCancel.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_NewCancel.setForeground(new java.awt.Color(0, 0, 102));
        btn_NewCancel.setText("Cancel");
        btn_NewCancel.setBorder(null);
        btn_NewCancel.setBorderPainted(false);
        btn_NewCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_NewCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NewCancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_NewCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, 110, 30));

        btn_NewAccept.setBackground(new java.awt.Color(50, 136, 203));
        btn_NewAccept.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_NewAccept.setForeground(new java.awt.Color(0, 0, 102));
        btn_NewAccept.setText("Add Password");
        btn_NewAccept.setBorder(null);
        btn_NewAccept.setBorderPainted(false);
        btn_NewAccept.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_NewAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NewAcceptActionPerformed(evt);
            }
        });
        getContentPane().add(btn_NewAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 110, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("New password");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 130, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_NewCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NewCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btn_NewCancelActionPerformed

    private void btn_NewAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NewAcceptActionPerformed
        try {
            ConnectionJDBC gestor = new ConnectionJDBC();
            gestor.insertPassword(new Password(txt_NewName.getText(),txt_NewPass.getText().getBytes(),txt_NewDescription.getText()), ID);
            JOptionPane.showMessageDialog(null,"Password inserted","Confirmation",JOptionPane.PLAIN_MESSAGE);
            this.dispose();
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidKeySpecException ex) {
            Logger.getLogger(NewPassword.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }//GEN-LAST:event_btn_NewAcceptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_NewAccept;
    private javax.swing.JButton btn_NewCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_NewDescription;
    private javax.swing.JTextField txt_NewName;
    private javax.swing.JTextField txt_NewPass;
    // End of variables declaration//GEN-END:variables
}
