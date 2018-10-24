
package frames;

import databaseConection.ConnectionJDBC;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import models.Account;
import models.Admin;


public class AdminPasswordManager extends javax.swing.JFrame {
    ArrayList<Account> accountsList = new ArrayList<>();
    ArrayList<Account> tempList = new ArrayList<>();
    ArrayList<Admin> adminList = new ArrayList<>();
    int adminID;
    int selection = -1;
    
    
    public AdminPasswordManager(int id) throws SQLException {
        initComponents();
        adminID = id;
        loadData();
        loadTable();
        setTextListeners();
        
    }

  
    
    private void loadData() throws SQLException{
        ConnectionJDBC c = new ConnectionJDBC();         
        accountsList = c.loadAccounts();
        tempList = accountsList;   
        adminList = c.loadAdmins();
     }

    private void loadTable(){      
         String matris[][] = new String[accountsList.size()][3];       
         for(int i = 0;i < accountsList.size();i++){
             matris[i][0]= accountsList.get(i).getForename();
             matris[i][1]=accountsList.get(i).getSurname();
             matris[i][2]=accountsList.get(i).getDob();                    
         }       
         table_Accounts.setModel(new javax.swing.table.DefaultTableModel(matris,new String[]{
             "Forename", "Surname","Date of Birth"})); 
     }
    
    
    public void searchAccount(){
        String namehint = txt_SearchAccountName.getText();
        String surhint = txt_SearchAccountSurname.getText();
        String dobhint = txt_SearchAccountDOB.getText();
        
        tempList = new ArrayList<>();
        
        for(Account acc:accountsList){
            
            if(acc.getForename().toLowerCase().contains(namehint.toLowerCase())||txt_SearchAccountName.getText().length()==0){ 
                if(acc.getSurname().toLowerCase().contains(surhint.toLowerCase())||txt_SearchAccountSurname.getText().length()==0){ 
                    if(acc.getDob().toLowerCase().contains(dobhint.toLowerCase())||txt_SearchAccountDOB.getText().length()==0){ 
                        tempList.add(acc); 
                    }
                }
            }
        }
        
        if(tempList.size()>0){  
        String matris[][] = new String[tempList.size()][3];
            for(int i = 0;i<=tempList.size()-1;i++){
                
                matris[i][0]= tempList.get(i).getForename();
                matris[i][1]=tempList.get(i).getSurname();
                matris[i][2]=tempList.get(i).getDob();                 
                table_Accounts.setModel(new javax.swing.table.DefaultTableModel(matris,new String[]{
             "Forename", "Surname","Date of Birth"})); 
            }     
        }else{
            String matris[][] = new String[1][3];           
                
                matris[0][0]= "no result";
                matris[0][1]= "no result";
                matris[0][2]= "no result";
                table_Accounts.setModel(new javax.swing.table.DefaultTableModel(matris,new String[]{
             "Forename", "Surname","Date of Birth"})); 
                 
        } 
    }
    
    public void setTextListeners(){
        setForenameTextChangeListener();
        setSurnameTextChangeListener();
        setDOBTextChangeListener();
    }
    
