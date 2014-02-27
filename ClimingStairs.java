public class ClimingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int climbStairs(int n) {
		if (n==0 || n == 1) {
			return 1;
		}
		int a = 1;
		int b = 1;
		
		int c = 2;
		for (int i = n - 2; i >= 0; i--) {
			c = a + b;
			a = b;
			b = c;
		}
		
		return c;
	}
}
