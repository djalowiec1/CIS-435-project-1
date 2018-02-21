/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.math.*;

/**
 *
 * @author Emily
 */
public class CBC {
    public BigInteger key;
    public int blockLength;
    public BigInteger plainText;
    public BigInteger cipherText;
    
    //Encrypts 
    public BigInteger encrypt(BigInteger plainText, BigInteger key)
    {
        return plainText;
    }
    public BigInteger decrypt(BigInteger cipherText, BigInteger key)
    {
        return cipherText;
    }
}