     public void setForenameTextChangeListener(){
        txt_SearchAccountName.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void changedUpdate(DocumentEvent e) {
            searchAccount();         
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            searchAccount();
  
        }
        @Override
        public void insertUpdate(DocumentEvent e) {
          searchAccount();
         
        }
    });
    }
    
     public void setSurnameTextChangeListener(){
        txt_SearchAccountSurname.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void changedUpdate(DocumentEvent e) {
            searchAccount();  
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
        searchAccount();
        }
        @Override
        public void insertUpdate(DocumentEvent e) {
        searchAccount();
        }
    });
    }
     
     public void setDOBTextChangeListener(){
        txt_SearchAccountDOB.getDocument().addDocumentListener(new DocumentListener() {
        @Override
        public void changedUpdate(DocumentEvent e) {
        searchAccount();
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
        searchAccount();
        }
        @Override
        public void insertUpdate(DocumentEvent e) {
        searchAccount(); 
        }
    });
    }
     
    
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table_Accounts = new javax.swing.JTable();
        txt_SearchAccountDOB = new javax.swing.JTextField();
        txt_SearchAccountName = new javax.swing.JTextField();
        txt_SearchAccountSurname = new javax.swing.JTextField();
        btn_NewAccount = new javax.swing.JButton();
        lbl_SearchAccount = new javax.swing.JLabel();
        lbl_SearchAccount1 = new javax.swing.JLabel();
        lbl_SearchAccount2 = new javax.swing.JLabel();
        btn_ResetPassword = new javax.swing.JButton();
        btn_ClearFields = new javax.swing.JButton();
        btn_Refresh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Item_newAccount = new javax.swing.JMenuItem();
        item_ResetPass = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        item_NewAdmin = new javax.swing.JMenuItem();
        item_changeAdminPass = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table_Accounts.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(table_Accounts);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 780, 229));

        txt_SearchAccountDOB.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_SearchAccountDOBInputMethodTextChanged(evt);
            }
        });
        getContentPane().add(txt_SearchAccountDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 180, -1));

        txt_SearchAccountName.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_SearchAccountNameInputMethodTextChanged(evt);
            }
        });
        getContentPane().add(txt_SearchAccountName, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 180, -1));

        txt_SearchAccountSurname.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_SearchAccountSurnameInputMethodTextChanged(evt);
            }
        });
        getContentPane().add(txt_SearchAccountSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 110, 180, -1));

        btn_NewAccount.setBackground(new java.awt.Color(50, 136, 203));
        btn_NewAccount.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_NewAccount.setForeground(new java.awt.Color(0, 0, 102));
        btn_NewAccount.setText("New");
        btn_NewAccount.setBorder(null);
        btn_NewAccount.setBorderPainted(false);
        btn_NewAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_NewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_NewAccountActionPerformed(evt);
            }
        });
        getContentPane().add(btn_NewAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 60, 40));

        lbl_SearchAccount.setText("Date of Birth Filter:");
        getContentPane().add(lbl_SearchAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 200, -1));

        lbl_SearchAccount1.setText("Name Filter:");
        getContentPane().add(lbl_SearchAccount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 190, -1));

        lbl_SearchAccount2.setText("Surname Filter:");
        getContentPane().add(lbl_SearchAccount2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 170, -1));

        btn_ResetPassword.setBackground(new java.awt.Color(50, 136, 203));
        btn_ResetPassword.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_ResetPassword.setForeground(new java.awt.Color(0, 0, 102));
        btn_ResetPassword.setText("Reset Password");
        btn_ResetPassword.setBorder(null);
        btn_ResetPassword.setBorderPainted(false);
        btn_ResetPassword.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ResetPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResetPasswordActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ResetPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, 130, 40));

        btn_ClearFields.setBackground(new java.awt.Color(50, 136, 203));
        btn_ClearFields.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_ClearFields.setForeground(new java.awt.Color(0, 0, 102));
        btn_ClearFields.setText("Clear Fields");
        btn_ClearFields.setBorder(null);
        btn_ClearFields.setBorderPainted(false);
        btn_ClearFields.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ClearFields.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearFieldsActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ClearFields, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 110, 90, 20));

        btn_Refresh.setBackground(new java.awt.Color(50, 136, 203));
        btn_Refresh.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_Refresh.setForeground(new java.awt.Color(0, 0, 102));
        btn_Refresh.setText("Refresh");
        btn_Refresh.setBorder(null);
        btn_Refresh.setBorderPainted(false);
        btn_Refresh.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_RefreshActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 70, 40));

        jMenu1.setText("Options");

        Item_newAccount.setText("New Account");
        Item_newAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Item_newAccountActionPerformed(evt);
            }
        });
        jMenu1.add(Item_newAccount);

        item_ResetPass.setText("Reset Account Password");
        item_ResetPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_ResetPassActionPerformed(evt);
            }
        });
        jMenu1.add(item_ResetPass);
        jMenu1.add(jSeparator1);

        item_NewAdmin.setText("New Admin Account");
        item_NewAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_NewAdminActionPerformed(evt);
            }
        });
        jMenu1.add(item_NewAdmin);

        item_changeAdminPass.setText("Change Admin Password");
        item_changeAdminPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                item_changeAdminPassActionPerformed(evt);
            }
        });
        jMenu1.add(item_changeAdminPass);
        jMenu1.add(jSeparator2);

        jMenuItem6.setText("Log out");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchAccountDOBInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_SearchAccountDOBInputMethodTextChanged

    }//GEN-LAST:event_txt_SearchAccountDOBInputMethodTextChanged

    private void txt_SearchAccountNameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_SearchAccountNameInputMethodTextChanged
        
    }//GEN-LAST:event_txt_SearchAccountNameInputMethodTextChanged

    private void txt_SearchAccountSurnameInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_SearchAccountSurnameInputMethodTextChanged
       
    }//GEN-LAST:event_txt_SearchAccountSurnameInputMethodTextChanged

    private void btn_NewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_NewAccountActionPerformed
       NewAccountScreen nas = new NewAccountScreen(accountsList,adminID);
       nas.setLocationRelativeTo(null);
       nas.setVisible(true);
    }//GEN-LAST:event_btn_NewAccountActionPerformed

    private void btn_ResetPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResetPasswordActionPerformed
        
        selection = table_Accounts.getSelectedRow();
       if(selection != -1){ 
            try {
                selection = table_Accounts.getSelectedRow();
                int chosenID = accountsList.get(selection).getId();
                ResetPassword rp = new ResetPassword(chosenID);
                rp.setLocationRelativeTo(null);
                rp.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(AdminPasswordManager.class.getName()).log(Level.SEVERE, null, ex);
            }
       }      
    }//GEN-LAST:event_btn_ResetPasswordActionPerformed

    private void item_NewAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_NewAdminActionPerformed
        NewAdminAccount naa = new NewAdminAccount(adminID, adminList);
        naa.setLocationRelativeTo(null);
        naa.setVisible(true);
    }//GEN-LAST:event_item_NewAdminActionPerformed

    private void item_changeAdminPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_changeAdminPassActionPerformed
        UpdateAdminPass uap = new UpdateAdminPass(adminID,adminList);
        uap.setLocationRelativeTo(null);
        uap.setVisible(true);
        
    }//GEN-LAST:event_item_changeAdminPassActionPerformed

    private void btn_ClearFieldsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearFieldsActionPerformed
       txt_SearchAccountName.setText("");
       txt_SearchAccountSurname.setText("");
       txt_SearchAccountDOB.setText("");
    }//GEN-LAST:event_btn_ClearFieldsActionPerformed

    private void btn_RefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_RefreshActionPerformed
        try {
            loadData();
            loadTable();
        } catch (SQLException ex) {
            Logger.getLogger(AdminPasswordManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_RefreshActionPerformed

    private void Item_newAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Item_newAccountActionPerformed
        btn_NewAccount.doClick();
    }//GEN-LAST:event_Item_newAccountActionPerformed

    private void item_ResetPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_item_ResetPassActionPerformed
        btn_ResetPassword.doClick();
    }//GEN-LAST:event_item_ResetPassActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Item_newAccount;
    private javax.swing.JButton btn_ClearFields;
    private javax.swing.JButton btn_NewAccount;
    private javax.swing.JButton btn_Refresh;
    private javax.swing.JButton btn_ResetPassword;
    private javax.swing.JMenuItem item_NewAdmin;
    private javax.swing.JMenuItem item_ResetPass;
    private javax.swing.JMenuItem item_changeAdminPass;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lbl_SearchAccount;
    private javax.swing.JLabel lbl_SearchAccount1;
    private javax.swing.JLabel lbl_SearchAccount2;
    private javax.swing.JTable table_Accounts;
    private javax.swing.JTextField txt_SearchAccountDOB;
    private javax.swing.JTextField txt_SearchAccountName;
    private javax.swing.JTextField txt_SearchAccountSurname;
    // End of variables declaration//GEN-END:variables
}
