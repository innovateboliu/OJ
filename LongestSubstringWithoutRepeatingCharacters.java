import java.util.Arrays;


public class LongestSubstringWithoutRepeatingCharacters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters ins = new LongestSubstringWithoutRepeatingCharacters();
//		System.out.println(ins.lengthOfLongestSubstring("baabcdbcbb"));
		System.out.println(ins.lengthOfLongestSubstring("hchzvfrkmlnozjk"));

	}

    public int lengthOfLongestSubstring(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
        int[] pos = new int[256];
        Arrays.fill(pos, -1);
        
        int max = 1;
        int curLen = 1;
        pos[s.charAt(0)] = 0;
        for (int i = 1; i < s.length(); i++) {
        	if (pos[s.charAt(i)] != -1) {
        		int p = pos[s.charAt(i)];
        		if (p >= i - 1 - curLen + 1) {
        			curLen = i - p;
        			pos[s.charAt(i)] = i;
        		} else {
        			curLen++;
            		max = Math.max(max, curLen);
        			pos[s.charAt(i)] = i;
        		}
        	} else {
        		curLen++;
        		max = Math.max(max, curLen);
        		pos[s.charAt(i)] = i;
        	}
        }
        
        return max;
    }
}
