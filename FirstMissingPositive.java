
public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
    	int len = A.length;
    	int i = 0;
        while (i < len) {
        	if (A[i] <= len && A[i] > 0 && A[i] != i+1 && A[A[i] - 1] != A[i]) {
        		swap(A, i, A[i] - 1);
        	} else {
        		i++;
        	}
        }
        
        for (i = 0; i < len; i++) {
        	if (A[i] != i + 1) {
        		return i+1;
        	}
        }
        return len+1;
    }
    
    private void swap(int[] A, int i, int j) {
    	int tmp = A[i];
    	A[i] = A[j];
    	A[j] = tmp;
    }
    
    public static void main(String[] args) {
    	FirstMissingPositive ins = new FirstMissingPositive();
    	int[] arr = new int[] {1,1};
    	System.out.println(ins.firstMissingPositive(arr));
    }
}
