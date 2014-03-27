import java.util.ArrayList;
import java.util.Arrays;


public class PermutationsII {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
    	
    	helper(num, result, 0);
    	return result;
    }
    
    private void helper(int[] num, ArrayList<ArrayList<Integer>> result, int cur) {
    	Arrays.sort(num, cur, num.length);
    	if (cur == num.length - 1) {
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		for (int i : num) {
    			list.add(i);
    		}
    		result.add(list);
    		return;
    	}
    	
    	for (int i = cur; i < num.length; i++) {
    		if (i == cur || num[i] != num[i - 1]) {
//    			swap(num, cur, i);
    			int[] newNum = Arrays.copyOf(num, num.length);
    			swap(newNum,cur, i);
    			helper(newNum, result, cur + 1);
//    			swap(num, cur, i);
    		}
    			
    	}
    }
    
    private void swap(int[] num, int i, int j) {
    	int tmp = num[i];
    	num[i] = num[j];
    	num[j] = tmp;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationsII ins = new PermutationsII();
		ArrayList<ArrayList<Integer>> result = ins.permuteUnique(new int[]{0,1,0,0,9});
		System.out.println(result);
	}

}
