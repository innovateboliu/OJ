import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class WordBreak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordBreak ins = new WordBreak();
//		boolean result = ins.wordBreak("leetcode", new HashSet<String>(Arrays.asList("leet", "cod", "lee", "tcode")));
		boolean result = ins.wordBreak(null, new HashSet<String>(Arrays.asList("leet", "cod", "lee", "tcode")));
		System.out.println(result);
	}

	public boolean wordBreak(String s, Set<String> dict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		int len = s.length();
        boolean[][] arr = new boolean[len][len];
        
        for (int i = 0; i < len; i++) {
        	for (int j = 0; j < len - i; j++) {
        		boolean indicator = false;
        		for (int k = j; k + 1 <= j+i; k++) {
        			indicator |= (arr[j][k]&&arr[k+1][j+i]);
        			if (indicator == true) {
        				arr[j][j+i] = true;
        				break;
        			}
        		}
        		arr[j][j+i] |= dict.contains(s.substring(j, j+i+1));
        	}
        }
        return arr[0][len - 1];
    }
}
