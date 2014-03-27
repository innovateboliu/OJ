
public class JumpGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	   public boolean canJump(int[] A) {
	        
	       
	        int border = 0;
	        for (int i = 0; i < A.length && i <= border; i++) {
	        	border = Math.max(border, A[i] + i);
	        }
	        
	        return border >= A.length - 1;
	    }
}
