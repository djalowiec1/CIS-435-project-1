/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import static java.lang.System.in;
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
   
    BigInteger[] packet = new BigInteger[3];
    //Default Message
    public void processMessage(BigInteger m){
        message = m;
        generateMessage1();
        for (BigInteger packet1 : packet) {
             System.out.println(packet1);
       }
    }
    
    //Creates passed message
    public BigInteger[] generateMessage1(){
          BigInteger secret = new BigInteger("2");
        BigInteger key = new BigInteger("5");
        packet[0] = shift.encrypt(message, key);
        rsa.genKeys();
        BigInteger result = rsa.encrypt(message, rsa.getPublicKey());
        packet[1] = result;
        packet[2] = mc.encrypt(result, secret);
        return packet;
    }
      public BigInteger generateMessage2(BigInteger m){
        message = m;
        return message;
    }
        public BigInteger generateMessage3(BigInteger m){
        message = m;
        return message;
    }
    
    public BigInteger[] sendPacketToNetwork(){
        
        
        return packet;
    }

    private void each(BigInteger packet1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}