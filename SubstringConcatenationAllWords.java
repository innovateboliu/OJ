import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SubstringConcatenationAllWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SubstringConcatenationAllWords ins = new SubstringConcatenationAllWords();
		System.out.println(ins.findSubstring("barfoothefoobarman", new String[] {"foo", "bar"}));
		System.out.println(ins.findSubstring("foobarbarbarfookha", new String[] {"foo", "bar", "bar", "kha"}));
	}

    public ArrayList<Integer> findSubstring(String S, String[] L) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	if (L.length == 0) {
    		return result;
    	}
    	
        Map<String, Integer> expectedMap = new HashMap<String, Integer>();
        for (String str : L) {
        	if (expectedMap.containsKey(str)) {
        		expectedMap.put(str, expectedMap.get(str) + 1);
        	} else {
        		expectedMap.put(str, 1);
        	}
        }
        
        int wordLen = L[0].length();
        int wordNum = L.length;
        int len = S.length();
        
        for (int i = 0; i < wordLen; i++) {
        	Map<String, Integer> curMap = new HashMap<String, Integer>(expectedMap);
        	int count = 0;
        	for (int j = 0; i + wordLen * (j + 1) <= len;) {
        		String str = S.substring(i + j * wordLen, i + (j+1)*wordLen);
        		if (!expectedMap.containsKey(str)) {
        			curMap = new HashMap<String, Integer>(expectedMap);
        			count = 0;
        			j++;
        			continue;
        		}
        		
        		if (curMap.containsKey(str)) {
        			if (curMap.get(str) == 1) {
        				curMap.remove(str);
        			} else {
        				curMap.put(str, curMap.get(str) - 1);
        			}
        			count++;
        			j++;
        		} else {
        			String tmp = S.substring(i + (j-count)*wordLen, i + (j-count+1)*wordLen);
        			if (curMap.containsKey(str)) {
        				curMap.put(tmp, curMap.get(str) + 1);
        			} else {
        				curMap.put(tmp, 1);
        			}
        			count--;
        		}
        		
        		if (count == wordNum) {
        			result.add(i + (j-count) * wordLen);
        		}
        	}
        }
        return result;
    }
}
