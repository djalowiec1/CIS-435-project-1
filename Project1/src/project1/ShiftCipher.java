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
    public String plainText;
    public String cipherText;
    public int key;
    
    //Encrypt message
    public StringBuffer encrypt(String plainText, int key)
    {
        StringBuffer encrypted = new StringBuffer();
        
        for (int i = 0; i < plainText.length(); i++)
        {
            char c = (char)(((int)plainText.charAt(i) + key - 30) % 94 + 30);
            encrypted.append(c);
        }
        
        return encrypted;
    }
    
    //Decrypt message
    public StringBuffer decrypt(String cipherText, int key)
    {
        StringBuffer decrypted = new StringBuffer();
        
        for (int i = 0; i < cipherText.length(); i++)
        {
            char c = (char)(((int)cipherText.charAt(i) + (94 - key) - 30) % 94 + 30);
            decrypted.append(c);
        }
        
        return decrypted;
    }
    
}
