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
    public BigInteger eIV;
    public BigInteger dIV;
    public BigInteger plainText;
    public BigInteger cipherText;
    
    //Encrypt message: input plaintext message and IV, output ciphertext message
    public BigInteger encrypt(BigInteger plainText, BigInteger eIV)
    {
        BigInteger encryptedText = plainText;
        
        //Stand in for loop
        for(int i = 0; i<10; i++)
        {
            //block xor eIV here
            //use key on block here
            //eIV = block
        }
        
        return encryptedText;
    }
    
    //Decrypt message: input ciphertext message and IV, output plaintext message
    public BigInteger decrypt(BigInteger cipherText, BigInteger dIV)
    {
        BigInteger decryptedText = cipherText;
        
        //Stand in for loop
        for(int i = 0; i<10; i++)
        {
            //nextdIV = block
            //use key on block here
            //block xor dIV here
            //dIV = nextdIV
        }
        
        return decryptedText;
    }
}
