/**
* <p>Receives the message from network, then asks the user which combo to use. Then encrypts and sends over network
*
* @authors <Emily Benson, Tom Callahan, Cameron Conklin, Dariusz Jalowiec,
Clay Klinedinst>
* @date <3/1/2018>
*/

package project1;

import static java.lang.System.in;
import java.math.BigInteger;
import java.util.Scanner;
  
public class Sender extends Network {
    
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
        rsa.genKeys();
        privateKey = rsa.getPrivateKey();
        publicKey = rsa.getPublicKey();
        BigInteger person = new BigInteger("1");
        ca.register(person, publicKey);
        
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
              case 3:
                  generateMessage3();
                  break;
              default:
                  generateMessage4();
                  break;
          }
        
        
        
    
    }
    //a helper class to return which combo was added
    public int getCombo(){
        return i;
    }
    
    //ShiftCipher + RSA + hash + CA

    public BigInteger[] generateMessage1(){
        BigInteger secret = new BigInteger("2");
        BigInteger key = new BigInteger("5");
        //the message is shifted, and result is put in first part array index
        packet[0] = shift.encrypt(message, key);
        // the receivers public key is taken from CA
        BigInteger[] ReceviverKey = ca.getKey(id);
        //key is ecrypted with the message and public key of receiver
        BigInteger result = rsa.encrypt(secret, ReceviverKey);
        //result is put inside the pakcet[2];
        packet[1] = result;
        //mac cipher is used to hash the message and make sure nothing was changed, result put in packet[2]
         BigInteger hash = dg.hash(message);
         packet[2] = shift.encrypt(hash, key);
   
        return packet;
    }
    //CBC + RSA +MAC + CA
      public BigInteger[]  generateMessage2(){
        BigInteger CBCkey = new BigInteger("2");
        BigInteger secret = new BigInteger("2");
        //the message is encrypted with cbc, and result is put in first part array index
        packet[0] = cbc.encrypt(message, CBCkey);
        // the receivers public key is taken from CA
        BigInteger[] ReceviverKey = ca.getKey(id);
        //key is ecrypted with the message and public key, result is put inside pakcet[1]
        BigInteger result = rsa.encrypt(message, ReceviverKey);
        packet[1] = result;
         //mac cipher is used to hash the message and make sure nothing was changed, result put in packer[2]
        packet[2] = mc.encrypt(result, secret);
        return packet;
    }
      //SubstitutionCipher+ RSA + DigitalSignature + CA
        public BigInteger[] generateMessage3(){
        BigInteger secret = new BigInteger("2");
        BigInteger key = new BigInteger("5");
         //the message is encrypted with subisitute, and result is put in first part array index
        packet[0] = sub.encrypt(message, key);
         //rsa is called to generate the keys
         //key is ecrypted with the message and public key, result is put inside pakcer[1]
         BigInteger id = BigInteger.ZERO;
        BigInteger[] ReceviverKey = ca.getKey(id);
        BigInteger result = rsa.encrypt(message, ReceviverKey);
        packet[1] = result;
        // the public key is registered with the CA
         //digitial signature cipher is used to hash the message and make sure nothing was changed, result put in packer[2]
        BigInteger[] finalone = dg.sign(result, privateKey);
        packet[2] = finalone[1];
        
        return packet;
    }
    //polyalabetic + RSA + DigitalSignature + CA
    public BigInteger[] generateMessage4(){
        BigInteger secret = new BigInteger("2");
        BigInteger key = new BigInteger("1234");
        
        //the message is encrypted with polyaplhabetic, and result is put in first part array 
        packet[0] = poly.encrypt(message, key);
          //rsa is called to generate the keys
        //key is ecrypted with the message and public key of the receiver, result is put inside pakcet[1]
        BigInteger id = BigInteger.ZERO;
        BigInteger[] ReceviverKey = ca.getKey(id);
        BigInteger result = rsa.encrypt(message, ReceviverKey);
        packet[1] = result;
        BigInteger person = new BigInteger("1");  
        // the public key of the swis registered with the CA
        //digitial signature cipher is used to hash the message and make sure nothing was changed, result put in packer[2]
        BigInteger[] finalone = dg.sign(result, privateKey);
        packet[2] = finalone[1];

        return packet;
    }
    //connects to network
    public BigInteger[] sendPacketToNetwork(BigInteger m){
        
        processMessage(m);
        return packet;
    }


    
    
}