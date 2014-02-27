
public class RemoveDuplicatesSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RemoveDuplicatesSortedArray ins = new RemoveDuplicatesSortedArray();
		System.out.println(ins.removeDuplicates(new int[] {1,1,1,2,3}));
	}
	
    public int removeDuplicates(int[] A) {
    	if (A.length == 0 || A.length == 1) {
    		return A.length;
    	}  
        int cur = 0;
        int next = cur + 1;
        int det = next;
        
        while (det != A.length) {
        	if (A[det] == A[cur]) {
        		det++;
        		continue;
        	}
        	
        	A[next] = A[det];
        	cur = next;
        	next++;
        	det++;
        }
        
        return next;
    }

}
