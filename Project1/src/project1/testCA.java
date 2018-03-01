package cipher;
import java.math.BigInteger;

public class testCA {
	
	public static void main(String[] args) {
		testing();
	}
	
 public static void testing() {
	 BigInteger key,ID;
	 ID = BigInteger.ONE;
	 key = new BigInteger("45");
	 
	 CA test = new CA();
	 boolean result = test.certify(ID,key);
	 System.out.println(result);
	 
	 
	 
 }
 
}
