/**
 *
 * @author cklin
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
    
    public BigInteger[] givePublicKeys(){
        
    }
    
    public void getPacketFromSender(BigInteger m)
    {
        message = m;
        packet = sndr.sendPacketToNetwork(m);
        i = sndr.getCombo();
        message = packet[0];
        for (BigInteger packet1 : packet) {
             System.out.println(packet1);
       }
       //System.out.println(message);
    }
    
    public void deliverPacketToReceiver()
    {
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
