
package frames;

import databaseConection.ConnectionJDBC;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane;
import models.Account;


public class ResetPassword extends javax.swing.JFrame {
    
    //Attributes
    int ID;
    Account selectedAccount;
    Random random;
   
    //constructor
    public ResetPassword(int chosenaccount) throws SQLException {
        initComponents();
        this.ID = chosenaccount;
        loadAccount(ID);
    
        lbl_nameSelected.setText("Account: "+selectedAccount.getForename()+", "+selectedAccount.getSurname());
        lbl_no1.setVisible(false);
        lbl_no2.setVisible(false);
        lbl_no3.setVisible(false);
    
    }
    //loads the account using the attribute ID
    public void loadAccount(int id) throws SQLException{
        ConnectionJDBC c = new ConnectionJDBC();
        this.selectedAccount =  c.loadAccountSelected(id);
    }
    //Generates a random password
    public String randomPassword(){
        String code = "";
        
        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final String lower = upper.toLowerCase();
        final String digits = "0123456789";
        
        String[] optionList = {upper,lower,digits}; 
        
        random = new Random();
        for(int i = 0; i<=5;i++){
            int stringNum = random.nextInt(optionList.length);
            int randomLetter = random.nextInt(optionList[stringNum].length());
            //System.out.println(randomLetter);
            code += optionList[stringNum].charAt(randomLetter);
            
        }
        return code;
    }
    //This checks all questions but splits the flagging from the triple condition. 
    public boolean checkAnswers(){
        boolean a1 = isQ1();
        boolean a2 = isQ2();
        boolean a3 = isQ3();
        return a1&&a2&&a3;  
    }
    //Question 1 ok?
    public boolean isQ1(){
        boolean answer;
        answer = txt_answer1.getText().equals(selectedAccount.getQuestion1());
        if (!answer){
            lbl_no1.setVisible(true);
        }
        return answer;
    }
    //Question 2 ok?
    public boolean isQ2(){
        boolean answer;
        answer = txt_answer2.getText().equals(selectedAccount.getQuestion2());
        if (!answer){
            lbl_no2.setVisible(true);
        }
        return answer;
    }
    //Question 3 ok?
    public boolean isQ3(){
        boolean answer;
        answer = txt_answer3.getText().equals(selectedAccount.getQuestion3());
        if (!answer){
            lbl_no3.setVisible(true);
        }
        return answer;
    }
    
    
    
    //LISTENERS
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txt_answer1 = new javax.swing.JTextField();
        txt_answer2 = new javax.swing.JTextField();
        txt_answer3 = new javax.swing.JTextField();
        btn_ResetMasterKey = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_nameSelected = new javax.swing.JLabel();
        lbl_no3 = new javax.swing.JLabel();
        lbl_no1 = new javax.swing.JLabel();
        lbl_no2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_answer1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_answer1FocusGained(evt);
            }
        });
        getContentPane().add(txt_answer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 330, -1));

        txt_answer2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_answer2FocusGained(evt);
            }
        });
        getContentPane().add(txt_answer2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 330, -1));

        txt_answer3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_answer3FocusGained(evt);
            }
        });
        getContentPane().add(txt_answer3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 330, -1));

        btn_ResetMasterKey.setBackground(new java.awt.Color(50, 136, 203));
        btn_ResetMasterKey.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_ResetMasterKey.setForeground(new java.awt.Color(0, 0, 102));
        btn_ResetMasterKey.setText("Reset");
        btn_ResetMasterKey.setBorder(null);
        btn_ResetMasterKey.setBorderPainted(false);
        btn_ResetMasterKey.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_ResetMasterKey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ResetMasterKeyActionPerformed(evt);
            }
        });
        getContentPane().add(btn_ResetMasterKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 130, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("1) What is the name of your favourite plate of food?");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 330, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("2) Name of your first pet?");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 180, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("3) What is the name of the of your favourite film all times?");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 400, -1));

        lbl_nameSelected.setText("nAME OF THE aCCOUNT");
        getContentPane().add(lbl_nameSelected, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, -1));

        lbl_no3.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        lbl_no3.setForeground(new java.awt.Color(255, 51, 51));
        lbl_no3.setText("No");
        getContentPane().add(lbl_no3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, 30, 30));

        lbl_no1.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        lbl_no1.setForeground(new java.awt.Color(255, 51, 51));
        lbl_no1.setText("No");
        getContentPane().add(lbl_no1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 30, 30));

        lbl_no2.setFont(new java.awt.Font("Decker", 0, 18)); // NOI18N
        lbl_no2.setForeground(new java.awt.Color(255, 51, 51));
        lbl_no2.setText("No");
        getContentPane().add(lbl_no2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 230, 30, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ResetMasterKeyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ResetMasterKeyActionPerformed
    if(checkAnswers()){
        //generate password
        String newPassword = randomPassword();
       
        selectedAccount.setPassword(newPassword);       
        ConnectionJDBC c = new ConnectionJDBC(); //update database
        c.updateAccount(selectedAccount);      
        JOptionPane.showMessageDialog(null, "\nThe new password is:  "+newPassword+"\n\n", "important",JOptionPane.INFORMATION_MESSAGE);
        this.dispose();
    }

    
    //LISTENERS
    }//GEN-LAST:event_btn_ResetMasterKeyActionPerformed

    private void txt_answer1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_answer1FocusGained
        lbl_no1.setVisible(false);
    }//GEN-LAST:event_txt_answer1FocusGained

    private void txt_answer2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_answer2FocusGained
        lbl_no2.setVisible(false);
    }//GEN-LAST:event_txt_answer2FocusGained

    private void txt_answer3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_answer3FocusGained
        lbl_no3.setVisible(false);
    }//GEN-LAST:event_txt_answer3FocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ResetMasterKey;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_nameSelected;
    private javax.swing.JLabel lbl_no1;
    private javax.swing.JLabel lbl_no2;
    private javax.swing.JLabel lbl_no3;
    private javax.swing.JTextField txt_answer1;
    private javax.swing.JTextField txt_answer2;
    private javax.swing.JTextField txt_answer3;
    // End of variables declaration//GEN-END:variables
}
