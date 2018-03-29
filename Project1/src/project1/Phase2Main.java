/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.math.BigInteger;

public class Phase2Main {
    public static void main(String[] args){
        System.out.println("***** Secure Message System Simulation ***** ");
        
        // CA is created
        CA ca = new CA();
        System.out.println("CA CREATED");

        //Sender Created 
        Sender sndr = new Sender();
        sndr.getCA(ca);
        System.out.println("SENDER CREATED");
        BigInteger senderid = new BigInteger("1");
        //sender puts SPub into CA
        ca.register(senderid, sndr.givePublicKey());

        //Create receiver
        Receiver rcvr = new Receiver();

        //receiver creates keys
        ca.register(BigInteger.ZERO, rcvr.givePublicKey());
       // sndr.getCA(ca);
        // network
        Network ntwk = new Network();

        //create message for receiver to send
        BigInteger m = new BigInteger("15");
       
       
       System.out.println("-------Testing------------");
       // System.out.println("ShiftCipher + RSA + MAC + CA");
        System.out.println("Orginal Message: "+ m);
        System.out.println("We send message to Sender to create the packer: ");

        ntwk.getPacketFromSender(m);
 
        System.out.println("We send message to Receiver to decrypt the packer: ");
        System.out.println("============================================");
        System.out.println("Decrypted Message with no hacking:");
        System.out.println("============================================");
        ntwk.deliverPacketToReceiver();
        System.out.println("Decrypted Message with hacking:");
        ntwk.packetGetHacked();
        
        
     //   System.out.println("Combination Two");

        //ntwk.getPacketFromSender(m);
       // ntwk.packetGetHacked();
           
    }
}
