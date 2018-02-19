/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

/**
 *
 * @author Emily
 */
public class ShiftCipher {
    
    public StringBuilder plainText;
    public StringBuilder cipherText;
    public int key;
    
    //Encrypt message
    public StringBuilder encrypt(StringBuilder plainText, int key)
    {
        cipherText = plainText;
        
        for (int i = 0; i < plainText.length(); i++)
        {
            //Encrypt lowercase text
            if (Character.isLowerCase(plainText.charAt(i)))
            {
                char c = (char)(((int)plainText.charAt(i) + key - 50) % 26 + 50);
                
                cipherText.append(c);
            }
            //Encrypt uppercase text
            else
            {
                char c = (char)(((int)plainText.charAt(i) + key - 50) % 26 + 50);
                
                cipherText.append(c);
            }
        }
        
        return cipherText;
    }
    
    //Decrypt message
    public StringBuilder decrypt(StringBuilder cipherText, int key)
    {
        plainText = cipherText;
        
        for (int i = 0; i < cipherText.length(); i++)
        {
            //Encrypt lowercase text
            if (Character.isLowerCase(cipherText.charAt(i)))
            {
                char c = (char)(((int)cipherText.charAt(i) - key - 50) % 26 + 50);
                
                plainText.append(c);
            }
            //Encrypt uppercase text
            else
            {
                char c = (char)(((int)cipherText.charAt(i) - key - 50) % 26 + 50);
                
                plainText.append(c);
            }
        }
        
        return plainText;
    }
    
}
