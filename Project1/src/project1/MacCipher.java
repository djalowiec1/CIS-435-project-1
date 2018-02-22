/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.lang.reflect.Array;
import java.math.*;
import java.util.Arrays;

/**
 *
 * @author Dariusz Jalowiec
 */
public class MacCipher {
     BigInteger hashFunc = new BigInteger("12");
    
    public BigInteger encrypt(BigInteger plainText, BigInteger secret){

        int[] numbers = getArr(plainText); 
        int s = secret.intValue();
        //System.out.println(Arrays.toString(numbers));
        int[] resultArr = new int[numbers.length + 1];
        resultArr= Arrays.copyOf(numbers, numbers.length + 1 );
        resultArr[numbers.length] = s;
        //System.out.println(Arrays.toString(resultArr));
        BigInteger hashResult = toBigInteger(resultArr);
        hashResult = hashResult.mod(hashFunc);
        int result = hashResult.intValue();
        //System.out.println(result);
        for( int index = resultArr.length-2; index >= 0 ; index-- ){
            resultArr[index+1] = resultArr [index];
        }
        resultArr[0] = result;
        //System.out.println(Arrays.toString(resultArr));
        return toBigInteger(resultArr);
        
    }
     public Boolean decrypt(BigInteger encypted, BigInteger secret){
        int[] received = getArr(encypted);
       // System.out.println(Arrays.toString(received));
        int hash = received[0];
        System.arraycopy(received, 1, received, 0, received.length - 1);
        received[received.length - 1] = secret.intValue();
        //System.out.println(Arrays.toString(received));
        BigInteger hashResult = toBigInteger(received);
        hashResult = hashResult.mod(hashFunc);
        int newHash = hashResult.intValue();
        //System.out.println(newHash);
        if(hash == newHash)
            return true;
        else
            return false;
     }
    
    private int[] getArr(BigInteger num){
        String biStr = num.toString();
        int[] ints = new int[biStr.length()];
        for(int i=0; i<biStr.length(); i++) {
            ints[i] = Integer.parseInt(String.valueOf(biStr.charAt(i)));
        }
        return ints;
}
    private BigInteger toBigInteger(int[] data) {
        String p = "";
        for(int current = 0; current < data.length; current++){
            p = p + data[current];
        }
        BigInteger numBig  = new BigInteger(p);
        return numBig;
    }
}
