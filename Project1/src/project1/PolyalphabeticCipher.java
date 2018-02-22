
package project1;
import java.math.*;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
*This class is the implementation of the Polyalphabetic cipher, the encrypt function recives the  
*
* <p>Cryptography (Describe, in general, the code contained.)
*
* @author <Dariusz Jalowiec>
* @date <2/21/2018>
 */
public class PolyalphabeticCipher {
    private int n; 
    private int m1 = 1;
    private int m2 = 2;
    private int m3 = 3;
    private int m4 = 4;

    
    public BigInteger encrypt (BigInteger plainText, BigInteger key){
        System.out.println(plainText);
        int[] keys = getArr(key);
        m1 = keys[0];
        m2 = keys[1];
        m3 = keys[2];
        m4 = keys[3];
        System.out.println(m2);
        int[] numbers1 = getArr(plainText); 
        int[] numbers2 = new int[4];
        int[] numbers = new int[numbers1.length + numbers2.length];
        System.arraycopy(numbers1, 0, numbers, 0, numbers1.length);
        System.arraycopy(numbers2, 0, numbers, numbers1.length, numbers2.length);
        List<Integer> intList = getList(numbers);
        int[] resultArr = new int[numbers.length];
        System.out.println(Arrays.toString(numbers)); 
        for(int postion = 0; postion < numbers.length - 4  ; postion+=4) {
                  resultArr[postion] = numbers[postion] + m1;
                  resultArr[postion + 1] = numbers[postion + 1] + m2;
                  resultArr[postion + 2] = numbers[postion + 2] + m3;
                  resultArr[postion + 3] = numbers[postion + 3] + m4;
                  
                    
        }
        int[] finalArr = new int[numbers1.length];
        System.arraycopy(resultArr, 0, finalArr, 0, numbers1.length); 

        return toBigInteger(finalArr);
    }
    
    public void decrypt (BigInteger encrypted,  BigInteger key){
        
    }
    
    private int[] getArr(BigInteger num){
        String biStr = num.toString();
        int[] ints = new int[biStr.length()];
        for(int i=0; i<biStr.length(); i++) {
            ints[i] = Integer.parseInt(String.valueOf(biStr.charAt(i)));
        }
        return ints;
}
    private List<Integer> getList(int[] x){
           List<Integer> intList = new ArrayList<Integer>();
            for (int i : x)
            {
            intList.add(i);
            }
        return intList;
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
