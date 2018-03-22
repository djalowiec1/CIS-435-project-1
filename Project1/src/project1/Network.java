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
    BigInteger m = new BigInteger("15");
    int hackedMessage;
    
    public BigInteger packetGetHacked()
    {
        hackedMessage = m.intValue();
        hackedMessage+=5;
        m = BigInteger.valueOf(hackedMessage);
        return m;
    }
    
    public BigInteger getPacketFromSender()
    {
 
        return m;
    }
    
    public BigInteger deliverPacketToReceiver()
    {
        
        return m;
    }
    
}
