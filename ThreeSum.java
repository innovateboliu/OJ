import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class ThreeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreeSum ins = new ThreeSum();
		System.out.println(ins.threeSum(new int[] {-1,0,1,2,-1,-4}));
	}
	
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        int len = num.length;
        
        if (num.length < 3) {
        	return result;
        }
        
        Arrays.sort(num);

        for (int i = 0; i < len; i++) {
        	if (i > 0 && num[i] == num[i-1]) {
        		continue;
        	}
        	int diff = 0 - num[i];
        	for (int j = i + 1, k = len - 1; j < k;) {
        		int subSum = num[j] + num[k];
        		if (subSum == diff) {
        			Integer[] arr = new Integer[] {num[i], num[j], num[k]};
        			result.add(new ArrayList<Integer>(Arrays.asList(arr)));
        			j++;
        			k--;
        			while (j < k && num[j] == num[j-1]) j++;
        			while (j < k && num[k] == num[k+1]) k--;
        		} else if (subSum < diff) {
        			j++;
        		} else {
        			k--;
        		}
        	}
        }
        
        return result;
    }

}
