import java.util.Arrays;


public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NextPermutation ins = new NextPermutation();
		int[] num = new int[] {1,3,2};
		ins.nextPermutation(num);
		System.out.println(Arrays.toString(num));
	}

    public void nextPermutation(int[] num) {
        int len = num.length;
        int i = len - 1;
        for (; i >= 1; i--) {
        	if (num[i] > num[i-1]) {
        		break;
        	}
        }
        
        if (i == 0) {
        	Arrays.sort(num);
        } else {
        	Arrays.sort(num, i, len);
        	int j = i;
            for (; j < len; j++){
                if (num[j] > num[i-1]) {
                    break;
                }
            }
        	swap(num, j, i - 1);
        }
    }
    
    private void swap(int[] num, int i, int j) {
    	int tmp = num[i];
    	num[i] = num[j];
    	num[j] = tmp;
    }
}
