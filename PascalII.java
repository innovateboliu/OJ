import java.util.ArrayList;
import java.util.Arrays;


public class PascalII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ArrayList<Integer> getRow(int numRows) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		int[] row = new int[numRows + 1];
    	if (numRows == 0) {
    		result.add(1);
    		return result;
    	}
    	
    	
    	for (int i = 1; i <= numRows; i++) {
    		row[0] = 1;
    		for (int j = i; j >= 1; j--) {
    			row[j] += row[j-1];
    		}
    		
    		if (i == numRows) {
    			for (int k = 0; k <= numRows; k++) {
    				result.add(row[k]);
    			}
				break;
    		}
    	}
    	return result;
    }

}
