/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.math.BigInteger;

/**
 *
 * @author tcallahan
 */
public class Phase2Main {
    public static void main(String[] args){
        System.out.println("***** Secure Message System Simulation ***** ");
        
        Sender sndr = new Sender();
        System.out.println("Sender is Created");
//        Receiver rcvr = new Receiver();
        Network ntwk = new Network();
        BigInteger m = new BigInteger("15");
        Sender p = new Sender();
        System.out.println("Combination One");
        System.out.println("Combination One");

        ntwk.getPacketFromSender(m);
        ntwk.packetGetHacked();
           
    }
}
