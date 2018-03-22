/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.math.BigInteger;
  
public class Sender {
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
   
    //Default Message
    public BigInteger generateMessage(){
        
        message = new BigInteger("15");
        return message;
    }
    
    //Creates passed message
    public BigInteger generateMessage1(BigInteger m){
        message = m;
        return message;
    }
      public BigInteger generateMessage2(BigInteger m){
        message = m;
        return message;
    }
        public BigInteger generateMessage3(BigInteger m){
        message = m;
        return message;
    }
    
    public BigInteger sendPacketToNetwork(){
        
        
        return message;
    }
    
    
}