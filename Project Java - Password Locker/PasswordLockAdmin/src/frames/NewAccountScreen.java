/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frames;

import databaseConection.ConnectionJDBC;
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.Account;


public class NewAccountScreen extends javax.swing.JFrame {
    ArrayList<Account> accountList =  new ArrayList<>();
    int ID;
    Random random;
    
    public NewAccountScreen(ArrayList<Account> list, int id) {
        initComponents();
        accountList = list;
        this.ID = id;
    }
    
    public boolean checkName(){
        boolean exists = false;
        for(Account a : accountList){
           if(a.getForename().equals(txt_NewAccountName.getText())){
               exists = true;
           } 
        }          
    return exists;
    }   //combine with surname
    public boolean checkSurname(){
        boolean exists = false;
        for(Account a : accountList){
           if(a.getSurname().equals(txt_NewAccountSurname.getText())){
               exists = true;
           } 
        }          
    return exists;
    }  //combine with name
    public boolean checkUsername(){
        boolean exists = false;
        for(Account a : accountList){
           if(a.getUsername().equals(txt_NewAccountUsername.getText())){
               exists = true;
           } 
        }          
    return exists;
    }
    public boolean checkAnswers(){
        boolean empty = false;
        if(txt_NewAccountA1.getText().length() <= 0){
            empty = true;
        }
        if(txt_NewAccountA2.getText().length() <= 0){
            empty = true;
        }
        if(txt_NewAccountA3.getText().length() <= 0){
            empty = true;
        }
        return empty;
    }
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
            System.out.println(code);
        }
        return code;
    }
    public boolean passwordCheck(String code){
        boolean exists = false;
        for(Account a : accountList){
           if(a.getPassword().equals(code)){
               exists = true;
           } 
        }  
        return exists;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_NewAccountName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_NewAccountSurname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        txt_NewAccountUsername = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        txt_NewAccountA1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_NewAccountA2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_NewAccountA3 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btn_CreateAccount = new javax.swing.JButton();
        lbl_BlueUser = new javax.swing.JLabel();
        cb_year = new javax.swing.JComboBox<>();
        cb_day = new javax.swing.JComboBox<>();
        cb_month = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("1) What is the name of your favourite plate of food?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 460, -1));
        getContentPane().add(txt_NewAccountName, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 350, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Surname:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));
        getContentPane().add(txt_NewAccountSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 350, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Date of Birth:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 500, 10));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Username:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));
        getContentPane().add(txt_NewAccountUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 350, 30));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 500, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, -1, -1));
        getContentPane().add(txt_NewAccountA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 370, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Name:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Answer 1:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 120, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Security questions");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 120, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("2) Name of your first pet?");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 460, -1));
        getContentPane().add(txt_NewAccountA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 450, 370, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Answer 2:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 120, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("3) What is the name of the of your favourite film all times?");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 500, 460, -1));
        getContentPane().add(txt_NewAccountA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 530, 370, 30));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Answer 3:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 540, 120, -1));

        btn_CreateAccount.setBackground(new java.awt.Color(50, 136, 203));
        btn_CreateAccount.setFont(new java.awt.Font("Decker", 1, 11)); // NOI18N
        btn_CreateAccount.setForeground(new java.awt.Color(0, 0, 102));
        btn_CreateAccount.setText("Create account");
        btn_CreateAccount.setBorder(null);
        btn_CreateAccount.setBorderPainted(false);
        btn_CreateAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_CreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CreateAccountActionPerformed(evt);
            }
        });
        getContentPane().add(btn_CreateAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 120, 30));

        lbl_BlueUser.setFont(new java.awt.Font("Decker", 0, 36)); // NOI18N
        lbl_BlueUser.setForeground(new java.awt.Color(50, 136, 203));
        lbl_BlueUser.setText("New account details");
        getContentPane().add(lbl_BlueUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 380, 50));

        cb_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967", "1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958", "1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949", "1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940", "1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931", "1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922", "1921", "1920", "1919", "1918", "1917", "1916", "1915", "1914", "1913", "1912", "1911", "1910", "1909", "1908", "1907", "1906", "1905", "1904", "1903", "1902", "1901", "1900" }));
        getContentPane().add(cb_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 190, 140, -1));

        cb_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(cb_day, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, -1, -1));

        cb_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        getContentPane().add(cb_month, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 190, -1, -1));

        jLabel13.setText("Year");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        jLabel14.setText("Day");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, -1, -1));

        jLabel15.setText("Month");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CreateAccountActionPerformed
        boolean ok = true;
        String newPassword = "";
        
        if(checkName() && checkSurname()){
            ok = false;
        }
        if(checkUsername()){
            ok = false;
        }
        if (checkAnswers()){            
            ok = false;
        }
        if(ok){           
            try {
                //Generate random password
                do{
                    newPassword = randomPassword();
                }while(passwordCheck(newPassword));
                
                //insert new Account
                Account a =  new Account();
                a.setForename(txt_NewAccountName.getText());
                a.setSurname(txt_NewAccountSurname.getText());
                
                Date d;
                int year = Integer.parseInt(cb_year.getSelectedItem().toString());
                int month = Integer.parseInt(cb_month.getSelectedItem().toString());
                int day = Integer.parseInt(cb_day.getSelectedItem().toString());
                String date = day+"/"+month+"/"+year;
                a.setDob(date);
                a.setUsername(txt_NewAccountUsername.getText());
                a.setPassword(newPassword);
                a.setQuestion1(txt_NewAccountA1.getText());
                a.setQuesiotn2(txt_NewAccountA2.getText());
                a.setQuestion3(txt_NewAccountA3.getText());
                a.setResponsible(ID);
                   
                ConnectionJDBC c =  new ConnectionJDBC();
                c.insertAccount(a);
                JOptionPane.showMessageDialog(null, "\n\nYour new password is:  "+newPassword+"\n\n", "important",JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (ParseException ex) {
                Logger.getLogger(NewAccountScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "Not entered","Notice",JOptionPane.INFORMATION_MESSAGE);
        }
        
        
    }//GEN-LAST:event_btn_CreateAccountActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_CreateAccount;
    private javax.swing.JComboBox<String> cb_day;
    private javax.swing.JComboBox<String> cb_month;
    private javax.swing.JComboBox<String> cb_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl_BlueUser;
    private javax.swing.JTextField txt_NewAccountA1;
    private javax.swing.JTextField txt_NewAccountA2;
    private javax.swing.JTextField txt_NewAccountA3;
    private javax.swing.JTextField txt_NewAccountName;
    private javax.swing.JTextField txt_NewAccountSurname;
    private javax.swing.JTextField txt_NewAccountUsername;
    // End of variables declaration//GEN-END:variables
}
