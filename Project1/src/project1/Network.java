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
    BigInteger message;
    int hackedMessage;
    
    public void getPacketFromSender()
    {
        
        
    }
    
    public void deliverPacketToReceiver()
    {
        
    }
    
    public BigInteger packetGetHacked()
    {
        hackedMessage = message.intValue();
        hackedMessage+=5;
        message = BigInteger.valueOf(hackedMessage);
        return message;
    }
}
