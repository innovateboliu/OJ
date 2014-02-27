import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Combinations {
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		LinkedHashSet <Integer> set = new LinkedHashSet <Integer>();
		for (int i = 1; i <= n; i++ ) {
			set.add(i);
		}
		helper(result, list, set, k);
		
		return result;
	}
	
	private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> list, LinkedHashSet<Integer> set, int k) {
		if (k == 0) {
			result.add((ArrayList<Integer>)list.clone());
			return;
		}
		Iterator<Integer> iter = set.iterator();
		while (iter.hasNext()) {
			int i = iter.next();
			list.add(i);
			LinkedHashSet<Integer> newSet = (LinkedHashSet<Integer>)set.clone();
			newSet.remove(i);
			helper(result, list, newSet, k - 1);
			list.remove(list.size() - 1);
			iter.remove();
		}
	}

	public static void main(String[] args) {
		Combinations ins = new Combinations();
		ArrayList<ArrayList<Integer>> result = ins.combine(4, 2);
		System.out.println(result);
	}
}
