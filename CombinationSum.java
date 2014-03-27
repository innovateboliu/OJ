import java.util.ArrayList;
import java.util.Arrays;


public class CombinationSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ArrayList<ArrayList<Integer>> combinationSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	Arrays.sort(num);
    	
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	
    	helper(num, 0, target, list, result);
    	
    	return result;
    }
    
    private void helper(int[] num, int index, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result) {
    	if (index > num.length || target < 0) {
    		return;
    	}
    	
    	for (int i = index; i < num.length; i++) {
    		if (i > index && num[i] == num[i-1]) continue;
			list.add(num[i]);

    		if (num[i] == target) {
    			result.add(new ArrayList<Integer>(list));
    		} else {
    			helper(num, i, target - num[i], list, result);
    		}
			list.remove(list.size() - 1);

    	}
    }
}
