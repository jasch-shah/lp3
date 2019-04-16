/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.*;

public class AESenc {
  private static final String ALGO = "AES";
  private static final byte[] keyValue = new byte[]{'T', 'h', 'e', 'B', 'e', 's', 't', 'S', 'e', 'c', 'r', 'e', 't', 'K', 'e', 'y'};
  private static Scanner input = new Scanner(System.in);
  private static String data, cipherText, plainText;
  
    public static String encrypt(String data) throws Exception {
        Key key = generateKey();         //api ahe ha
        Cipher c = Cipher.getInstance(ALGO);  //api classes
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encVal);
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();            //api ahe ha
        Cipher c = Cipher.getInstance(ALGO);   //api classes
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = Base64.getDecoder().decode(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        return new String(decValue);
    }

    private static Key generateKey() throws Exception {
        return new SecretKeySpec(keyValue, ALGO);
    }
    
    public static void main(String[] args) throws Exception
    { 
        System.out.println("Enter the plaintext message: ");
        data = input.nextLine();
        AESenc cipher = new AESenc();     //creation of object
        cipherText = cipher.encrypt(data);
        System.out.println("Encrypted Text: "+cipherText);
        AESenc plain = new AESenc();
        plainText = plain.decrypt(cipherText);
        System.out.println("Decrypted Text: "+plainText);
    } 

}

/*

Enter the plaintext message: 
This is a plaintext message.
Encrypted Text: SkY/qMZqMN0PZx2JKnvDqrjxA1x21EnBriFrFaT8YlM=
Decrypted Text: This is a plaintext message.
*/
