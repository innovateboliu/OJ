import java.util.HashMap;
import java.util.Map;


public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
		
		if (num == null || num.length == 0) {
			return 0;
		}
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        int len = Integer.MIN_VALUE;
        for (int i = 0; i < num.length; i++) {
        	int val = num[i];
        	if (map.containsKey(val)) {
        		continue;
        	}
        	map.put(val, val);
        	int lower = val;
        	int upper = val;
        	if (map.containsKey(val+1)) {
        		upper = map.get(val + 1);
        	}
        	if (map.containsKey(val-1)) {
        		lower = map.get(val-1);
        	}
        	
        	map.put(upper, lower);
        	map.put(lower, upper);
        	
        	len = Math.max(len, upper - lower + 1);
        }
        
        return len;
    }
}
