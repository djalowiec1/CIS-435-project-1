/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.math.BigInteger;

public class Sender {
    
    private BigInteger message;
    private int senderID;
   
    //Default Message
    public BigInteger generateMessage(){
        
        message = new BigInteger("15");
        return message;
    }
    
    //Creates passed message
    public BigInteger generateMessage(BigInteger m){
        message = m;
        return message;
    }
    
    public 
    
    
}