
public class DistinctSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numDistinct(String S, String T) {
		if (S == null || T == null || "".equals(S) || "".equals(T) || T.length() > S.length()) {
			return 0;
		}
        int[] dis = new int[T.length() + 1];
        dis[0] = 1;
        for (int i = 0; i < S.length(); i++) {
        	for (int j = T.length(); j >=1 ;j--) {
        		dis[j] += (S.charAt(i) == T.charAt(j-1) ? 1 : 0) * dis[j-1];
        	}
        }
        
        return dis[dis.length-1];
    }
}
