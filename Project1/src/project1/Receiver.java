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
public class Receiver {
       BlockCipher block = new BlockCipher();
      CA ca = new CA();
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
        if(i ==1){
            getMessage1();
        }
        else if(i ==2){
            getMessage2();
         }
        else if(i ==3){
            getMessage3();
        }
        else
            getMessage4();

    }
    
    //ShiftCipher + RSA + MAC + CA

    public BigInteger getMessage1(){
        return message;
    }
    //CBC + RSA +MAC + CA
      public BigInteger  getMessage2(){
        BigInteger secret = new BigInteger("2");
        BigInteger key = new BigInteger("5");
        BigInteger person = new BigInteger("1");
        //get the message by decryting the first packet
        BigInteger receivedMessage = shift.decrypt(packet[0], key);
        //get the public key by callin CA
        BigInteger[] publicKey = ca.getKey(person);
        
        //decrypt the RSA from orginal message
         BigInteger rsa1 = rsa.decrypt(secret, publicKey);
         //decrypt the hash function to see
         //BigIntenger decryptedMessage = 
         
        return message;
    }
      //SubstitutionCipher+ RSA + DigitalSignature + CA
    public BigInteger getMessage3(){
               return message;
    }
        //polyalabetic + RSA + DigitalSignature + CA
        public BigInteger getMessage4(){
      
            return message;
     }
    
    public void receivePacket(BigInteger[] packet1, int combo){
        
        i = combo;
        packet = packet1;
    }
}
