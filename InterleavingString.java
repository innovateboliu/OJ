
public class InterleavingString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterleavingString ins = new InterleavingString();
//		boolean r = ins.isInterleave("aa", "ab", "aaba");
//		System.out.println(r);
		
		boolean r = ins.isInterleave("ef", "gh", "ehgf");
		System.out.println(r);
	}
	
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1 == null || s2 == null || s3 == null) {
			return false;
		}
		
		int len1 = s1.length();
		int len2 = s2.length();
		
		if (len1 + len2 != s3.length()) {
			return false;
		}
		if ("".equals(s1)) {
			return s2.equals(s3);
		}
		if ("".equals(s2)) {
			return s1.equals(s3);
		}
        boolean[] arr = new boolean[len2 + 1];
        
        arr[arr.length - 1] = s1.charAt(len1-1) == s3.charAt(s3.length() - 1) ;
        arr[arr.length - 2] = s2.charAt(len2-1) == s3.charAt(s3.length() - 1);
        
        for (int i = len1 - 1; i >= 0; i--) {
            arr[arr.length - 1] &= (s3.charAt(len2 + i) == s1.charAt(i));
        	for (int j = len2 -1; j >= 0; j--) {
        	    arr[arr.length - 2] &= (s3.charAt(len1 + j) == s2.charAt(j));
        		if (s3.charAt(i+j) == s1.charAt(i) || s3.charAt(i+j) == s2.charAt(j)) {
        			arr[j] |= arr[j+1];
        		} else {
        			arr[j] = false;
        		}
        		

        	}
        }
        
        return arr[0];
    }
}
