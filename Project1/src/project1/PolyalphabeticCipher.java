
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
* The polyalpapetic enrypt and decrypt deivide the bigint received into an int array, then the int array is individuall
 shifteed by looking at the key, each digit in the key is one diffrent shift, so m1 would be the first digit
 in key
* @author <Dariusz Jalowiec>
* @date <2/21/2018>
 */
public class PolyalphabeticCipher {
    //these peivate variables are the standard shift 
    private int n; 
    private int m1 = 1;
    private int m2 = 2;
    private int m3 = 3;
    private int m4 = 4;

    
    public BigInteger encrypt (BigInteger plainText, BigInteger key){
        //used privaate method to quickly converty the kay into an array and assaign each into variable
        int[] keys = getArr(key);
        m1 = keys[0];
        m2 = keys[1];
        m3 = keys[2];
        m4 = keys[3];
        //converted plaintext into array as well
        int[] numbers1 = getArr(plainText); 
        int[] numbers2 = new int[4];
        int[] numbers = new int[numbers1.length + numbers2.length];
        //created an array that can fit oldarray and 4 more lenght to prevent indexoutofbound error
        System.arraycopy(numbers1, 0, numbers, 0, numbers1.length);
        System.arraycopy(numbers2, 0, numbers, numbers1.length, numbers2.length);
        int[] resultArr = new int[numbers.length];
        //for loop to change each int 
        for(int postion = 0; postion < numbers.length - 4  ; postion+=4) {
                  resultArr[postion] = numbers[postion] + m1;
                  resultArr[postion + 1] = numbers[postion + 1] + m2;
                  resultArr[postion + 2] = numbers[postion + 2] + m3;
                  resultArr[postion + 3] = numbers[postion + 3] + m4;
                  
                    
        }
        int[] finalArr = new int[numbers1.length];
        //copy array used for data into final array with same lenght as orginal
        System.arraycopy(resultArr, 0, finalArr, 0, numbers1.length); 
        //call the method to convert back to bigint and return 
        return toBigInteger(finalArr);
    }
    
    public BigInteger decrypt (BigInteger encrypted,  BigInteger key){
         //used privaate method to quickly converty the kay into an array and assaign each into variable
        int[] keys = getArr(key);
        m1 = keys[0];
        m2 = keys[1];
        m3 = keys[2];
        m4 = keys[3];
         //created an array that can fit oldarray and 4 more lenght to prevent indexoutofbound error
        int[] numbers1 = getArr(encrypted); 
        int[] numbers2 = new int[4];
        int[] numbers = new int[numbers1.length + numbers2.length];
        System.arraycopy(numbers1, 0, numbers, 0, numbers1.length);
        System.arraycopy(numbers2, 0, numbers, numbers1.length, numbers2.length);
        int[] resultArr = new int[numbers.length];
        //did the samething as before, but this time we shift back instead of foward
        for(int postion = 0; postion < numbers.length - 4  ; postion+=4) {
                  resultArr[postion] = numbers[postion] - m1;
                  resultArr[postion + 1] = numbers[postion + 1] - m2;
                  resultArr[postion + 2] = numbers[postion + 2] - m3;
                  resultArr[postion + 3] = numbers[postion + 3] - m4;
                  
                    
        }
        int[] finalArr = new int[numbers1.length];
        System.arraycopy(resultArr, 0, finalArr, 0, numbers1.length); 

        return toBigInteger(finalArr);
    }
    //private method to convert bigint into int array
    private int[] getArr(BigInteger num){
        String biStr = num.toString();
        int[] ints = new int[biStr.length()];
        for(int i=0; i<biStr.length(); i++) {
            ints[i] = Integer.parseInt(String.valueOf(biStr.charAt(i)));
        }
        return ints;
}
//private method to convert int array into bigint 
    private BigInteger toBigInteger(int[] data) {
        String p = "";
        for(int current = 0; current < data.length; current++){
            p = p + data[current];
        }
        BigInteger numBig  = new BigInteger(p);
        return numBig;
    }
    
    
    
}
