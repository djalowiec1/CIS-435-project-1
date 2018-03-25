/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author darek
 */
public class Receiver extends Network  {
    BlockCipher block = new BlockCipher();
    CBC cbc = new CBC();
    DigitalSignature dg = new DigitalSignature();
    MacCipher mc = new MacCipher();
    PolyalphabeticCipher poly = new PolyalphabeticCipher();
    RSA rsa = new RSA();
    ShiftCipher shift = new ShiftCipher();
    SubstitutionCipher sub = new SubstitutionCipher();
    private BigInteger message;
    private int senderID;
    int i;
   
    BigInteger[] packet = new BigInteger[3];
    

    //Default Message
    public void processPacket(){
          switch (i) {
              case 1:
                  getMessage1();
                  break;
              case 2:
                  getMessage2();
                  break;
              case 3:
                  getMessage3();
                  break;
              default:
                  getMessage4();
                  break;
          }

    }
    
    //ShiftCipher + RSA + Hash + CA

    public BigInteger getMessage1(){
        BigInteger secret;
        
        //Find out Secret using packet[1]
        secret = rsa.decrypt(secret, packet)
        
        //Ksh(m) KrcPub(m) 
        
        //Sender checks if hashed message from mac = hashed message sent
        BigInteger messageCheck;
        messageCheck = dg.hash(message);
        if(messageCheck.equals(packet[2])){
            System.out.println("Messages are Good to Use - Unchanged");
            return message;
        }else{
            System.out.println("DO NOT USE MESSAGE. IT HAS CHANGED.");
            return BigInteger.ZERO;
        }
    }

    
    public BigInteger  getMessage2(){
        
        BigInteger secret = new BigInteger("2");
        BigInteger key = new BigInteger("5");
        BigInteger person = new BigInteger("1");
        //get the message by decrypting the first packet
        BigInteger receivedMessage = shift.decrypt(packet[0], key);
        //get the public key by calling CA
        BigInteger[] publicKey = ca.getKey(person);
        
        //decrypt the RSA from orginal message
         BigInteger rsa1 = rsa.decrypt(secret, publicKey);
         //decrypt the hash function to see
         //BigIntenger decryptedMessage = 
         
        return message;
    }
    
    //SubstitutionCipher+ RSA + DigitalSignature + CA
    public BigInteger getMessage3(){        
        BigInteger secret = new BigInteger("2");
        BigInteger key = new BigInteger("5");
        
        message = sub.decrypt(packet[0], key);
        
        dg.verifyDS(message, , )
        return message;
    }
    
    //polyalabetic + RSA + DigitalSignature + CA
    public BigInteger getMessage4(){
        BigInteger secret = new BigInteger("2");
        BigInteger key = new BigInteger("1234");
        
        message = poly.decrypt(packet[0], key);


        return message;
    }
    
    public void receivePacket(BigInteger[] packet1, int combo){
        
        i = combo;
        packet = packet1;
    }
}
