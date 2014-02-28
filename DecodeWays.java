
public class DecodeWays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays ins = new DecodeWays();
		System.out.println(ins.numDecodings("121"));
	}
	
	public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
      	  return 0;
        }
        
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
        	if (i == 0) {
        		arr[i] = isValid(s.substring(i,i+1)) ? 1 : 0;
        		continue;
        	} 
        	
        	if (isValid(s.substring(i,i+1))) {
        		arr[i] += arr[i-1];
        	} 
        	if (isValid(s.substring(i-1,i+1))) {
        		if (i == 1) {
        			arr[i] += 1;
        		} else {
        			arr[i] += arr[i-2];
        		}
        	}
        }
        
        return arr[arr.length - 1];
	}
	
    
    private boolean isValid(String s) {
    	if (s == null || s.charAt(0) == '0') {
    		return false;
    	}
    	int num = Integer.parseInt(s);
    	if (num >=1 && num <= 26) {
    		return true;
    	}
    	
    	return false;
    }
}
