
public class CountandSay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountandSay ins = new CountandSay();
		System.out.println(ins.countAndSay(2));
	}
	
    public String countAndSay(int n) {
        return helper("1", n - 1);
    }
    
    private String helper(String str, int n) {
    	if (n == 0) return str;
    	String nextStr = count(str);
    	return helper(nextStr, n-1);
    }

    private String count(String str) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < str.length(); i++) {
    		int n = 1;
    		while (i < str.length() - 1 && str.charAt(i) == str.charAt(i+1)) {
    			n++;
    			i++;
    		}
    		sb.append(n).append(str.charAt(i));
    	}
    	
    	return sb.toString();
    }
}
