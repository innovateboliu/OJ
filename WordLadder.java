import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class WordLadder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordLadder ins = new WordLadder();
		int len = ins.ladderLength("hit", "cog", new HashSet<String>(Arrays.asList("hot","dot","dog","lot","log")));
		System.out.println(len);
	}
	
	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (dict == null) {
			return 0;
		}
        Set<String> set = new HashSet<String>();
        int curLevelCnt = 1;
        int lastLevelCnt = 0;
        int min = Integer.MAX_VALUE;
        int curLevel = 0;
        
        Queue<String> q = new LinkedList<String>();
        
        q.add(start);
        while (q.size() != 0) {
        	if (lastLevelCnt == 0) {
        		int tmp = curLevelCnt;
        		curLevelCnt = lastLevelCnt;
        		lastLevelCnt = tmp;
        		curLevel++;
        	}
        	
        	if (curLevel > min) {
        		break;
        	}
        	
        	String cur = q.remove();
        	lastLevelCnt--;
        	
        	
        	
        	for (int i = 0; i < cur.length(); i++) {
        		for (char c = 'a'; c <='z'; c++) {
        			if (cur.charAt(i) == c) {
        				continue;
        			} else {
        				StringBuilder sb = new StringBuilder(cur);
        				sb.setCharAt(i, c);
        				String word = sb.toString();
        				if (word.equals(end)) {
        					min = Math.min(min, curLevel);
        				}
        				if (!dict.contains(word) || set.contains(word)) {
        					continue;
        				} else {
        					set.add(word);
        					q.add(word);
        					curLevelCnt++;
        				}
        			}
        		}
        	}
        }
        if (min == Integer.MAX_VALUE) {
        	return 0;
        } else {
        	return min + 1;
        }
    }

}
