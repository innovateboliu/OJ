import java.util.Arrays;


public class SortColors {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SortColors ins = new SortColors();
		int[] A = new int[] {0,2,1};
		ins.sortColors(A);
		System.out.println(Arrays.toString(A));

	}

    public void sortColors(int[] A) {
        int i = 0;
        int j = A.length - 1;
        
        for (int k = i; k <= j;) {
        	if (A[k] == 0) {
        		int tmp = A[k];
        		A[k] = A[i];
        		A[i] = tmp;
        		i++;
        		k++;
        	} else if (A[k] == 1){
        		k++;
        	} else {
        		int tmp = A[k];
        		A[k] = A[j];
        		A[j] = tmp;
        		j--;
        	}
        }
    }
}
