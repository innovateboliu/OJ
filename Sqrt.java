import java.util.Arrays;


public class Sqrt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE / 2 * Integer.MAX_VALUE / 2 );
		System.out.println( Long.MAX_VALUE);
		System.out.println((int)Math.sqrt(2));
	}
	
    public int sqrt(int x) {
        long s = 0;
        long e = x / 2 + 1;
        
        
        while (s <= e) {
        	long m = (s+e)/2;
        	
        	long p = m * m;
        	
        	if (p == x) {
        		return (int)m;
        	} else if (p > x) {
        		e = m - 1;
        	} else {
        		s = m + 1;
        	}
        }
        
       return (int)e;
    }

}
