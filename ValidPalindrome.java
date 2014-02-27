
public class ValidPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPalindrome ins = new ValidPalindrome();
		System.out.println(ins.isPalindrome("0k.;r0.k;"));
	}
//0 1 2 3
//0 1 2
	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0 || s.length() == 1) {
			return true;
		}
		int i = 0, j = s.length() - 1;
        while (i <= j) {
        	while (i <= j && !isAb(s.charAt(i))) {
        		i++;
        	}
        	
        	while (i <= j && !isAb(s.charAt(j)) ) {
        		j--;
        	}
        	
        	if (i > j) {
        		break;
        	}
        	
        	
        	if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
        		return false;
        	}
        	i++;
        	j--;
        }
        return true;
    }
	
	private boolean isAb(char c) {
		char tmp = Character.toLowerCase(c);
		if (('a' <= tmp && tmp <= 'z') ||('0' <= tmp && tmp <='9')) {
			return true;
		}
		return false;
	}
}
