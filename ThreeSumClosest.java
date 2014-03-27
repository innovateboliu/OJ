import java.util.Arrays;


public class ThreeSumClosest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreeSumClosest ins = new ThreeSumClosest();
		System.out.println(ins.threeSumClosest(new int[] {0,2,1,-3}, 1));
	}// -3 0 1 2
	
    public int threeSumClosest(int[] num, int target) {
        int minDiff = Integer.MAX_VALUE;
        int len = num.length;
        Arrays.sort(num);
    	int result = 0;

        
        for (int i = 0; i < len - 2; i++) {
        	
        	int a = i + 1;
        	int b = len - 1;
        	int sum = 0;
        	
        	while (a < b) {
        		sum = num[a] + num[b] + num[i];
        		if (sum == target) {
        			return target;
        		} else if (sum < target) {
        			a++;
        		} else {
        			b--;
        		}
        		if (Math.abs(target - sum) < minDiff) {
            		result = sum;
            		minDiff = Math.abs(target - sum);
            	}
        	}
        	
        	
        }
        
        return result;
    }

}
