/**
 *This class is the implementation of the Chaining Block Cipher
 * 
 * The encryption function input is the plaintext message and the Initialization
 * Vector and the output is the ciphertext message
 * 
 * The encrypt function takes each block of the input message and xor IV.
 * Then it takes the result and applies the encryption key to it. Last
 * it takes that result and uses it to update the IV before moving onto the next
 * block until all blocks are encoded.
 * 
 * The decryption function input is the ciphertext message and the Initialization
 * Vector and the output is the plaintext message
 * 
 * The decrypt function takes each block of the input message and applies the
 * key to it. Then it takes the result and xor IV. Last it takes the original
 * block result and uses it to update the IV before moving onto the next
 * block until all blocks are decoded.
 * 
 * @author <Emily Benson>
 * @date <2/27/18>
 */

package project1;
import java.math.*;
import java.lang.*;

public class CBC {
    public BigInteger eIV;
    public BigInteger dIV;
    public BigInteger nextdIV;
    public BigInteger plainText;
    public BigInteger cipherText;
    public BigInteger[] ekey = new BigInteger[10];
    public BigInteger[] dkey = new BigInteger[10];
    
    //Encrypt message: input plaintext message and IV, output ciphertext message
    public BigInteger encrypt(BigInteger plainText, BigInteger eIV)
    {
        createKey();
        StringBuffer strText = new StringBuffer();
        BigInteger result;
        String index = plainText.toString();
        int n = index.length();
        
        System.out.println("Encryption:");
        System.out.println("-------------------");
        //Iterate through every digit in the number
        for(int i = 0; i<n; i++)
        {
            //Isolate digit from number via lots of conversions
            BigInteger digit = BigInteger.valueOf(Long.valueOf(String.valueOf(index.charAt(i))));
            System.out.println("Block: " + digit);
            //block xor eIV
            digit = digit.xor(eIV);
            System.out.println("Digit xor IV = " + digit);
            //use key on block
            digit = ekey[digit.intValue()];
            System.out.println("Digit + key = " + digit);
            //eIV = block
            System.out.println("Update IV from: " + eIV + " to " + digit);
            eIV = digit;
            //Add digit to result
            strText.append(digit.toString());
            System.out.println(". . . . . . . .");
        }
        
        //convert StringBuffer to BigInteger
        result = BigInteger.valueOf(Long.valueOf(strText.toString()));
        
        return result;
    }
    
    //Decrypt message: input ciphertext message and IV, output plaintext message
    public BigInteger decrypt(BigInteger cipherText, BigInteger dIV)
    {
        createKey();
        StringBuffer strText = new StringBuffer();
        BigInteger result;
        String index = cipherText.toString();
        int n = index.length();
        
        System.out.println("Decryption:");
        System.out.println("-------------------");
        //Iterate through every digit in the number
        for(int i = 0; i<n; i++)
        {
            //Isolate digit from number via lots of conversions
            BigInteger digit = BigInteger.valueOf(Long.valueOf(String.valueOf(index.charAt(i))));
            System.out.println("Block: " + digit);
            //nextdIV = block
            nextdIV = digit;
            //use key on block
            digit = dkey[digit.intValue()];//out of bounds error
            System.out.println("Digit + key = " + digit);
            //block xor dIV
            digit = digit.xor(dIV);
            System.out.println("Digit xor IV = " + digit);
            //Add digit to result
            strText.append(digit.toString());
            //set next dIV
            System.out.println("Update IV from: " + dIV + " to " + nextdIV);
            dIV = nextdIV;
            System.out.println(". . . . . . . .");
            System.out.println(strText); //TCTC
        }
        
        //convert StringBuffer to BigInteger
        result = BigInteger.valueOf(Long.valueOf(strText.toString()));
        
        return result;
    }
    
    public void createKey()
    {
        ekey[0] = new BigInteger("6");
        ekey[1] = new BigInteger("7");
        ekey[2] = new BigInteger("5");
        ekey[3] = new BigInteger("4");
        ekey[4] = new BigInteger("3");
        ekey[5] = new BigInteger("2");
        ekey[6] = new BigInteger("0");
        ekey[7] = new BigInteger("1");
        ekey[8] = new BigInteger("9");
        ekey[9] = new BigInteger("8");
        
        dkey[6] = new BigInteger("0");
        dkey[7] = new BigInteger("1");
        dkey[5] = new BigInteger("2");
        dkey[4] = new BigInteger("3");
        dkey[3] = new BigInteger("4");
        dkey[2] = new BigInteger("5");
        dkey[0] = new BigInteger("6");
        dkey[1] = new BigInteger("7");
        dkey[9] = new BigInteger("8");
        dkey[8] = new BigInteger("9");
    }
}
