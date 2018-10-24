
package databaseConection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.Account;
import models.Admin;
import security.Hashing;


public class ConnectionJDBC {
    Date date;
    SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
    Connection conn; 
            
    private void conectar() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/passwordLocker";
        String user = "root";
        String pass = "";   
        conn = DriverManager.getConnection(url, user, pass);  
    }
    
    private void desconectar() throws SQLException{
        if (conn != null){ conn.close();}
    }

public boolean checkUsername(){  
    
    return false;
    
}

public int checkUsername(String userInput) throws SQLException{
    conectar();        
    int numberReturned = 0;
    String query = "SELECT count(userAdmin) AS total FROM t_admins \n" +
                    "WHERE userAdmin = '"+Hashing.getHash(userInput.getBytes())+"'";
    
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);

    while(rs.next()){
        numberReturned = rs.getInt("total");
    }
    desconectar();
    return numberReturned;      
}

public int checkCredentials(String user, String pass) throws SQLException{
    conectar();        
    int numberReturned = 0;
    String query = "SELECT count(userAdmin) AS total FROM t_admins \n" +
                    "WHERE userAdmin = '"+Hashing.getHash(user.getBytes())+"' AND passwordAdmin = '"+Hashing.getHash(pass.getBytes())+"'";  
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    while(rs.next()){
        numberReturned = rs.getInt("total");
    }
    desconectar();
    return numberReturned;      
}

public Account loadAccountSelected(int input) throws SQLException{
    conectar();        
    Account tempAccount =  null;

    String query = "SELECT * FROM t_accounts\n" +
                    "WHERE ida = '"+input+"'";
    
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);

    while(rs.next()){
        int id = rs.getInt("ida");
        String name = rs.getString("forename");
        String sur = rs.getString("surname");
        String dob = rs.getString("dob");
        String user = rs.getString("username");
        String mas = rs.getString("masterkey");
        String a1 = rs.getString("a1");
        String a2 = rs.getString("a2");
        String a3 = rs.getString("a3");
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date entry = null;

        
        tempAccount = new Account(id,name,sur,dob,user,mas,a1,a2,a3);
        
    }
    desconectar();
    return tempAccount;      
}

public ArrayList<Account> loadAccounts() throws SQLException{
    conectar();        
    ArrayList<Account> temporalList = new ArrayList<>();

    String query = "SELECT * FROM t_accounts";
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);

    while(rs.next()){
        int id = rs.getInt("ida");
        String name = rs.getString("forename");
        String sur = rs.getString("surname");
        String dob = rs.getString("dob");
        String user = rs.getString("username");
        String mas = rs.getString("masterkey");
        String a1 = rs.getString("a1");
        String a2 = rs.getString("a2");
        String a3 = rs.getString("a3");
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
        Date entry = null;

        
        Account a = new Account(id,name,sur,dob,user,mas,a1,a2,a3);
        temporalList.add(a);
    }
    desconectar();
    return temporalList;      
}

public void insertAccount(Account a) throws ParseException{
   try{
            //hashing
            String huser = Hashing.getHash(a.getUsername().getBytes());
            String hpassword = Hashing.getHash(a.getPassword().getBytes());
            
            conectar();
            String insert = "INSERT INTO t_accounts (forename,surname,dob,username,masterkey,a1,a2,a3,responsible) VALUES(?,?,?,?,?,?,?,?,?)";
            
            PreparedStatement pst = conn.prepareStatement(insert);
            pst.setString(1,a.getForename());
            pst.setString(2, a.getSurname());            
            pst.setString(3, a.getDob());            
            pst.setString(4, huser);
            pst.setString(5, hpassword); 
            pst.setString(6, a.getQuestion1());
            pst.setString(7, a.getQuestion2());
            pst.setString(8, a.getQuestion3());
            pst.setInt(9, a.getResponsible());
            
            pst.execute();
            desconectar();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error","No pasa nada",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }   
}

public void updateAccount(Account selectedAccount) {
        try{        
            String convertedPass = Hashing.getHash(selectedAccount.getPassword().getBytes());
            String update = ("UPDATE t_accounts SET masterkey = '"+convertedPass+"' "
                    + "WHERE ida= "+selectedAccount.getId());
            conectar();
            Statement st = conn.createStatement();          
            st.executeUpdate(update);   
            desconectar();           
         }catch(SQLException e){
           System.out.println(e.getMessage());
        } 
    }

public void insertAdmin(Admin admin) {
    try{
        conectar();

        String u = Hashing.getHash(admin.getUserAdmin().getBytes());
        String p = Hashing.getHash(admin.getAdminPass().getBytes());

        String insert = "INSERT INTO t_admins (userAdmin, passwordAdmin) VALUES(?,?)";
        PreparedStatement pst = conn.prepareStatement(insert);           
        pst.setString(1, u);
        pst.setString(2, p);                   
        pst.execute();
        desconectar();
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null,"Error","No pasa nada",JOptionPane.ERROR);
    }   
}

public ArrayList<Admin> loadAdmins() throws SQLException {

conectar();        
ArrayList<Admin> temporalList = new ArrayList<>();

String query = "SELECT * FROM t_admins";

Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(query);

while(rs.next()){
    int i = rs.getInt("idadmin");
    String n = rs.getString("userAdmin");       
    String p = rs.getString("passwordAdmin");

    Admin a = new Admin(i,n,p);
    temporalList.add(a);
}
desconectar();
return temporalList;      
}

public int loadChosenAccount(String user) throws SQLException {
    conectar();    
    String condition = "";
    condition = Hashing.getHash(user.getBytes());
    String query = "SELECT idadmin FROM t_admins WHERE userAdmin LIKE '"+condition+"'";                     
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    int i = 0;
    while(rs.next()){
       i = rs.getInt("idadmin");
    }
    desconectar();
    return i;     
}

public void updateAdminPass(String newPass, int id) {
       
        String newPassHashed = Hashing.getHash(newPass.getBytes());
        
        try{        
            String update = "UPDATE t_admins SET passwordAdmin = '"+newPassHashed+"'"
                            + "WHERE idadmin= "+id;
            conectar();
            Statement st = conn.createStatement();          
            st.executeUpdate(update);   
            desconectar();           
         }catch(SQLException e){
           System.out.println(e.getMessage());
        } 
    }
}
