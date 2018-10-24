
package security;

import databaseConection.ConnectionJDBC;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.SQLException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import models.Estructura;


public class Decrypting {
            
            static KeyPairGenerator keygen;
            static KeyPair kp;
            static PrivateKey privatek;
            static int selectedRecord;
            static Cipher cipher;
            
        public static byte[] runDecryption(int number) throws NoSuchAlgorithmException, InvalidKeySpecException, IOException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, SQLException {		
            selectedRecord = number;
            //instanciate objects
            keygen = KeyPairGenerator.getInstance("RSA");
            kp = keygen.generateKeyPair();
            privatek = kp.getPrivate();          
            cipher = Cipher.getInstance("RSA");           

            //obtain data from database                                         
            ConnectionJDBC c = new ConnectionJDBC(); 
            Estructura vehiculo;
            vehiculo = c.loadPassword(selectedRecord);             
            
            //creamos el keyfactory para descrifrar la clave guardada
            KeyFactory kf = KeyFactory.getInstance("RSA");
            KeySpec ks = new PKCS8EncodedKeySpec(vehiculo.getSecret());
            PrivateKey keyFromBytes = kf.generatePrivate(ks);
            privatek = keyFromBytes; 
            
            //decrypt message
            byte[] devolucion = vehiculo.getPass();           
            cipher.init(Cipher.DECRYPT_MODE, privatek);
            byte[] desencriptar = cipher.doFinal(devolucion);
            return desencriptar;
	}
}
