import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumWindowSubstring ins = new MinimumWindowSubstring();
		System.out.println((ins.minWindow("aa", "aa")));
	}

	public String minWindow(String S, String T) {
		Map<Character, Integer> pattern = new HashMap<Character, Integer>();
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (!pattern.containsKey(c)) {
				pattern.put(c, 1);
			} else {
				pattern.put(c, pattern.get(c) + 1);
			}
		}
		int cnt = 0;

		int i = 0;
		int j = 0;

		int min = Integer.MAX_VALUE;
		int s = 0;
		int e = 0;

		boolean isFirst = true;
		while (i < S.length()) {
			char front = S.charAt(i);
			if (!pattern.keySet().contains(front)) {
				i++;
				continue;
			}
			if (!map.containsKey(front)) {
				map.put(front, 1);
			} else {
				map.put(front, map.get(front) + 1);
			}
			if (map.get(front) <= pattern.get(front)) {
				cnt++;
			}
			
			if (cnt == T.length()) {
				while ( j <= i) {
					char back = S.charAt(j);
					if (!pattern.keySet().contains(back)) {
						j++;
						continue;
					}
					if (map.get(back) > pattern.get(back)) {
						j++;
						map.put(back, map.get(back) - 1);
					} else {
						break;
					}
				}
				
				if (i - j + 1 < min) {
					s = j;
					e = i + 1;
					min = i - j + 1;
				}
			}
			i++;
		}

		if (cnt != T.length()) {
			return "";
		}
		return S.substring(s, e);
	}
}
