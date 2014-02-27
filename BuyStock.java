
public class BuyStock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	public int maxProfit(int[] prices) {
//		if (prices == null) {
//			return 0;
//		}
//		int len = prices.length;
//		int[] mins = new int[len];
//		
//		int min = Integer.MAX_VALUE;
//		for (int i = 0; i < len; i++) {
//			mins[i] = Math.min(min, prices[i]);
//		}
//		
//		int max = Integer.MIN_VALUE;
//		int diff = Integer.MIN_VALUE;
//		
//		for (int i = len - 1; i>=0; i--) {
//			max = Math.max(max, prices[i]);
//			if (max > mins[i]) {
//				diff = Math.max(diff, max - prices[i]);
//			}
//		}
//		
//		return Math.max(0, diff);
//    }
	public int maxProfit(int[] prices) {
		if (prices == null) {
			return 0;
		}
		int len = prices.length;
		
		int min  = Integer.MAX_VALUE;
		int diff = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			min = Math.min(min, prices[i]);
			if (min < prices[i]) {
				diff = Math.max(diff, prices[i] - min);
			}
		}
		
		return Math.max(diff, 0);
    }

}
