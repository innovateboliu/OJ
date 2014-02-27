import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class SubsetsII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubsetsII ins = new SubsetsII();
		System.out.println(ins.subsetsWithDup(new int[] { 5, 5, 5, 5, 5 }));
//		System.out.println(ins.subsetsWithDup(new int[] { 1,2,2 }));
	}

	// public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	// ArrayList<ArrayList<Integer>> result = new
	// ArrayList<ArrayList<Integer>>();
	// if (num.length == 0) {
	// return result;
	// }
	// Arrays.sort(num);
	// result.add(new ArrayList<Integer>());
	// result.add(new ArrayList<Integer>(Arrays.asList(num[0])));
	//
	// ArrayList<ArrayList<Integer>> newColl = new
	// ArrayList<ArrayList<Integer>>();
	// newColl.add(new ArrayList<Integer>(Arrays.asList(num[0])));
	// for (int i = 1; i < num.length; i++) {
	// ListIterator<ArrayList<Integer>> iter = result.listIterator();
	// if (num[i] == num[i-1]) {
	// ArrayList<ArrayList<Integer>> tmp = new ArrayList<ArrayList<Integer>>();
	// for ( ArrayList<Integer> set : newColl) {
	// ArrayList<Integer> newSet = new ArrayList<Integer>(set);
	// newSet.add(num[i]);
	// tmp.add(newSet);
	// iter.add(newSet);
	// }
	// newColl = new ArrayList<ArrayList<Integer>>(tmp);
	// continue;
	// } else {
	//
	// newColl.clear();
	//
	// while ( iter.hasNext()) {
	// ArrayList<Integer> newSet = new ArrayList<Integer>(iter.next());
	// newSet.add(num[i]);
	// newColl.add(newSet);
	// iter.add(newSet);
	// }
	// }
	// }
	//
	// return result;
	// }

	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0) {
			return result;
		}
		Arrays.sort(num);
		result.add(new ArrayList<Integer>());
		result.add(new ArrayList<Integer>(Arrays.asList(num[0])));

		ArrayList<ArrayList<Integer>> newColl = new ArrayList<ArrayList<Integer>>();
		newColl.add(new ArrayList<Integer>(Arrays.asList(num[0])));
		for (int i = 1; i < num.length; i++) {
			ListIterator<ArrayList<Integer>> iter = result.listIterator();
			if (num[i] == num[i - 1]) {
				for (ArrayList<Integer> set : newColl) {
					set.add(num[i]);
					result.add((ArrayList<Integer>)set.clone());
				}
				continue;
			} else {
				newColl.clear();
				while (iter.hasNext()) {
					ArrayList<Integer> newSet = new ArrayList<Integer>(iter.next());
					newSet.add(num[i]);
					newColl.add((ArrayList<Integer>)(newSet.clone()));
					iter.add(newSet);
				}
			}
		}

		return result;
	}

}
