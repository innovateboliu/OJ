import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;


public class PermutationSequence {

	public String getPermutation(int n, int k) {
		StringBuilder result = new StringBuilder();
		int[] cnt = new int[1];
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		for (int i = 1; i <=n; i++) {
			set.add(i);
		}
		helper(result, set, k, cnt, 0);
	 	return result.toString();
    }
	
	private void helper(StringBuilder result, LinkedHashSet<Integer> set, int k, int[] cnt, int step) {
//		if (step == 0) {
//			if (cnt[0] == k) {
//				return;
//			}
//			cnt[0]++;
//		}
//		for (int i = 1; i <= n; i++) {
//			result.append(i);
//			helper(result, n,)
//		}
	}
	
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		 ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		myHelper(result, num, 0);
		return result;
    }
	
	private void myHelper( ArrayList<ArrayList<Integer>> result, int[] num, int cur) {
		if (cur == num.length - 1) {
			ArrayList<Integer> intList = new ArrayList<Integer>();
		    for (int index = 0; index < num.length; index++)
		    {
		        intList.add(num[index]);
		    }
			result.add(intList);
			return;
		}
		
		for (int i = cur; i < num.length; i++) {
			swap(num, i, cur);
			myHelper(result, num, cur + 1);
			swap(num, i, cur);
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
		PermutationSequence ins = new PermutationSequence();
		System.out.println(ins.permute(new int[] {1, 2, 3}));
		
	}

}
