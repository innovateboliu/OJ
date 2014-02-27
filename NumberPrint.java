
public class NumberPrint {
	private static final int START = 1;
	private static final int END = 1000000;
	public static void main(String[] args) {
		StringBuilder output = new StringBuilder();
		for (int i = START; i <= END; i++) {
			output.setLength(0);
			
			if (isMultiple(i, 7)) {
				output.append("Multi");
			} 
			if (isMultiple(i, 13)) {
				if (output.length() > 0) {
					output.append(",");
				}
				output.append("Attribution");
			}
			if (isMultiple(i, 3, 5)) {
				if (output.length() > 0) {
					output.append(",");
				}
				output.append("Multi-Attribution");
			}
			
			if (output.length() > 0 ) {
				System.out.println(output.toString());
			} else {
				System.out.println(i);
			}
		}
	}
	
	private static boolean isMultiple(int num, int... primes) {
		for (int prime : primes) {
			if (num % prime != 0) {
				return false;
			}
		}
		return true;
	}
}
