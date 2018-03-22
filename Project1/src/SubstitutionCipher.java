/*
*This class inputs a biginteger message and key then uses the key to ecrypt and decrypt the message 
*It contains a encrypt and decrypt method as well as a key randomizer.
*
*@author<Cameoron Conklin>
*@date<2/28/2018>
*
*/

package project1;

import java.math.*;
import java.util.Random;



public class SubstitutionCipher {

	private BigInteger GetKey() {
		int[] base = new int[] {0,1,2,3,4,5,6,7,8,9};
		Random rand = new Random();
		
		for (int x=0; x<base.length; x++) {
		    int pos = rand.nextInt(base.length);
		    int temp = base[x];
		    base[x] = base[pos];
		    base[pos] = temp;
		}
		
		
		
		BigInteger key = toBigInteger(base);
		
		return key;
	}
			
	  public BigInteger encrypt (BigInteger msg, BigInteger key){
		  
		  int[] digits = getArr(msg);
		  int[] cipher = getArr(key);
		  
		    for (int x = 0; x<digits.length;x++) {
		    	for (int i = 0; i<cipher.length; i++) {
		    		if (digits[x] == i){
		    			digits[x] = cipher[i];
		    			break;
		    		}
		    		else;
		    		
		    	}
		    	
		    }
		   		    		    
		   BigInteger emsg = toBigInteger(digits);
		   
		  return emsg;
	  }
	  
	  public BigInteger decrypt (BigInteger emsg, BigInteger key) {
		  
		  int[] digits = getArr(emsg);
		  int[] cipher = getArr(key);
		  
		    for (int x = 0; x<digits.length;x++) {
		    	for (int i = 0;i<cipher.length;i++) {
		    		if (digits[x]==cipher[i]) {
		    			digits[x] = i;
		    			break;
		    		}
		    		else;
		    	}		    
		    }
		  
		  
		  BigInteger msg = toBigInteger(digits);
		  return msg;
	  }
		
		
	
	
	  private int[] getArr(BigInteger msg){
	        String biStr = msg.toString();
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
