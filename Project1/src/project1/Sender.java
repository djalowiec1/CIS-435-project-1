/**
* <p>Receives the message from network, then asks the user which combo to use. Then encrypts and sends over network
*
* @author <Dariusz Jalowiec, Tom Callahan>
* @date <3/1/2018>
*/

package project1;

import static java.lang.System.in;
import java.math.BigInteger;
import java.util.Scanner;
  
public class Sender {
    
    //all the classes are referenced    
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
    CA ca;
    BigInteger[] packet = new BigInteger[4]; //0
    private BigInteger[] privateKey;
    BigInteger[] publicKey;
    
    
    public Sender(){
        rsa.genKeys();
        privateKey = rsa.getPrivateKey();
//        System.out.println("PrivateKeyHELLO: " + privateKey[0] + "\n\t\t\t" + privateKey[1]);
        publicKey = rsa.getPublicKey();
        BigInteger id = BigInteger.ZERO; 
    }
    
    //gets called when message is received
    public void processMessage(BigInteger m){
        message = m;
        
        //asks user which combo to use      
        System.out.println("Pick Which combination of Ciphers you want to use?: ");
        System.out.println("1: ShiftCipher + RSA + Hash + CA?: ");
        System.out.println("2: CBC + RSA + MAC + CA?: ");
        System.out.println("3: SubstitutionCipher + RSA + DigitalSignature + CA?: ");
        
        
        //calls the class that matches the choice
        Scanner sc = new Scanner(System.in);
        i = Integer.parseInt(sc.nextLine());
        switch (i) {
            case 1:
                packet = generateMessage1();
                break;
            case 2:
                packet = generateMessage2();
                break;
            case 3:
                packet= generateMessage3();
                break;
            default:
                System.out.println("wrong choice");
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
        System.out.println("Packet[0] = Kshift(M)");
        
        //the receivers public key is taken from CA
        BigInteger id1 = BigInteger.ZERO;
        BigInteger[] ReceiverKey = new BigInteger[2];
        ReceiverKey = ca.getKey(id1);
        
        //key is ecrypted with the sharedsecret and public key of receiver
        BigInteger result = rsa.encrypt(sharedSecret, ReceiverKey);
        //result is put inside the packet[1];
        packet[1] = result;
        System.out.println("Packet[1] = KbPublic(Kshift)");
        
        //the message is hased, and ecrtpted with the shift 
        BigInteger hash = dg.hash(message);
        packet[2] = shift.encrypt(hash, sharedSecret);
        System.out.println("Packet[2] = Kshift(H(m))");
   
        return packet;
    }
    
    //CBC + RSA +MAC + CA
    public BigInteger[]  generateMessage2(){
        BigInteger sharedSecret = new BigInteger("2");
        
        //the message is encrypted with cbc, and result is put in first part array index
        packet[0] = cbc.encrypt(message, sharedSecret);
        System.out.println("Packet[0] = Kcbc(M)");
        
        //the receivers public key is taken from CA
        BigInteger id1 = BigInteger.ZERO;
        BigInteger[] ReceviverKey = ca.getKey(id1);
        
        //key is ecrypted with the public key of the receiver
        BigInteger result = rsa.encrypt(sharedSecret, ReceviverKey);
        packet[1] = result;
        System.out.println("Packet[1] = KbPublic(Kcbc)");
        
        //mac is used to hash the message with the shared secret and make sure nothing was changed, result put in packet[2]
        packet[2] = mc.encrypt(message, sharedSecret);
        System.out.println("Packet[2] = H(s+m)+m");

        return packet;
    }
    
    //SubstitutionCipher+ RSA + DigitalSignature + CA
    public BigInteger[] generateMessage3(){
        BigInteger sharedSecret = new BigInteger("2");        
        //the message is encrypted with substitution cipher, and result is put in first part array index
        packet[0] = sub.encrypt(message, sharedSecret);
        System.out.println("Packet[0] = Ksub(M)");
        
        //key is ecrypted with the public key of the receiver
        BigInteger[] ReceviverKey = ca.getKey(id);
        //key is ecrypted with the shared secret and public key, result is put inside pakcet[1]
        BigInteger result = rsa.encrypt(sharedSecret, ReceviverKey);
        packet[1] = result;
        System.out.println("Packet[1] = KbPublic(Ksub)");

        //digitial signature cipher is used to hash the message and make sure nothing was changed, result put in packet[2]
        packet[2] = dg.sign(message, privateKey);
        System.out.println("Packet[2] = KaPrivate((H(m))");
        
        return packet;
    }

    //connects to network
    public BigInteger[] sendPacketToNetwork(BigInteger m){
        processMessage(m);
        return packet;
    }

    //Lets Sender Access CA
    public void getCA(CA c_a){
        ca = c_a;
    }
    
    //Give Network the Public Key to hand to CA
    public BigInteger[] givePublicKey(){
        return publicKey;
    }   
}
