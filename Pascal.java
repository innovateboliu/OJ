import java.util.ArrayList;
import java.util.Arrays;


public class Pascal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pascal ins = new Pascal();
		 ArrayList<ArrayList<Integer>> r = ins.generate(0);
		 System.out.println(r);
	}
	
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	
    	ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
    	if (numRows < 1) {
    		return result;
    	}
    	
    	result.add(new ArrayList<Integer>(Arrays.asList(1)));
    	for (int i = 1; i < numRows; i++) {
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		for (int j = 0; j <= i; j++) {
    			if (j == 0) {
    				row.add(result.get(i-1).get(j));
    			} else if (j == i) {
    				row.add(result.get(i-1).get(j-1));
    			} else {
    				row.add(result.get(i-1).get(j) + result.get(i-1).get(j-1));
    			}
    		}
    		result.add(row);
    	}
    	return result;
    	
    }
}
