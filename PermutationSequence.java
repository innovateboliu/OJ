

public class PermutationSequence {

	public String getPermutation(int n, int k) {
		StringBuilder sb = new StringBuilder();
		int val = 1;
		for (int i = 0; i < n; i++) {
			char c = (char)(i + 1 + '0');
			sb.append(c);
			val *= i + 1;
		} 
		
		k -= 1;
		
		for (int i = 1; i < n; i++) {
			val /= n - i + 1;
			int a = i - 1;
			int b = k / val + i - 1;
			shift(sb, a, b);
			k = k % val;
			
		}	
		
		return sb.toString();
    }

	private void shift(StringBuilder sb, int from, int to) {
		char tmp = sb.charAt(to);
		for (int i = to; i > from; i--) {
			sb.setCharAt(i, sb.charAt(i - 1));
		}
		sb.setCharAt(from, tmp);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PermutationSequence ins = new PermutationSequence();
		System.out.println(ins.getPermutation(4, 15));
	}

}
