/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;
import java.math.*;
import java.lang.*;

/**
 *
 * @author Emily
 */
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
        Long tempL;
        String tempS;
        BigInteger result;
        String index = plainText.toString();
        int n = index.length();
        
        //Iterate through every digit in the number
        for(int i = 0; i<n; i++)
        {
            //Isolate digit from number
            BigInteger digit = BigInteger.valueOf(index.charAt(i));
            System.out.println("Isolated Character: " + index.charAt(i));
            System.out.println("Isolated Digit: " + digit);
            //block xor eIV
            digit = digit.xor(eIV);
            //use key on block
            digit = ekey[digit.intValue()];//out of bounds error
            //eIV = block
            eIV = digit;
            //Add digit to result
            strText.append(digit.toString());
        }
        
        //convert StringBuffer to BigInteger
        tempS = strText.toString();
        tempL = Long.valueOf(tempS);
        result = BigInteger.valueOf(tempL);
        
        return result;
    }
    
    //Decrypt message: input ciphertext message and IV, output plaintext message
    public BigInteger decrypt(BigInteger cipherText, BigInteger dIV)
    {
        createKey();
        StringBuffer strText = new StringBuffer();
        Long tempL;
        String tempS;
        BigInteger result;
        String index = cipherText.toString();
        int n = index.length();
        
        //Iterate through every digit in the number
        for(int i = 0; i<n; i++)
        {
            //Isolate digit from number
            BigInteger digit = BigInteger.valueOf(index.charAt(i));
            //nextdIV = block
            nextdIV = digit;
            //use key on block
            digit = dkey[digit.intValue()];
            //block xor dIV
            digit = digit.xor(dIV);
            //Add digit to result
            strText.append(digit.toString());
            //set next dIV
            dIV = nextdIV;
        }
        
        //convert StringBuffer to BigInteger
        tempS = strText.toString();
        tempL = Long.valueOf(tempS);
        result = BigInteger.valueOf(tempL);
        
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
