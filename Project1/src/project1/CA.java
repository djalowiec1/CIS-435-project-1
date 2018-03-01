/*
 *This class verifies a users ID with their Key
 *
 *@author <Cameron Conklin>
 *@date <3/1/2018>
 */


package project1;
import java.math.*;
public class CA {

	BigInteger[] people = new BigInteger[4];
	
	
	private void fill() {
		BigInteger x,z,c,v;
		x = new BigInteger("12");
		z= new BigInteger("45");
		c= new BigInteger("22");
		v= new BigInteger("78");
		
		people[0] = x;
		people[1] = z;
		people[2] = c;
		people[3] = v;
		
		}
	
	
	public boolean certify(BigInteger ID, BigInteger Key) {
		 
		fill();
		boolean result = false;
		
		
		

		int p = ID.intValue();
		for (int x=0;x<people.length;x++) {
			if (people[p].equals(Key)) {
				result = true;
			}
			else result = false;
		
	
	}
		return result;
	
	
		
		
	}		
}
