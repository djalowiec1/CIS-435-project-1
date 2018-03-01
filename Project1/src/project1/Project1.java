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
        //testRSA();
        //testDigitalSignature();
    }
    
        public static void testShiftCipher(){
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
        
        public static void testCBC(){
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
        
        //DS TEC
        public static void testDigitalSignature(){
            //Creates DS and RSA
            DigitalSignature testDS = new DigitalSignature();
            RSA testRSA = new RSA();
            
            //Generate new Keys
            testRSA.genKeys();
            BigInteger[] PrivKey = testRSA.getPrivateKey();
            BigInteger[] PubKey = testRSA.getPublicKey(); 
            System.out.println("--TESTING DIGITAL SIGNATURE--");
            System.out.println("KEYS USED, MESSAGE TO BE SENT: ");
            System.out.println("Private Key n: " + PrivKey[0]);
            System.out.println("Private Key e: " + PrivKey[1]);
            System.out.println("Public Key n: " + PubKey[0]);
            System.out.println("Public Key d: " + PubKey[1]);
            
            //Sample Message
            BigInteger testMessage = new BigInteger("12");
            System.out.println("Unmodified Original Message: " + testMessage);
            
            //Create Message and encrypted message Digest
            BigInteger[] msgAndEncryptedMsg = new BigInteger[2];
            msgAndEncryptedMsg = testDS.sign(testMessage, PrivKey);
            System.out.println("\nCONCATENATION: \nOriginal Message: " + msgAndEncryptedMsg[0] + "\nSigned and Hashed Message: " + msgAndEncryptedMsg[1]);
            
            //Compare Message digest with decrypted encrypted message digest
            boolean same;
            same = testDS.verifyDS(msgAndEncryptedMsg[0], msgAndEncryptedMsg[1], PubKey);
            System.out.println("\nVERIFICATION: " + same);
        }
        
        //RSA TEC 
        public static void testRSA(){
            RSA testRSA = new RSA();
            
            //Generate new Keys
            testRSA.genKeys();
            BigInteger[] PrivKey = testRSA.getPrivateKey();
            BigInteger[] PubKey = testRSA.getPublicKey(); 
            System.out.println("--TESTING RSA--");
            System.out.println("KEYS GENERATED WITH RSA: ");
            System.out.println("Private Key n: " + PrivKey[0]);
            System.out.println("Private Key e: " + PrivKey[1]);
            System.out.println("Public Key n: " + PubKey[0]);
            System.out.println("Public Key d: " + PubKey[1]);
            
            //Create Message to Encrypt
            BigInteger testMessage = new BigInteger("14");
            System.out.println("Original Message: " + testMessage);
            
            //Test Encrypt()
            BigInteger cipher;
            cipher = testRSA.encrypt(testMessage, PubKey);
            System.out.println("Encrypted Message using Public Key: " + cipher);             
            
            //Test Decrypt()
            BigInteger message;
            message = testRSA.decrypt(cipher, PrivKey);
            System.out.println("Decrypted Message using cipher and Private Key: " + message + "\n"); 
        }    
}
