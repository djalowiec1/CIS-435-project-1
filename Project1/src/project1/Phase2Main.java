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
        System.out.println("SENDER CREATED");

        //sender puts SPub into CA
        ca.register(sndr.id, sndr.givePublicKey());

        //Create receiver
        Receiver rcvr = new Receiver();

        //receiver creates keys
        ca.register(rcvr.id, rcvr.givePublicKey());

        // network
        Network ntwk = new Network();

        //create message for receiver to send
        BigInteger m = new BigInteger("15");
       
       
       System.out.println("-------Testing------------");
       // System.out.println("ShiftCipher + RSA + MAC + CA");
        System.out.println("Orginal Message: "+ m);
        System.out.println("Packet Sender Sends out: ");
        ntwk.getPacketFromSender(m);
        System.out.println("Decrypted Message with no hacking:");
        ntwk.deliverPacketToReceiver();
        System.out.println("Decrypted Message with hacking:");
        ntwk.packetGetHacked();
        System.out.println("============================================");
        
        
     //   System.out.println("Combination Two");

        //ntwk.getPacketFromSender(m);
       // ntwk.packetGetHacked();
           
    }
}
