/*
 * This class signs a message with a private key, encrypting it.
 * It also decrypts a message with a public key.
 *
 *  @author <Tom Callahan>  
 *  @date <2/26/2018>
 */
package project1;

import java.math.BigInteger;
import java.util.Random;

public class DigitalSignature {
    
    //Outputs a biginteger array [message, encrypted msg Digest]
    public BigInteger[] sign(BigInteger message, BigInteger[] privateKey)
    {       
        //Create a way to sign with RSA
        RSA rsa = new RSA();
        BigInteger[] signedMessage = new BigInteger[2];
        
        //Fill array with regular message and encrypted msg digest
        signedMessage[0] = message;
        signedMessage[1] = hash(message);
        signedMessage[1] = rsa.encrypt(signedMessage[1], privateKey);
        return signedMessage;
    }
    
    //Verify message received was authentic
    public boolean verifyDS(BigInteger message, BigInteger cipher, BigInteger[] publicKey)
    {
        RSA rsa = new RSA();
        BigInteger messageDigest;
        BigInteger decryptedDigest;
        
        //Hash message to compare with hashed decrypted message
        messageDigest = hash(message);
        decryptedDigest = rsa.decrypt(cipher, publicKey);

        //Returns true if messageDigest equals decryptedDigest
        return(messageDigest == decryptedDigest);
    }
    
    //Creates Message Digest using our hash function (our group's hash function is % 12)
    public BigInteger hash(BigInteger message)
    {
        BigInteger twelve = BigInteger.valueOf(12);
        return message.remainder(twelve);
    }
    
}
