/*
* 

* Receiver - Processes Packets to Decrypt Messages from Sender over Network

 * @author <Tom Callahan>
 * @date <3/24/2018>
 */
package project1;

import java.math.BigInteger;

public class Receiver {
    //Class Tools
    BlockCipher block = new BlockCipher();
    CBC cbc = new CBC();
    DigitalSignature dg = new DigitalSignature();
    MacCipher mc = new MacCipher();
    PolyalphabeticCipher poly = new PolyalphabeticCipher();
    RSA rsa = new RSA();
    ShiftCipher shift = new ShiftCipher();
    SubstitutionCipher sub = new SubstitutionCipher();
    
    //Class Variables
    public BigInteger secret;
    public BigInteger receiverMessage;
    int comboSelect;
    BigInteger[] privateKey;
    BigInteger[] publicKey;
    BigInteger[] receiverPacket;
    final BigInteger person = BigInteger.ONE;
    BigInteger id;

    //Constructor
    public Receiver(){
        rsa.genKeys();
        privateKey = rsa.getPrivateKey();
        publicKey = rsa.getPublicKey();
        BigInteger id = BigInteger.ONE; 
    }
    
    //Receives Packet with selected Symmetric Key and Authenticity Combination.
    public void receivePacket(BigInteger[] packet1, int combo){        
        comboSelect = combo;
        receiverPacket = packet1;
        processPacket();
    }

    //Select Security Suite Combination
    public void processPacket(){
        switch (comboSelect) {
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
                System.out.println("wrong choice");
        }
    }
    
    //ShiftCipher + RSA + Hash + CA
    public BigInteger getMessage1(){       
        //Find out Secret using packet[1]
        secret = rsa.decrypt(receiverPacket[1], privateKey);
        
        //get message using packet[0]
        receiverMessage = shift.decrypt(receiverPacket[0], secret);
        
        //Sender checks if hashed message from mac = hashed message sent
        BigInteger messageCheck = dg.hash(receiverMessage);
       BigInteger shiftercheck = shift.encrypt(messageCheck, secret);
        if(shiftercheck.equals(receiverPacket[2])){
            System.out.println("Messages are Good to Use - Unchanged");
            System.out.println("DECREYPTED MESSAGE " + receiverMessage );
            return receiverMessage;
        }else{

            System.out.println("DO NOT USE MESSAGE. IT HAS CHANGED.");
            return BigInteger.ZERO;
        }
    }

    //CBC + RSA + MAC + CA
    public BigInteger  getMessage2(){
        //get the secret using packet[1]
        secret = rsa.decrypt(receiverPacket[1], privateKey);

        //get the message by decrypting the packet[0]
        receiverMessage = cbc.decrypt(receiverPacket[0], secret);
        
        //Compare mac.encrypt with packet 2. if equal, message is good.
        BigInteger messageCheck = mc.encrypt(receiverMessage, secret);
        if(messageCheck.equals(receiverPacket[2])){
            System.out.println("Messages are Good to Use - Unchanged");
            System.out.println("DECREYPTED MESSAGE " + receiverMessage );
            return receiverMessage;
        }else{
            System.out.println("DO NOT USE MESSAGE. IT HAS CHANGED.");
            return BigInteger.ZERO;
        }
    }
    
    //SubstitutionCipher + RSA + DigitalSignature + CA
    public BigInteger getMessage3(){
        //get secret using packet[1]
        secret = rsa.decrypt(receiverPacket[1], privateKey);
              
        //Get the plaintext message using packet[0] and secret
        receiverMessage = sub.decrypt(receiverPacket[0], secret);
        
        //Use DigitialSignature's verfification for authenticity
        if(dg.verifyDS(receiverMessage, receiverPacket[0], publicKey)){
            System.out.println("Messages are Good to Use - Unchanged");
            System.out.println("DECREYPTED MESSAGE " + receiverMessage );
            return receiverMessage;
        }else{
            System.out.println("DO NOT USE MESSAGE. IT HAS CHANGED.");
            return BigInteger.ZERO;
        }
    }
    
    //Give Network the Public Key to hand to CA
    public BigInteger[] givePublicKey(){
        return publicKey;
    }
}
