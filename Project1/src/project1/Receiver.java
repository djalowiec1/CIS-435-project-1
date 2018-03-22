/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.math.BigInteger;

/**
 *
 * @author darek
 */
public class Receiver {
        
    private BigInteger message;
    private int senderID;
   
    //Default Message
    public BigInteger receivePacket(){
        
        message = new BigInteger("15");
        return message;
    }
    
    //Creates passed message
    public BigInteger processPacket(BigInteger m){
        message = m;
        return message;
    }
    
    public BigInteger getMessage(){
        
        
        return message;
    }
    
    
}
}
