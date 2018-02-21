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
public class ShiftCipher {
    public BigInteger plainText;
    public BigInteger cipherText;
    public BigInteger key;
    
    //Encrypt message: input plaintext message and shift key, output ciphertext message
    public BigInteger encrypt(BigInteger plainText, BigInteger key)
    {
        return plainText.add(key);
    }
    
    //Decrypt message: input ciphertext message and shift key, output plaintext message
    public BigInteger decrypt(BigInteger cipherText, BigInteger key)
    {
        return cipherText.subtract(key);
    }
    
}
