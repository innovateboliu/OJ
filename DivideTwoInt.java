

public class DivideTwoInt {

	public static void main(String[] args) {
//		DivideTwoInt ins = new DivideTwoInt();
//		System.out.println(ins.divide(2147483647, 1));
		
		String str = "0xDUDE:1.0         ,CGAP,soaj1664ashar,DouglasBurson";
		String[] tokens = str.split("\\s+");
		String[] tos = null;
		
		if (tokens.length == 2) {
			tos = tokens[1].split(",");
		} else {
			return;
		}
		
		String[] tmp = tokens[0].split(":");
		float score = Float.parseFloat(tmp[1]);

		int numTo = tos.length - 1;

		if (numTo < 1) {
			return;
		}

		float val = score / numTo;

		for (int i = 1; i < tos.length; i++) {
			String s = tos[i];
			String f = Float.toString(val);
		}
	}
	
    public int divide(int divident, int divisor) {
    	
    	long a = (long)divident;
    	long b = (long)divisor;
    	
    	if (a == 0) {
    		return 0;
    	}
    	
    	int sign = 1;
    	
    	if (a >> 31 != 0) {
    		a = Math.abs(a);
    		sign *= -1;
    	}
    	
    	if (b >> 31 != 0) {
    		b = Math.abs(b);
    		sign *= -1;
    	}
    	
    	if (a < b) {
    		return 0;
    	}
    	
    	
    	
    	
    	long result = 0;
    	
    	long val = b;
    	long cnt = 1;
    	while (val < a) {
    		val = val << 1;
    		cnt = cnt << 1;
    	}
    	
    	if (val == a) {
    		result += cnt;
    		return (int)result * sign;
    	}
    		
    	val = val >> 1;
    		
    	cnt = cnt >> 1;
    	result += cnt;
    	
    	a = a - val;
        while (true) {
        	if (a < b) {
        		return (int)result * sign;
        	}
        	while (val > a) {
        		val = val >> 1;
        		cnt = cnt >> 1;
        	}
        	if (val == a) {
        		result += cnt;
        		return (int)result * sign;
        	}
        		
        	result += cnt;
        	
        	a = a - val;
        }
    }
}
