/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.math.*;

/**
 *
 * @author cklin
 */
public class BlockCipher 
{
    
    public BigInteger[] createKey()
    {
        BigInteger[] map = new BigInteger[10];
        map[0] = BigInteger.valueOf(6);
        map[1] = BigInteger.valueOf(7);
        map[2] = BigInteger.valueOf(5);
        map[3] = BigInteger.valueOf(4);
        map[4] = BigInteger.valueOf(3);
        map[5] = BigInteger.valueOf(2);
        map[6] = BigInteger.valueOf(0);
        map[7] = BigInteger.valueOf(1);
        map[8] = BigInteger.valueOf(9);
        map[9] = BigInteger.valueOf(8);
        return map;
    }
    
    public BigInteger encrypt(BigInteger plaintext, BigInteger[] map)
    {
        BigInteger ciphertext = new BigInteger("1");
        
        plaintext.toString();
        
        
        
        
        
        
        return ciphertext;
    }
    
    
    
  
}
