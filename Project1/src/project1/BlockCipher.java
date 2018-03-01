/**
* <p>This cipher takes a BigInteger as input, then uses a set mapping to 
* encrypt and decrypt the message. It contains createKey(), encrypt(), and 
* decrypt() methods. CreateKey() populates the mapping arrays. Encrypt() and 
* decrypt() converts the BigInteger input into a String, breaks it into 
* individual digits, encrypts/decrypts the digits according to the mapping, 
* then pieces the digits back together into one message, converts it back into 
* Big Integer, then returns the result.
*
* @author <Clay Klinedinst>
* @date <2/28/2018>
*/

package project1;
import java.math.*;

public class BlockCipher 
{
    BigInteger[] ekey = new BigInteger[10];
    BigInteger[] dkey = new BigInteger[10];
    
    public void createKey()
    {
        //populates the encryption and decryption key with the map values
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
    
    public BigInteger encrypt(BigInteger plaintext)
    {
        BigInteger ciphertext;
        String digit, encryptedDigit, output = "";
        //populate the mapping arrays so the key can be used in the function
        createKey();
        
        //convert the BigInteger plaintext to String
        String text = plaintext.toString();
        
        //loop through each char in the String to convert one digit at a time
        for(int i = 0; i < text.length(); i++)
        {
            //get the next "digit" in the plaintext
            digit = String.valueOf(text.charAt(i));
            /* convert digit to integer, use that to find the mapping for
            encryption using ekey, then set the String representation of that
            number as the encrypted digit*/
            encryptedDigit = ekey[Integer.parseInt(digit)].toString();
            //add the encryptedDigit to the output of the cipher
            output += encryptedDigit;
        }
        
        //convert the cipher output into BigInteger for returning
        ciphertext = new BigInteger(output);
        
        return ciphertext;
    }
    
     public BigInteger decrypt(BigInteger ciphertext)
    {
        BigInteger plaintext;
        String digit, decryptedDigit, output = "";
        //populate the mapping arrays so the key can be used in the function
        createKey();
        
        //convert the BigInteger ciphertext to String
        String text = ciphertext.toString();
        
        //loop through each char in the String to convert one digit at a time
        for(int i = 0; i < text.length(); i++)
        {
            //get the next "digit" in the ciphertext
            digit = String.valueOf(text.charAt(i));
            /* convert digit to integer, use that to find the mapping for
            decryption using dkey, then set the String representation of that
            number as the decrypted digit*/
            decryptedDigit = dkey[Integer.parseInt(digit)].toString();
            //add the decryptedDigit to the output
            output += decryptedDigit;
        }
       
        //convert the output into BigInteger for returning
        plaintext = new BigInteger(output);
        
        return plaintext;
    }
  
}