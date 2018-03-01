/**
* <p>Tests each of the nine ciphers required for Project 1.
*
* @authors <Emily Benson, Tom Callahan, Cameron Conklin, Dariusz Jalowiec,
Clay Klinedinst>
* @date <3/1/2018>
*/

package project1;

import java.math.BigInteger;

public class Project1 {
    public static void main(String[] args){
        
        testShiftCipher(); //functional
        testSubstitutionCipher(); //functional
        testPoly(); //functional
        testRSA(); //functional
        testBlockCipher(); //functional
        testCBC(); //functional
        testMAC(); //functional
        testDigitalSignature(); //functional
        testCA();
    }
    
        //Shift Cipher Test
        public static void testShiftCipher(){
            //Shift Cipher Test
            System.out.println("------------------------------------");
            System.out.println("TESTING SHIFT CIPHER");
            System.out.println("------------------------------------");
            
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
            System.out.println("------------------------------------ \n");
        }
        
        //Substitution Cipher test
    	public static void testSubstitutionCipher() {
            System.out.println("------------------------------------");
            System.out.println("TESTING SUBSTITUTION CIPHER");
            System.out.println("------------------------------------");
                
            SubstitutionCipher test = new SubstitutionCipher();
            BigInteger message, key, encrypted, decrypted;
            message = new BigInteger("457836");
            key = new BigInteger("7894561230");
		
            //Print out Message and Key
            System.out.println("Message = " + message);
            System.out.println("Key = " + key);
		
            //Encrypt Message
            encrypted = test.encrypt(message, key);
            System.out.println("Encrypted Message = " + encrypted);
		
            //Decrypt Message
            decrypted = test.decrypt(encrypted, key);
            System.out.println("Decrypted Message = " + decrypted);
		
            System.out.println("------------------------------------ \n");
        }
        
        //Polyalphabetic Cipher test
        public static void testPoly()
        {
            System.out.println("------------------------------------");
            System.out.println("TESTING POLYALPHABETIC CIPHER");
            System.out.println("------------------------------------");
            PolyalphabeticCipher test = new PolyalphabeticCipher();
            BigInteger key = new BigInteger("1234");
            BigInteger polyMessage = new BigInteger("150011");
            System.out.println("Orginal Mesaage: " +polyMessage);
            BigInteger result = test.encrypt(polyMessage, key);
            System.out.println("Encrypted Message: " + result);
            System.out.println("Decrypted Message: "  + test.decrypt(result, key));
            System.out.println("------------------------------------ \n");
        }
        
         //RSA test
        public static void testRSA(){
            System.out.println("------------------------------------");
            System.out.println("TESTING RSA");
            System.out.println("------------------------------------");
            
            RSA testRSA = new RSA();
            
            //Generate new Keys
            testRSA.genKeys();
            BigInteger[] PrivKey = testRSA.getPrivateKey();
            BigInteger[] PubKey = testRSA.getPublicKey(); 
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
            System.out.println("Decrypted Message using cipher and Private Key: " + message); 
            System.out.println("------------------------------------ \n");
        }    
        
        //Block Cipher Test
        public static void testBlockCipher()
        {
            System.out.println("------------------------------------");
            System.out.println("TESTING BLOCK CIPHER");
            System.out.println("------------------------------------");
            
            BlockCipher BCcode = new BlockCipher();
            BigInteger BCplainMessage, BCcipherMessage, BCdecodedMessage;
            BCplainMessage = new BigInteger("1234567890");
            
            //Print out original message and expected encrypted message
            System.out.println("Original Messaage: " + BCplainMessage);
            System.out.println("Expected Encrypted Message: 7543201986");
            
            //Encrypt message and print out result
            BCcipherMessage = BCcode.encrypt(BCplainMessage);
            System.out.println("Encrypted Message: " + BCcipherMessage);
            
            //Decrypt message and print out result
            BCdecodedMessage = BCcode.decrypt(BCcipherMessage);
            System.out.println("Decrypted Message: " + BCdecodedMessage);
            System.out.println("------------------------------------ \n");
        }

        //CBC test
        public static void testCBC(){
            System.out.println("------------------------------------");
            System.out.println("TESTING CIPHER BLOCK CHAIN");
            System.out.println("------------------------------------");
            
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
            System.out.println("------------------------------------ \n");
        }
       
        //MAC test
        public static void testMAC(){
            System.out.println("------------------------------------");
            System.out.println("TESTING MESSAGE AUTHENTICATION CODE");
            System.out.println("------------------------------------");
            
            MacCipher test = new MacCipher();
            BigInteger plain = new BigInteger("15015");
            BigInteger secret = new BigInteger("2");
            test.encrypt(plain, secret);
            BigInteger result = test.encrypt(plain, secret);
             System.out.println("Secret Used: " + secret);
            System.out.println("Orginal Message: " + plain);
            System.out.println("Encrypted Message: " + result);
            BigInteger check = test.decrypt(result, secret);
            System.out.println("Decrypted Mesaage: " + check);
            System.out.println("------------------------------------ \n");
            
        }
        
        //Digital Signature test
        public static void testDigitalSignature(){
            System.out.println("------------------------------------");
            System.out.println("TESTING DIGITAL SIGNATURE");
            System.out.println("------------------------------------");
            
            //Creates DS and RSA
            DigitalSignature testDS = new DigitalSignature();
            RSA testRSA = new RSA();
            
            //Generate new Keys
            testRSA.genKeys();
            BigInteger[] PrivKey = testRSA.getPrivateKey();
            BigInteger[] PubKey = testRSA.getPublicKey(); 
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
            System.out.println("------------------------------------ \n");
        }
        
        //CA test
        public static void testCA(){
            System.out.println("------------------------------------");
            System.out.println("TESTING CERTIFICATE AUTHORITY");
            System.out.println("------------------------------------");
            
            BigInteger key,ID;
            ID = BigInteger.ONE;
            key = new BigInteger("45");
            CA test = new CA();
            boolean result = test.certify(ID,key);
            System.out.println("The CA authority has the key inside it?: " + result);
            
            System.out.println("------------------------------------ \n");
        }
}
