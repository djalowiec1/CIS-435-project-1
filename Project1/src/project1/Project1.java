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
        ShiftCipher SCcode = new ShiftCipher();
        BigInteger SCplainMessage, SCcipherMessage, SCdecodedMessage, SCkey;
        SCplainMessage = new BigInteger("15");
        SCkey = new BigInteger("5");
        
        //Print out original message and key
        System.out.println("Message: " + SCplainMessage);
        System.out.println("Key: " + SCkey);
        
        //Print out encoded message
        SCcipherMessage = SCcode.encrypt(SCplainMessage, SCkey);
        System.out.println("Encrypted Message: " + SCcipherMessage);
        
        //Print out decoded message
        SCdecodedMessage = SCcode.decrypt(SCcipherMessage, SCkey);
        System.out.println("Decrypted Message: " + SCdecodedMessage);
        
        //CBC Test
        CBC CBCcode = new CBC();
        BigInteger CBCplainMessage, CBCcipherMessage, CBCdecodedMessage, CBCkey;
        CBCplainMessage = new BigInteger("010110001110");
        CBCkey = new BigInteger("010");
        
        //Print out original message and key
        System.out.println("Message: " + CBCplainMessage);
        System.out.println("Key: " + CBCkey);
        
        //Print out encoded message
        CBCcipherMessage = CBCcode.encrypt(CBCplainMessage, CBCkey);
        System.out.println("Encrypted Message: " + CBCcipherMessage);
        
        //Print out decoded message
        CBCdecodedMessage = CBCcode.decrypt(CBCcipherMessage, CBCkey);
        System.out.println("Decrypted Message: " + CBCdecodedMessage);
        
        
        testPoly();
    }
        public static void testPoly(){
        PolyalphabeticCipher test = new PolyalphabeticCipher();
         BigInteger key = new BigInteger("1234");
         BigInteger polyMessage = new BigInteger("150011");
         System.out.println(test.encrypt(polyMessage, key));

    }
    
}
