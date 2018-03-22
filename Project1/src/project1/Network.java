/**
 *
 * @author cklin
 */

package project1;

import java.math.BigInteger;

public class Network 
{
    Sender sndr = new Sender();
    //Receiver rcvr = new Receiver();
    BigInteger[] packet;
    BigInteger message;
    int hackedMessage;
    
    public void getPacketFromSender(BigInteger m)
    {
        message = m;
        packet = sndr.sendPacketToNetwork();
        
        message = packet[1];
        
    }
    
    public void deliverPacketToReceiver()
    {
        
    }
    
    public BigInteger packetGetHacked()
    {
        hackedMessage = message.intValue();
        hackedMessage+=5;
        message = BigInteger.valueOf(hackedMessage);
        packet[1] = message;
        return message;
    }
}
