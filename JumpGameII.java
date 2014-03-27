
public class JumpGameII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JumpGameII ins = new JumpGameII();
		System.out.println(ins.jump(new int[] {2,3,1,1,4}));
		System.out.println(ins.jump(new int[] {1,2}));
		System.out.println(ins.jump(new int[] {1,2}));

	}

    public int jump(int[] A) {
        
        int step = 0;
        int len = A.length;
        
        if (len == 0 || len == 1) {
        	return 0;
        }
        int border = -1;
        int newBorder = -1;
        for (int i = 0; i < A.length; i++) {
        	if (i > border) {
        		step++;
        		border = newBorder;
        	}

        	newBorder = Math.max(newBorder, A[i] + i);
        	
        	if (newBorder >= len - 1) {
        			return step;
        	}
        }
        
        return step;
    }
}
