
public class SingleNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int singleNumber(int[] A) {
		if (A == null || A.length == 0) {
			return -1;
		}
		int result = A[0];
        for (int i = 1; i < A.length; i++) {
        	result ^= A[i];
        }
        
        return result;
    }

}
