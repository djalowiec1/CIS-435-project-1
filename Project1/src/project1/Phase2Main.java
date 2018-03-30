/**
* 

* <P>Receiver - Processes Packets to Decrypt Messages from Sender over Network

 * @author <Dariusz Jalowiec, Tom Callahan>
 * @date <3/24/2018>
 */
package project1;

import java.math.BigInteger;
import java.util.Arrays;

public class Phase2Main {
    public static void main(String[] args){
        System.out.println("***** Secure Message System Simulation ***** ");
        
        //////////////////create entities////////////////////////////
        System.out.println("-----Entity Creation-----");
                CA ca = new CA();
 
        // CA is created

        System.out.println("CA is created.");

        //Sender Created and given access to CA
        Sender sndr = new Sender();
        sndr.getCA(ca);
        System.out.println("Sender is created.");
        BigInteger senderid = new BigInteger("1");
        
        //sender puts SPub into CA
        System.out.println("SENDER ID INITIAL: " + sndr.givePublicKey()[0] + "\n" + sndr.givePublicKey()[1]);
        ca.register(senderid, sndr.givePublicKey());
        System.out.println("Sender registered with CA. Public Key: " + Arrays.toString(ca.getKey(senderid)));

        //Create receiver and give public key to CA
        Receiver rcvr = new Receiver();

        System.out.println("Receiver Created");        
        ca.register(BigInteger.ZERO, rcvr.givePublicKey());
        System.out.println("Receiver registered with CA. Public Key: " + Arrays.toString(rcvr.givePublicKey()));

        
        Network ntwk = new Network(ca);
        System.out.println("Network (Internet) Created.");


        
        ///////////////////////////TESTING///////////////////////////////////
        //create message for sender to send
        BigInteger m = new BigInteger("15");
        System.out.println("\n-------Testing-------");
        System.out.println("Orginal Message: "+ m);
        System.out.println("Sender Passes Encrypted message packet to network.. ");

        ntwk.getPacketFromSender(m);
 
        System.out.println("Network Passes Message Packet to Receiver.. ");
        System.out.println("============================================");
        System.out.println("Decrypted Message with no hacking:");
        ntwk.deliverPacketToReceiver();
        System.out.println("============================================");
        System.out.println("Decrypted Message with hacking:");
        ntwk.packetGetHacked();
           
    }
}
