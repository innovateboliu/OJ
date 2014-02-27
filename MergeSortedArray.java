import java.util.Arrays;


public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[10];
		A[0] = 1;
		int[] B = new int[] {2};
		MergeSortedArray ins = new MergeSortedArray();
		ins.merge(A, 1, B, 1);
		System.out.println(Arrays.toString(A));
	}
	
	public void merge(int A[], int m, int B[], int n) {
        if (m == 0) {
	        copy(B, 0, n-1, A, 0);
	        return;
        }
        
        int newa = A.length - m;
        move(A, 0, m - 1, A, newa);
        int cur = 0;
        int i = newa, j = 0;
        while ( i < A.length && j < n) {
        	if (B[j] < A[i]) {
        		A[cur] = B[j];
        		j++;
        	} else {
        		A[cur] = A[i];
        		i++;
        	}
        	cur++;
        }
        
        if (i == A.length) {
        	copy(B, j, n-1, A, cur);
        } else {
        	copy(A, i, A.length - 1, A, cur);
        }
    }
	
	private void copy(int[] src, int sa, int sb, int[] tgt, int ta) {
		if (sb < sa) {
			return;
		}
		for (int i = sb-sa; i >= 0; i--) {
			tgt[ta + i] = src[sa + i];
		}
	}
	
	private void move(int[] src, int sa, int sb, int[] tgt, int ta) {
		if (sb < sa) {
			return;
		}
		for (int i = sb-sa; i >= 0; i--) {
			tgt[ta + i] = src[sa + i];
			src[sa + i] = 0;
		}
	}
}
