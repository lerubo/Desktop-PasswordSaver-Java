
package databaseConection;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import models.Estructura;
import models.Password;
import security.Hashing;
import security.Encrypting;


public class ConnectionJDBC {
   
    Connection conn; 
            
private void conectar() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/passwordlocker";
        String user = "root";
        String pass = "";   
        conn = DriverManager.getConnection(url, user, pass);  
    }
    
private void desconectar() throws SQLException{
        if (conn != null){ conn.close();}
    }

public Estructura loadPassword(int id) throws SQLException{
    conectar();        
    byte[] s = null;
    byte[] secret = null;
    String query = "SELECT pass, secret FROM t_passwords \n" +
                    "WHERE idp = '"+id+"'";
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);
    
    while(rs.next()){
        s = rs.getBytes("pass");
        secret = rs.getBytes("secret");
        
    }
    Estructura e = new Estructura(s,secret);
    
    desconectar();
    return e;      
}
    
public ArrayList<Password> loadPasswords(int id) throws SQLException{
    conectar();        
    ArrayList<Password> temporalList = new ArrayList<>();

    String query = "SELECT * FROM t_passwords\n" +
                    "WHERE ida_fk = '"+id+"'";
    
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);

    while(rs.next()){
        int pid = rs.getInt("idp");
        int aid = rs.getInt("ida_fk");
        String name = rs.getString("passname");
        byte[] pass = rs.getBytes("pass");
        byte[] secret = rs.getBytes("secret");
        String desc = rs.getString("description");
        
        Password p = new Password(pid,aid,name,pass,secret,desc);
        temporalList.add(p);
    }
    desconectar();
    return temporalList;      
}

public int checkUsername(String userInput) throws SQLException{
    conectar();        
    int numberReturned = 0;
    String query = "SELECT count(username) AS total FROM t_accounts \n" +
                    "WHERE username = '"+Hashing.getHash(userInput.getBytes())+"'";
    
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
    String query = "SELECT count(username) AS total FROM t_accounts \n" +
                    "WHERE username = '"+Hashing.getHash(user.getBytes())+"' AND masterkey = '"+Hashing.getHash(pass.getBytes())+"'";
    
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);

    while(rs.next()){
        numberReturned = rs.getInt("total");
    }
    desconectar();
    return numberReturned;      
}

public int loadID(String user, String pass) throws SQLException{
    conectar();        
    int numberReturned = 0;
    String query = "SELECT ida FROM t_accounts \n" +
                    "WHERE username = '"+Hashing.getHash(user.getBytes())+"' AND masterkey = '"+Hashing.getHash(pass.getBytes())+"'";
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(query);

    while(rs.next()){
        numberReturned = rs.getInt("ida");
    }
    desconectar();
    return numberReturned;      
}

public void insertPassword(Password p, int id) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException{
   try{
            Estructura temp = Encrypting.runEncrypt(p.getPass());
            p.setPass(temp.getPass());
            p.setSecretkey(temp.getSecret());
            
                    
            conectar();
            String insert = "INSERT INTO t_passwords (ida_fk, passname,pass,secret,description) VALUES(?,?,?,?,?)";
            PreparedStatement pst = conn.prepareStatement(insert);
            pst.setInt(1,id);
            pst.setString(2, p.getPassName());
            pst.setBytes(3, p.getPass());
            pst.setBytes(4, p.getSecretkey());
            pst.setString(5, p.getPassDescription());           
            pst.execute();
            desconectar();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error","No pasa nada",JOptionPane.ERROR);
        }   
}

public void updatePassword(Password p, int pid) throws IOException, NoSuchAlgorithmException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, BadPaddingException{
     try{                       
            Estructura temp = Encrypting.runEncrypt(p.getPass());
            p.setPass(temp.getPass());
            p.setSecretkey(temp.getSecret());
         
            String update = ("UPDATE t_passwords SET passname = ? , pass = ? , secret = ? , description = ? WHERE idp= ?");
            conectar();
            PreparedStatement pst = conn.prepareStatement(update);
            pst.setString(1, p.getPassName());
            pst.setBytes(2,p.getPass());
            pst.setBytes(3,p.getSecretkey());
            pst.setString(4,p.getPassDescription());
            pst.setInt(5, pid);
            pst.executeUpdate();   
            desconectar();           
         }catch(SQLException e){
           System.out.println(e.getMessage());
        } 
}

public void deletePassword(int pid){
    try{
               
        conectar();
        String sql = "DELETE FROM t_passwords WHERE idp = ? ";        
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, pid);      
        pst.executeUpdate();
        desconectar();
    }catch(SQLException e){
          System.out.println(e.getMessage());
    }   
}

}

    




