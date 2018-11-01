
package security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;


public class Hashing {
    
    public static String getHash(byte[] input){
        String hash = "";
        try{
            MessageDigest md = MessageDigest.getInstance("Sha-512");
            md.update(input);
            byte[] output = md.digest();
            hash = DatatypeConverter.printHexBinary(output);
 
        }catch(NoSuchAlgorithmException e){
            System.out.println("Hashing went wrong");
        }     
        return hash;
    }
 
}
