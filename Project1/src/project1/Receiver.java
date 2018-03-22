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
   
    BigInteger[] packet = new BigInteger[3];
    //Default Message
    public void processPacket(){
   

    }
    
    //ShiftCipher + RSA + MAC + CA

    public BigInteger getMessage1(){
        return message;
    }
    //CBC + RSA +MAC + CA
      public BigInteger  getMessage2(){
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
    
    public void receivePacket(BigInteger[] packet1){
        
        
        packet = packet1;
    }
}
