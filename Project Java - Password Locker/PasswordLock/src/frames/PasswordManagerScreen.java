
package frames;

import databaseConection.ConnectionJDBC;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.Password;
import security.Decrypting;



public class PasswordManagerScreen extends javax.swing.JFrame {
    
    ArrayList<Password> passwordList = new ArrayList<>();
    ArrayList<Password> tempList = new ArrayList<>();
    Password chosenPassword;
    int selection = -1;
    final int ID;
    
     
    public PasswordManagerScreen(int id) throws SQLException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, IOException, BadPaddingException, InvalidKeySpecException {      
        initComponents();
        ID = id;
        loadData();
        loadTable();     
        setTextChangeListener();
    }
    
 
    private void loadData() throws SQLException, InvalidKeyException, IllegalBlockSizeException, IllegalBlockSizeException, BadPaddingException, IOException, NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException{
        ConnectionJDBC gestor = new ConnectionJDBC();         
        //cargar todos los passwords bajo el id
        passwordList = gestor.loadPasswords(ID);
        for (Password p : passwordList){
            p.setPass(Decrypting.runDecryption(p.getPid()));           
        }
        tempList = passwordList;      //We want to set it equal on the constructor only.  
                
     }

    private void loadTable(){       
         String matris[][] = new String[passwordList.size()][4];        
         for(int i = 0;i < passwordList.size();i++){
             matris[i][0]= Integer.toString(i+1);
             matris[i][1]=passwordList.get(i).getPassName();
             matris[i][2]= new String (passwordList.get(i).getPass());
             matris[i][3]=passwordList.get(i).getPassDescription();          
         }      
         table_Password.setModel(new javax.swing.table.DefaultTableModel(matris,new String[]{"Number",
             "Name", "Password","Description"})); 
     }    
       
    public void searchPassword(){
        String hint = txt_SearchPass.getText();
        tempList = new ArrayList<>();
        
        for(Password pass:passwordList){            
            if(pass.getPassName().toLowerCase().contains(hint.toLowerCase())){ 
               tempList.add(pass);              
            }
        }
        if(tempList.size()>0){  
        String matris[][] = new String[tempList.size()][4];
            for(int i = 0;i<=tempList.size()-1;i++){              
                matris[i][0]= Integer.toString(i+1);
                matris[i][1]=tempList.get(i).getPassName();
                matris[i][2]= new String(tempList.get(i).getPass());
                matris[i][3]=tempList.get(i).getPassDescription();               
                table_Password.setModel(new javax.swing.table.DefaultTableModel(matris,new String[]{"Number",
                "Name", "Password","Description"})); 
            }     
        }else{
            String matris[][] = new String[1][4];           
                matris[0][0]= Integer.toString(0);
                matris[0][1]= "no result";
                matris[0][2]= "no result";
                matris[0][3]= "no result";             
                table_Password.setModel(new javax.swing.table.DefaultTableModel(matris,new String[]{"Number",
                "Name", "Password","Description"}));                 
        } 
    }
        
