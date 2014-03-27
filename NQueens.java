import java.util.ArrayList;
import java.util.Arrays;


public class NQueens {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NQueens ins = new NQueens();
		ArrayList<String[]> result = ins.solveNQueens(4);
		for (String[] strs : result) {
			System.out.println(Arrays.toString(strs));
		}
	}
	
    public ArrayList<String[]> solveNQueens(int n) {
    	ArrayList<String[]> result = new ArrayList<String[]>();
    	int[] record = new int[n];
    	helper(0, record, n, result);
    	return result;
    }
    
    private void helper(int curRow, int[] record, int n, ArrayList<String[]> result) {
    	if (curRow == n) {
    		String[] strArr = new String[n];
    		for (int i = 0; i < n; i++) {
    			strArr[i] = generateString(record[i], n);
    		}
    		result.add(strArr);
    		return;
    	}
    	
    	for (int i = 0; i < n; i++) {
    		boolean valid = true;
    		for (int j = 0; j < curRow; j++) {
    			if (i == record[j] || Math.abs(i - record[j]) == Math.abs(curRow - j)) {
    				valid = false;
    			}
    		}
    		if (valid) {
    			record[curRow] = i;
    			helper(curRow+1, record, n, result);
    		} 
    	}
    }
    
    private String generateString(int col, int n) {
    	StringBuilder sb = new StringBuilder();
    	for (int i = 0; i < n; i++) {
    		sb.append('.');
    	}
    	sb.setCharAt(col, 'Q');
    	return sb.toString();
    }
    
}
