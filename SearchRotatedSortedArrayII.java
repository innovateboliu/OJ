
public class SearchRotatedSortedArrayII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchRotatedSortedArrayII ins = new SearchRotatedSortedArrayII();
		System.out.println(ins.search(new int[] {4,5,6,7,8,9,0,1,2,3}, 3));
	}

    public boolean search(int[] A, int target) {
        int len = A.length;
        
        int s = 0;
        int e = len - 1;
        
        while (s <= e) {
        	int m = (s+e)/2;
        	if (target == A[m]) {
        		return true;
        	} 
        	
        	if (A[s] == A[e]) {
        		s++;
        		continue;
        	}
        	if (target < A[m]) {
        		if (target < A[s] && A[m] > A[e]) {
        			s = m + 1;
        		} else {
        			e = m - 1;
        		}
        	} else {
        		if (target > A[e] && A[m] < A[s]) {
        			e = m - 1;
        		} else {
        			s = m + 1;
        		}
        	}
        }
        
        return false;
    }
}
