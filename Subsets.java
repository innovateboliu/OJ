import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;


public class Subsets {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Arrays.deepHashCode(new Integer[] {1,3}));
		System.out.println(Arrays.deepHashCode(new Integer[] {2,2}));
		System.out.println(Arrays.deepEquals(new Integer[] {1,3}, new Integer[] {2,2}));
//		SubsetsII ins = new SubsetsII();
//		System.out.println(ins.subsetsWithDup(new int[1] ));
	}
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (S.length == 0) {
    		return result;
    	}
    	Arrays.sort(S);
    	result.add(new ArrayList<Integer>());
    	
    	for (int i = 0; i < S.length; i++) {
    		ListIterator<ArrayList<Integer>> iter = result.listIterator();
    		while ( iter.hasNext()) {
    			ArrayList<Integer> newSet = new ArrayList<Integer>(iter.next());
    			newSet.add(S[i]);
    			iter.add(newSet);
    		}
    	}
    	
    	return result;
    }
    
}
