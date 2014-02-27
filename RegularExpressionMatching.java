public class RegularExpressionMatching {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RegularExpressionMatching ins = new RegularExpressionMatching();
		 System.out.println(ins.isMatch("aab", "c*a*b"));
		 System.out.println(ins.isMatch("aa", "aa"));
		 System.out.println(ins.isMatch("aa", "a*"));
		 System.out.println(ins.isMatch("aa", ".*"));
		System.out.println(ins.isMatch("a", "ab*"));
		 System.out.println(ins.isMatch("bbbba", ".*a*a"));
		 System.out.println(ins.isMatch("aaa", "ab*a"));
		 System.out.println(ins.isMatch("", "."));
		// System.out.println(ins.isMatch("aaa", "ab*a"));
		// System.out.println(ins.isMatch("aaa", "ab*a"));
	}

	public boolean isMatch(String s, String p) {
		if (s == null || p == null) {
			return true;
		}

		int lens = s.length();
		int lenp = p.length();

		if (lenp == 0 && lens == 0) {
			return true;
		} else {
			if (lenp == 0) {
				return false;
			} else if (lens == 0) {
				for (int i = lenp - 1; i >= 0; i--) {
					if (p.charAt(i) != '*' && (i == lenp - 1 || p.charAt(i + 1) != '*')) {
						return false;
					} 
				}
				return true;
			}
		}

		boolean[][] arr = new boolean[lens + 1][lenp + 1];
		arr[lens][lenp] = true;

		for (int i = lenp - 1; i >= 0; i--) {
			if (p.charAt(i) == '*' || (i < lenp - 1 && p.charAt(i + 1) == '*')) {
				arr[lens][i] = true;
			} else {
				break;
			}
		}

		for (int i = lens - 1; i >= 0; i--) {
			for (int j = lenp - 1; j >= 0; j--) {
				if (p.charAt(j) == '*') {
					continue;
				}
				if (j < lenp - 1) {
					if (p.charAt(j + 1) == '*') {
						if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
							arr[i][j] = arr[i + 1][j + 2] || arr[i + 1][j] || arr[i][j+2];
						} else {
							arr[i][j] = arr[i][j + 2];
						}
					} else {
						if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
							arr[i][j] = arr[i + 1][j + 1];
						} else {
							arr[i][j] = false;
						}
					}
				} else {
					if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.') {
						arr[i][j] = arr[i + 1][j + 1];
					} else {
						arr[i][j] = false;
					}
				}
			}
		}

		return arr[0][0];
	}
}
