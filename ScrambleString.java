
public class ScrambleString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScrambleString ins = new ScrambleString();
		System.out.println(ins.isScramble("b", "b"));
	}
	
    public boolean isScramble(String s1, String s2) {
        
        int len = s1.length();
        boolean[][][] arr = new boolean[len][len][len];
        
        for (int i = len - 1; i >= 0; i--) {
        	for (int j = len - 1; j >= 0; j--) {
        		for (int k = 0; k <= len - 1 - Math.max(i, j); k++) {
        			if (k == 0) {
        				arr[i][j][k] = (s1.charAt(i) == s2.charAt(j));
        				continue;
        			}
        			for (int l = 0; l < k; l++) {
	        			arr[i][j][k] |= arr[i][j][l] && arr[i + l + 1][j + l + 1][k-l-1];
	        			arr[i][j][k] |= arr[i][j+k-l][l] && arr[i+l+1][j][k-l-1];
        			}
        		}
        	}
        }
        return arr[0][0][len-1];
    }
    
    
}
