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
     
     // Sender sndr = new Sender();
     // sender creates keys
     // sender puts SPub into CA
     
//      Receiver rcvr = new Receiver();
//      receiver creates keys
//      receiver puts keys into CA

    // network
    
    // network operations

        

        Network net = new Network();
     //   System.out.println("Sender is Created");
        Network ntwk = new Network();
        BigInteger m = new BigInteger("15");
       // Sender p = new Sender();
       
       
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
