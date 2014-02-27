import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {

	public static void main(String[] args) {
		WordBreakII ins = new WordBreakII();
		ArrayList<String> result = ins.wordBreak("catsanddog",
				new HashSet<String>(Arrays.asList("cat", "cats", "and", "sand", "dog")));
//		ArrayList<String> result = ins.wordBreak("ab",
//				new HashSet<String>(Arrays.asList("a", "b")));
		System.out.println(result);
	}

	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		// Note: The Solution object is instantiated only once and is reused by
		// each test case.
		int len = s.length();
		List<List<Integer>> dp = new ArrayList<List<Integer>>();
		for (int i = 0; i < len; i++) {
			dp.add(new ArrayList<Integer>());
		}
		initDp(dp, s, dict);
		ArrayList<String> result = new ArrayList<String>();
		dfs(dp, s, dict, len - 1, new StringBuilder(), result);
		return result;
	}

	private void initDp(List<List<Integer>> dp, String s, Set<String> dict) {

		for (int j = 0; j <= s.length(); j++) {
			if (dict.contains(s.substring(0, j))) {
				dp.get(j - 1).add(0);
			}
		}
		
		for (int i = 1; i < s.length(); i++) {
			if (dp.get(i).size() == 0 && dp.get(i-1).size() == 0) {
				continue;
			}
			int start = i;
			for (int j = start + 1; j <= s.length(); j++) {
				if (dict.contains(s.substring(start, j))) {
					dp.get(j - 1).add(start);
				}
			}
		}
		
		
	}

	private void dfs(List<List<Integer>> dp, String s, Set<String> dict,
			int end, StringBuilder sb, ArrayList<String> result) {
		if (end == -1) {
			result.add(sb.toString().trim());
			return;
		}
//		for (int i = end; i >= 0; i--) {
//			if (dp.get(i).size() == 0) {
//				continue;
//			}
			for (Integer j : dp.get(end)) {
				sb.insert(0, " " + s.substring(j, end + 1));
				dfs(dp, s, dict, j -1, sb, result);
				sb.delete(0, end+1-j+1);
			}
//		}
	}
}
