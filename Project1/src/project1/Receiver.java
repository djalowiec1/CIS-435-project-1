/*
* 

* Receiver - Processes Packets to Decrypt Messages from Sender over Network

 * @author <Tom Callahan>
 * @date <3/24/2018>
 */
package project1;

import java.math.BigInteger;

public class Receiver extends Network  {
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
    private BigInteger secret;
    private BigInteger message;
    int comboSelect;
    BigInteger[] privateKey;
    BigInteger[] publicKey;
    BigInteger[] packet = new BigInteger[3];
    
    //Constructor
    public Receiver(){
        rsa.genKeys();
        privateKey = rsa.getPrivateKey();
        publicKey = rsa.getPublicKey();
        BigInteger person = new BigInteger("0");
        ca.register(person, publicKey);    
    }
    
    //Receives Packet with selected Symmetric Key and Authenticity Combination.
    public void receivePacket(BigInteger[] packet1, int combo){        
        comboSelect = combo;
        packet = packet1;
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
        }
    }
    
    //ShiftCipher + RSA + Hash + CA
    public BigInteger getMessage1(){       
        //Find out Secret using packet[1]
        secret = rsa.decrypt(packet[1], privateKey);
        
        //get message using packet[0]
        message = shift.decrypt(packet[0], secret);
        
        //Sender checks if hashed message from mac = hashed message sent
        BigInteger messageCheck = dg.hash(message);
        if(messageCheck.equals(packet[2])){
            System.out.println("Messages are Good to Use - Unchanged");
            return message;
        }else{
            System.out.println("DO NOT USE MESSAGE. IT HAS CHANGED.");
            return BigInteger.ZERO;
        }
    }

    //CBC + RSA + MAC + CA
    public BigInteger  getMessage2(){
        //get the secret using packet[1]
        secret = rsa.decrypt(packet[1], privateKey);

        //get the message by decrypting the packet[0]
        message = cbc.decrypt(packet[0], secret);
        
        //Compare mac.encrypt with packet 2. if equal, message is good.
        BigInteger messageCheck = mc.encrypt(message, secret);
        if(messageCheck.equals(packet[2])){
            System.out.println("Messages are Good to Use - Unchanged");
            return message;
        }else{
            System.out.println("DO NOT USE MESSAGE. IT HAS CHANGED.");
            return BigInteger.ZERO;
        }
    }
    
    //SubstitutionCipher + RSA + DigitalSignature + CA
    public BigInteger getMessage3(){
        //get secret using packet[1]
        secret = rsa.decrypt(packet[1], privateKey);
              
        //Get the plaintext message using packet[0] and secret
        message = sub.decrypt(packet[0], secret);
        
        //Use DigitialSignature's verfification for authenticity
        if(dg.verifyDS(message, packet[0], publicKey)){
            System.out.println("Messages are Good to Use - Unchanged");
            return message;
        }else{
            System.out.println("DO NOT USE MESSAGE. IT HAS CHANGED.");
            return BigInteger.ZERO;
        }
    }
}
