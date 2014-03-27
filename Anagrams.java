import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Anagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Anagrams ins = new Anagrams();
		System.out.println(ins.anagrams(new String[] {"", ""}));
	}
	
    public ArrayList<String> anagrams(String[] strs) {
    	ArrayList<String> result = new ArrayList<String>();
    	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    	
    	for (int i = 0; i < strs.length; i++) {
    		char[] charArr = strs[i].toCharArray();
    		Arrays.sort(charArr);
    		String sortedStr = new String(charArr);
    		if (map.containsKey(sortedStr)) {
    			map.get(sortedStr).add(i);
    		} else {
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(i);
    			map.put(sortedStr, list);
    			
    		}
    	}
    	
    	for (List<Integer> list : map.values()) {
    		if (list.size() > 1) {
    			for (Integer index : list) {
    				result.add(strs[index]);
    			}
    		}
    	}
    	
    	return result;
    }

}
