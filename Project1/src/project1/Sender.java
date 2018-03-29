/**
* <p>Receives the message from network, then asks the user which combo to use. Then encrypts and sends over network
*
* @author <Dariusz Jalowiec>
* @date <3/1/2018>
*/

package project1;

import static java.lang.System.in;
import java.math.BigInteger;
import java.util.Scanner;
  
public class Sender {
    
    //all the classess are refrenced
    
      BlockCipher block = new BlockCipher();
      CBC cbc = new CBC();
      DigitalSignature dg = new DigitalSignature();
      MacCipher mc = new MacCipher();
      PolyalphabeticCipher poly = new PolyalphabeticCipher();
      RSA rsa = new RSA();
      ShiftCipher shift = new ShiftCipher();
      SubstitutionCipher sub = new SubstitutionCipher();
      private BigInteger message;
      BigInteger id = BigInteger.ZERO;
      int i;
      BigInteger[] packet = new BigInteger[3];
    //Default Message
         private BigInteger[] privateKey;
         BigInteger[] publicKey;
    
    
    public Sender(){
        System.out.println("Hello???");
        rsa.genKeys();
        System.out.println("Am i generating keys?");
        privateKey = rsa.getPrivateKey();
        publicKey = rsa.getPublicKey();
        BigInteger id = BigInteger.ZERO; 
    }
    
    //gets called when message is received
    public void processMessage(BigInteger m){
        message = m;
        generateMessage1();
        //for (BigInteger packet1 : packet) {
        //     System.out.println(packet1);
      // }
      //asks user which combo to use
      
        rsa.genKeys();
        System.out.println("Pick Which combination of Ciphers you want to use?: ");
        System.out.println("1: ShiftCipher + RSA + MAC + CA?: ");
        System.out.println("2: CBC + RSA + MAC + CA?: ");
        System.out.println("3: SubstitutionCipher + RSA + DigitalSignature + CA?: ");
        System.out.println("4: polyalpaabetic + RSA + DigitalSignature + CA?: ");
        
        
        //calls the class that matches the chocie
       Scanner sc = new Scanner(System.in);
       i = sc.nextInt();
          switch (i) {
              case 1:
                  generateMessage1();
                  break;
              case 2:
                  generateMessage2();
                  break;
              default:
                  generateMessage3();
                  break;
          }
        
        
        
    
    }
    //a helper class to return which combo was added
    public int getCombo(){
        return i;
    }
    
    //ShiftCipher + RSA + hash + CA

    public BigInteger[] generateMessage1(){
        BigInteger sharedSecret = new BigInteger("2");
        //the message is shifted, and result is put in first part array index
        packet[0] = shift.encrypt(message, sharedSecret);
        // the receivers public key is taken from CA
        BigInteger[] ReceiverKey = ca.getKey(id);
        //key is ecrypted with the sharedsecret and public key of receiver
        BigInteger result = rsa.encrypt(sharedSecret, ReceiverKey);
        //result is put inside the pakcet[2];
        packet[1] = result;
        //the message is hased, and ecrtpted with the shift 
         BigInteger hash = dg.hash(message);
         packet[2] = shift.encrypt(hash, sharedSecret);
   
        return packet;
    }
    //CBC + RSA +MAC + CA
      public BigInteger[]  generateMessage2(){
        BigInteger sharedSecret = new BigInteger("2");
        //the message is encrypted with cbc, and result is put in first part array index
        packet[0] = cbc.encrypt(message, sharedSecret);
        // the receivers public key is taken from CA
        BigInteger[] ReceviverKey = ca.getKey(id);
        //key is ecrypted with the public key of the receiver
        BigInteger result = rsa.encrypt(sharedSecret, ReceviverKey);
        packet[1] = result;
         //mac cipher is used to hash the message with the shared secret and make sure nothing was changed, result put in packet[2]
        packet[2] = mc.encrypt(message, sharedSecret);
        return packet;
    }
      //SubstitutionCipher+ RSA + DigitalSignature + CA
        public BigInteger[] generateMessage3(){
        BigInteger sharedSecret = new BigInteger("2");
         //the message is encrypted with subisitute, and result is put in first part array index
        packet[0] = sub.encrypt(message, sharedSecret);
        //key is ecrypted with the public key of the receiver
        BigInteger[] ReceviverKey = ca.getKey(id);
        //key is ecrypted with the shared secret and public key, result is put inside pakcer[1]
        BigInteger result = rsa.encrypt(sharedSecret, ReceviverKey);
        packet[1] = result;
         //digitial signature cipher is used to hash the message and make sure nothing was changed, result put in packet[2]
        packet[2] = dg.sign(message, privateKey);
        
        return packet;
    }
    //polyalabetic + RSA + DigitalSignature + CA

    //connects to network
    public BigInteger[] sendPacketToNetwork(BigInteger m){
        
        processMessage(m);
        return packet;
    }

    //Give Network the Public Key to hand to CA
    public BigInteger[] givePublicKey(){
        return publicKey;
    }   
}
