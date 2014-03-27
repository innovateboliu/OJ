import java.util.Arrays;


public class SearchforaRange {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SearchforaRange ins = new SearchforaRange();
		int[] arr = new int[] {5, 7, 7, 8, 8, 10};
		
		System.out.println(Arrays.toString(ins.searchRange(arr, 8)));
	}
	// 0 1 2 3 4 5 
    public int[] searchRange(int[] A, int target) {
    	int len = A.length;
    	int[] result = new int[2];
        int a = 0;
        int b = len -1;
        while (a < b) {
        	int m = (a+b) / 2;
        	
        	if (A[m] < target) a = m + 1;
        	else b = m;
        }
        
        if (A[a] != target) {
        	return new int[] {-1, -1};
        }
        result[0] = a;
        
        b = len;
        while (a < b) {
        	int m = (a+b) / 2;
        	if (A[m] <= target) a = m + 1;
        	else b = m;
        }
        
        
        result[1] = b - 1;
        return result;
    }
}
