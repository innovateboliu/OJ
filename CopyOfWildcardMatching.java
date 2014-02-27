public class CopyOfWildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyOfWildcardMatching ins = new CopyOfWildcardMatching();
//		System.out.println(ins.isMatch("aaa", "*aaa*"));
//		System.out.println(ins.isMatch("ab", "*a"));
//
//		System.out.println(ins.isMatch("ho", "ho**"));
		System.out.println(ins.isMatch("abcdefde", "abc*def"));

	}

	

	public boolean isMatch(String s, String p) {
        int pl = 0;  
        for (int i = 0; i < p.length(); i++) {  
             if (p.charAt(i) != '*') {  
                  pl++;  
             }  
        }  
        if (pl > s.length()) {  
             return false;  
        }  
        if (s.length() == 0 && pl == 0) {  
             return true;  
        }
        
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
		boolean[][] table = new boolean[2][lenp + 1];
		table[1][lenp] = true;
		for (int j = lenp -1 ;j >= 0; j--) {
			if (p.charAt(j) == '*') {
				table[1][j] = table[1][j+1];
			}
		}
		table[0][lenp] = (s.charAt(lens-1) == '*');
//		table[1][lenp - 1] = false || (p.charAt(lenp -1 ) == '*');
		int flag = 0;
		int rFlag = 1;
		for (int i = lens - 1; i >= 0; i--) {
			char a = s.charAt(i);
			if (a == '*') {
				table[flag][lenp] = true;
			} else {
				table[flag][lenp] = false;
			}
			
			for (int j = lenp - 1; j >= 0; j--) {
				char b = p.charAt(j);
				
				if (a == '*' || b == '*') {
					if (a == '*' ) {
						table[flag][j] = table[flag][j+1] || table[rFlag][j] || table[rFlag][j+1];
					}
					if (b == '*' ) {
						table[flag][j] = table[rFlag][j] || table[flag][j+1] || table[rFlag][j+1];
					}
					continue;
				}
				if (a == b || a == '?' || b == '?') {
					table[flag][j] = table[rFlag][j+1];
					continue;
				}
				table[flag][j] = false;
			}
			int tmp = flag;
			flag = rFlag;
			rFlag = tmp;
		}
		return table[rFlag][0];
	}
}
