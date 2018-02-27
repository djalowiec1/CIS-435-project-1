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
    BigInteger[] ekey = new BigInteger[10];
    BigInteger[] dkey = new BigInteger[10];
    
    public void createKey()
    {
        BigInteger[] ekey = new BigInteger[10];
        BigInteger[] dkey = new BigInteger[10];
        
        ekey[0] = BigInteger.valueOf(6);
        ekey[1] = BigInteger.valueOf(7);
        ekey[2] = BigInteger.valueOf(5);
        ekey[3] = BigInteger.valueOf(4);
        ekey[4] = BigInteger.valueOf(3);
        ekey[5] = BigInteger.valueOf(2);
        ekey[6] = BigInteger.valueOf(0);
        ekey[7] = BigInteger.valueOf(1);
        ekey[8] = BigInteger.valueOf(9);
        ekey[9] = BigInteger.valueOf(8);
  
        dkey[6] = BigInteger.valueOf(0);
        dkey[7] = BigInteger.valueOf(1);
        dkey[5] = BigInteger.valueOf(2);
        dkey[4] = BigInteger.valueOf(3);
        dkey[3] = BigInteger.valueOf(4);
        dkey[2] = BigInteger.valueOf(5);
        dkey[0] = BigInteger.valueOf(6);
        dkey[1] = BigInteger.valueOf(7);
        dkey[9] = BigInteger.valueOf(8);
        dkey[8] = BigInteger.valueOf(9);
    }
    
    public BigInteger encrypt(BigInteger plaintext, BigInteger[] map)
    {
        BigInteger ciphertext = new BigInteger("1");
        
        plaintext.toString();
        
        
        
        
        return ciphertext;
    }
    
    
    
  
}
