
package security;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.sql.SQLException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import models.Estructura;

public class Encrypting {
       static KeyPairGenerator keygen;
        static KeyPair kp;
        static PublicKey puKey;
        static PrivateKey  pKey;
        static Cipher cipher;
        
        
    public static Estructura runEncrypt(byte[] mensaje) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, SQLException, InvalidKeySpecException {
        // Generamos el par de claves.
        // Generamos el par de claves.
	keygen = KeyPairGenerator.getInstance("RSA");
	kp = keygen.generateKeyPair();
	puKey = kp.getPublic();
	pKey = kp.getPrivate();
	//invocamos al metodo de guardar la clave
	
	//creamos el cipher
	cipher = Cipher.getInstance("RSA");		
       
        cipher.init(Cipher.ENCRYPT_MODE, puKey);
	byte[] encriptado = cipher.doFinal(mensaje);
        
	//guardamos el mensaje en el objeto       
        byte[] publicKeyBytes = pKey.getEncoded();      
        Estructura vehicle = new Estructura(encriptado,publicKeyBytes);
        return vehicle;     
        }
}