    public void setTextChangeListener(){
        
        
        txt_SearchPass.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void changedUpdate(DocumentEvent e) {
            searchPassword();         
        
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            searchPassword();
  
        }
        @Override
        public void insertUpdate(DocumentEvent e) {
          searchPassword();
         
        }
    });
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btn_Refresh = new javax.swing.JButton();
        bt_UpdatePass = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_Password = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bt_DeletePass = new javax.swing.JButton();
        txt_SearchPass = new javax.swing.JTextField();
        bt_NewPass = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        item_NewPass = new javax.swing.JMenuItem();
        btn_UpdatePass = new javax.swing.JMenuItem();
        item_DeletePass = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem4 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Password Locker");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(1200, 600));
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Search by name:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 180, 20));

        btn_Refresh.setBackground(new java.awt.Color(50, 136, 203));
        btn_Refresh.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_Refresh.setForeground(new java.awt.Color(0, 0, 102));
        btn_Refresh.setText("Refresh ");
        btn_Refresh.setBorder(null);
        btn_Refresh.setBorderPainted(false);
        btn_Refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 80, 60, 30));

        bt_UpdatePass.setBackground(new java.awt.Color(50, 136, 203));
        bt_UpdatePass.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        bt_UpdatePass.setForeground(new java.awt.Color(0, 0, 102));
        bt_UpdatePass.setText("Update");
        bt_UpdatePass.setBorder(null);
        bt_UpdatePass.setBorderPainted(false);
        bt_UpdatePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_UpdatePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UpdatePassActionPerformed(evt);
            }
        });
        getContentPane().add(bt_UpdatePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 100, 60));

        table_Password.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table_Password);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 117, 960, 350));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frames/images/main.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 100));

        jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 18)); // NOI18N
        jLabel3.setText("Introduce all the passwords that you want to save in your locker");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 940, -1));

        bt_DeletePass.setBackground(new java.awt.Color(50, 136, 203));
        bt_DeletePass.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        bt_DeletePass.setForeground(new java.awt.Color(0, 0, 102));
        bt_DeletePass.setText("Delete");
        bt_DeletePass.setBorder(null);
        bt_DeletePass.setBorderPainted(false);
        bt_DeletePass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_DeletePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DeletePassActionPerformed(evt);
            }
        });
        getContentPane().add(bt_DeletePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 100, 60));
        getContentPane().add(txt_SearchPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 230, -1));

        bt_NewPass.setBackground(new java.awt.Color(50, 136, 203));
        bt_NewPass.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        bt_NewPass.setForeground(new java.awt.Color(0, 0, 102));
        bt_NewPass.setText("New");
        bt_NewPass.setBorder(null);
        bt_NewPass.setBorderPainted(false);
        bt_NewPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        bt_NewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_NewPassActionPerformed(evt);
            }
        });
        getContentPane().add(bt_NewPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 100, 60));

        jMenu1.setText("Options");

        item_NewPass.setText("New Password");
        item_NewPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_NewPassActionPerformed(evt);
            }
        });
        jMenu1.add(item_NewPass);

        btn_UpdatePass.setText("Update Password");
        btn_UpdatePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdatePassActionPerformed(evt);
            }
        });
        jMenu1.add(btn_UpdatePass);

        item_DeletePass.setText("Delete Password");
        item_DeletePass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_DeletePassActionPerformed(evt);
            }
        });
        jMenu1.add(item_DeletePass);
        jMenu1.add(jSeparator1);

        jMenuItem4.setText("Log Out");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
       try {
            loadData();
            loadTable();
            selection = -1;           
        } catch (SQLException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException ex) {
            Logger.getLogger(PasswordManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void bt_UpdatePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UpdatePassActionPerformed
       selection = table_Password.getSelectedRow();
       if(selection != -1){ 
       selection = table_Password.getSelectedRow();
       UpdatePassword up = new UpdatePassword(passwordList.get(selection));
       up.setLocationRelativeTo(null);
       up.setVisible(true);
       }
    }//GEN-LAST:event_bt_UpdatePassActionPerformed

    private void bt_DeletePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DeletePassActionPerformed
        selection = table_Password.getSelectedRow();     
        if(selection != -1){
        ConnectionJDBC gestor = new ConnectionJDBC();
        int s = tempList.get(table_Password.getSelectedRow()).getPid();       
        gestor.deletePassword(s);
        passwordList.remove(table_Password.getSelectedRow());
        JOptionPane.showMessageDialog(null,"Password deleted","Confirmation",JOptionPane.PLAIN_MESSAGE);
        loadTable(); //refresh screen
        }
    }//GEN-LAST:event_bt_DeletePassActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        try {
            loadData();
            loadTable();
        } catch (SQLException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IOException | NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException ex) {
            Logger.getLogger(PasswordManagerScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formFocusGained

    private void bt_NewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_NewPassActionPerformed
       NewPassword n = new NewPassword(passwordList, ID);
       n.setLocationRelativeTo(null);
       n.setVisible(true);
    }//GEN-LAST:event_bt_NewPassActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void item_NewPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_NewPassActionPerformed
        bt_NewPass.doClick();
    }//GEN-LAST:event_item_NewPassActionPerformed

    private void btn_UpdatePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdatePassActionPerformed
        bt_UpdatePass.doClick();
    }//GEN-LAST:event_btn_UpdatePassActionPerformed

    private void item_DeletePassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_DeletePassActionPerformed
        bt_DeletePass.doClick();
    }//GEN-LAST:event_item_DeletePassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_DeletePass;
    private javax.swing.JButton bt_NewPass;
    private javax.swing.JButton bt_UpdatePass;
    private javax.swing.JButton btn_Refresh;
    private javax.swing.JMenuItem btn_UpdatePass;
    private javax.swing.JMenuItem item_DeletePass;
    private javax.swing.JMenuItem item_NewPass;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTable table_Password;
    private javax.swing.JTextField txt_SearchPass;
    // End of variables declaration//GEN-END:variables
}
