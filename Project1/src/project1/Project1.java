/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.math.BigInteger;

/**
 *
 * @author darek
 */
public class Project1 {
    public static void main(String[] args){
        
        //testShiftCipher(); functional
        //testCBC(); functional
        //testPoly();
        //testMAC();
    }
    
        public static void testShiftCipher()
        {
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
        }
        
        public static void testCBC()
        {
            CBC CBCcode = new CBC();
            BigInteger CBCplainMessage, CBCcipherMessage, CBCdecodedMessage, CBCkey;
            CBCplainMessage = new BigInteger("555");
            CBCkey = new BigInteger("2");//Can only be a single digit
            
            //Print out original message and key
            System.out.println("Original Message: " + CBCplainMessage);
            System.out.println("IV: " + CBCkey);
            System.out.println("Expected Encrypted Message: 130");
            
            //Print out encoded message
            CBCcipherMessage = CBCcode.encrypt(CBCplainMessage, CBCkey);
            System.out.println("Actual Encrypted Message: " + CBCcipherMessage);
            
            //Print out decoded message
            CBCdecodedMessage = CBCcode.decrypt(CBCcipherMessage, CBCkey);
            System.out.println("Decrypted Message: " + CBCdecodedMessage);
        }
        
        public static void testPoly(){
            PolyalphabeticCipher test = new PolyalphabeticCipher();
            BigInteger key = new BigInteger("1234");
            BigInteger polyMessage = new BigInteger("150011");
            System.out.println("Orginal Mesaage: " +polyMessage);
            BigInteger result = test.encrypt(polyMessage, key);
            System.out.println("Encrypted Message: " + result);
            System.out.println("Decrypted Message: "  + test.decrypt(result, key));
    
        }
        
        public static void testMAC(){
            MacCipher test = new MacCipher();
            BigInteger plain = new BigInteger("15015");
            BigInteger secret = new BigInteger("2");
            test.encrypt(plain, secret);
            BigInteger result = test.encrypt(plain, secret);
            System.out.println("Orginal Message: " + plain);
            System.out.println("Encrypted Message: " + result);
            BigInteger check = test.decrypt(result, secret);
            System.out.println("Decrypterd Mesaage: " + check);
            
        }
    
    
}
