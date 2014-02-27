
public class RemoveDuplicatesSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesSortedArrayII ins = new RemoveDuplicatesSortedArrayII();
		System.out.println(ins.removeDuplicates(new int[] {1,1,1,2,3}));
	}
	
    public int removeDuplicates(int[] A) {
    	if (A.length == 0 || A.length == 1) {
    		return A.length;
    	}  
        int cur = 0;
        int next = cur + 1;
        int det = next;
        
        boolean canInc = true;
        while (det != A.length) {
        	if (A[det] == A[cur] ) {
        		if (!canInc) {
        		det++;
        		} else {
        			A[next] = A[det];
                	cur = next;
                	next++;
                	det++;
                	canInc = false;
        		}
        		continue;
        	}
        	canInc = true;
        	
        	A[next] = A[det];
        	cur = next;
        	next++;
        	det++;
        }
        
        return next;
    }

}
