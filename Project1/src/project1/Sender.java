/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import static java.lang.System.in;
import java.math.BigInteger;
import java.util.Scanner;
  
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
    int i;
    BigInteger[] packet = new BigInteger[3];
    //Default Message
    public void processMessage(BigInteger m){
        message = m;
        generateMessage1();
        for (BigInteger packet1 : packet) {
             System.out.println(packet1);
       }
        System.out.println("Pick Which combination of Ciphers you want to use?: ");
        System.out.println("1: ShiftCipher + RSA + MAC + CA?: ");
        System.out.println("2: CBC + RSA +MAC + CA?: ");
        System.out.println("3: SubstitutionCipher+ RSA + DigitalSignature + CA?: ");
        System.out.println("4: polyalabetic + RSA + DigitalSignature + CA?: ");
        
        
       Scanner sc = new Scanner(System.in);
       i = sc.nextInt();
        if(i == 1){
            generateMessage1();
        }
        else if(i == 2){
            generateMessage2();
        }
         else if(i == 3){
            generateMessage3();
        }
        else
             generateMessage4();
        
        
        
        sendPacketToNetwork();
    }
    
    public int getCombo(){
        return i;
    }
    
    //ShiftCipher + RSA + MAC + CA

    public BigInteger[] generateMessage1(){
        BigInteger secret = new BigInteger("2");
        BigInteger key = new BigInteger("5");
        packet[0] = shift.encrypt(message, key);
        rsa.genKeys();
    
        BigInteger result = rsa.encrypt(message, rsa.getPublicKey());
        BigInteger person = new BigInteger("1");
        ca.register(person, rsa.getPublicKey());
        packet[1] = result;
        
        packet[2] = mc.encrypt(result, secret);
        return packet;
    }
    //CBC + RSA +MAC + CA
      public BigInteger[]  generateMessage2(){
        BigInteger CBCkey = new BigInteger("2");
        BigInteger secret = new BigInteger("2");

        packet[0] = cbc.encrypt(message, CBCkey);
        rsa.genKeys();
        
        BigInteger result = rsa.encrypt(message, rsa.getPublicKey());
         BigInteger person = new BigInteger("1");
        ca.register(person, rsa.getPublicKey());
        packet[1] = result;
        packet[2] = mc.encrypt(result, secret);
        return packet;
    }
      //SubstitutionCipher+ RSA + DigitalSignature + CA
        public BigInteger[] generateMessage3(){
        BigInteger secret = new BigInteger("2");
        BigInteger key = new BigInteger("5");
        packet[0] = sub.encrypt(message, key);
        rsa.genKeys();
        BigInteger result = rsa.encrypt(message, rsa.getPublicKey());
        packet[1] = result;
        BigInteger[] privateKey = rsa.getPrivateKey();
        BigInteger person = new BigInteger("1");
        ca.register(person, rsa.getPublicKey());
        BigInteger[] finalone = dg.sign(result, privateKey);
        packet[2] = finalone[1];
        
        return packet;
    }
        //polyalabetic + RSA + DigitalSignature + CA
        public BigInteger[] generateMessage4(){
            BigInteger secret = new BigInteger("2");
            BigInteger key = new BigInteger("1234");
            packet[0] = poly.encrypt(message, key);
            rsa.genKeys();
            BigInteger result = rsa.encrypt(message, rsa.getPublicKey());
            packet[1] = result;
            BigInteger person = new BigInteger("1");
            ca.register(person, rsa.getPublicKey());
            BigInteger[] privateKey = rsa.getPrivateKey();
            BigInteger[] finalone = dg.sign(result, privateKey);
            packet[2] = finalone[1];
        
        return packet;
    }
    
    public BigInteger[] sendPacketToNetwork(){
        
        
        return packet;
    }


    
    
}