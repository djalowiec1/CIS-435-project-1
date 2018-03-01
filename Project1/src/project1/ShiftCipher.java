/**
 * This class is the implementation of the Shift cipher
 * 
 * The encryption function input is the plaintext message and the shift key and
 * the output is the ciphertext message
 * 
 * The encrypt function takes the value of the input message and shifts it by
 * the value of the key
 * 
 * The decryption function input is the ciphertext message and the shift key and
 * the output is the plaintext message
 * 
 * The decrypt function takes the value of the input message and shifts it by
 * the value of the key in the opposite direction of the encrypt function
 * 
 * @author Emily
 * @date 2/20/18
 */

package project1;
import java.math.*;

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
