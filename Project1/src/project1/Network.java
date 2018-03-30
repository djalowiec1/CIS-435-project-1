/**
 * @author <Clay Klinedinst>
 * @date <3/22/18>
 * 
 * <p> Acts as the "middle man" between sender and receiver. Calls the sender,
 * and gets the packet from it, then calls the receiver and sends the packet
 * to it. Also allows the packet to be hacked and altered.
 */

package project1;

import java.math.BigInteger;

public class Network 
{
    public CA ca;
    Receiver rcvr = new Receiver();
    Sender sndr = new Sender();
    BigInteger[] packet;
    BigInteger message;
    int hackedMessage;
    int i;
    
    public Network(){
        ca = new CA();
        //Register Sender
        ca.register(BigInteger.ONE, sndr.givePublicKey());        
        //Register Receiver
        ca.register(BigInteger.ZERO, rcvr.givePublicKey());
    }
    
    public BigInteger[] getKeyFromCA(BigInteger ID){
        return ca.getKey(ID);
    } 
    
    public void getPacketFromSender(BigInteger m)
    {
        message = m;
        sndr.getCA(ca);

        packet = sndr.sendPacketToNetwork(m);
        i = sndr.getCombo();
        message = packet[0];
    }
    
    public void deliverPacketToReceiver()
    {
        rcvr.getCA(ca);
        rcvr.receivePacket(packet, i);
        //System.out.println("Message is:" + );
        
    }
    
    public BigInteger packetGetHacked()
    {
        hackedMessage = message.intValue();
        hackedMessage+=5;
        message = BigInteger.valueOf(hackedMessage);
        packet[0] = message;
        rcvr.receivePacket(packet, i);
        System.out.println("Hacked Message: " + message);
        return message;
    }
}
