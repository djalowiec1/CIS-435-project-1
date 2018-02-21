/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.math.*;
/**
 *
 * @author darriusz Jalowiec
 * CIS 435
 */
public class Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Shift Cipher Test
        ShiftCipher code = new ShiftCipher();
        BigInteger plainMessage, cipherMessage, decodedMessage, key;
        plainMessage = new BigInteger("15");
        key = new BigInteger("5");
        
        System.out.println("Message: " + plainMessage);
        
        cipherMessage = code.encrypt(plainMessage, key);
        System.out.println("Encrypted Message: " + cipherMessage);
        
        decodedMessage = code.decrypt(cipherMessage, key);
        System.out.println("Decrypted Message: " + decodedMessage);
    }
    
}
