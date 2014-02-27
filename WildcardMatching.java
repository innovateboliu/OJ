public class WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildcardMatching ins = new WildcardMatching();
		System.out.println(ins.isMatch("*1", "*"));
	}

	int[][] table;

	public boolean isMatch(String s, String p) {
		 if (s == null || p == null) {
		        return false;
		    }
		int lens = s.length();
		int lenp = p.length();
		if (lens == 0 || lenp == 0) {
    		if (lens == 0 && lenp == 0) {
    		    return true;
    		}
    		return false;
		}
		table = new int[lens + 1][lenp + 1];
		for (int i = 0; i < lens; i++) {
			for (int j = 0; j < lenp; j++) {
				table[i][j] = 2;
			}
		}
		
		for (int i = 0; i < lens; i++) {
			table[i][lenp] = 0;
		}
		
		for (int j = 0; j < lenp; j++) {
			table[lens][j] = 0;
		}
		
		table[lens][lenp] = 1;

		return match(s, 0, lens, p, 0, lenp);
	}

	private boolean match(String s, int s1, int s2, String p, int p1, int p2) {

		
		if ((s.charAt(s1) == p.charAt(p1) || s.charAt(s1) == '?' || p.charAt(p1) == '?' ) &&
				(s.charAt(s1) != '*' && p.charAt(p1) != '*')) {
			if (table[s1 + 1][p1 + 1] != 2) {
				return table[s1 + 1][p1 + 1] == 1;
			} else {
				boolean r =  match(s, s1 + 1, s2, p, p1 + 1, p2);
				
				table[s1 + 1][p1 + 1] = (r == false ? 0 : 1) ;
				return r;
			}
		}

		if (s.charAt(s1) == '*' || p.charAt(p1) == '*') {
			boolean result = false;
			if (p.charAt(p1) == '*') {
				for (int i = s1 + 1; i < s2 + 1; i++) {

					if (table[i][p1 + 1] != 2) {
						result |= (table[i][p1 + 1] == 1);
					} else {
						boolean r = match(s, i, s2, p, p1 + 1, p2);
						table[i][p1 + 1] = (r == false ? 0 : 1);
						result |= r;
					}
				}
			}

			if (s.charAt(s1) == '*') {
				for (int j = p1 + 1; j < p2 + 1; j++) {

					if (table[s1 + 1][j] != 2) {
						result |= (table[s1 + 1][j] == 1);
					} else {
						boolean r = match(s, s1 + 1, s2, p, j, p2);
						table[s1 + 1][j] = (r == false ? 0 : 1);
						result |= r;
					}
				}
			}
			return result;
		}
		
		return false;
	}

}
