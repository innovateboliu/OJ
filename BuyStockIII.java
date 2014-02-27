
public class BuyStockIII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int len = prices.length;
		int[] maxForward = new int[len];
		int[] maxBackward = new int[len];
		
		int min = Integer.MAX_VALUE;
		int diff = Integer.MIN_VALUE;
		
		for (int i = 0; i < len; i++) {
			min = Math.min(prices[i], min);
			if (prices[i] > min) {
				diff = Math.max(diff, prices[i] - min);
			}
			maxForward[i] = Math.max(diff, 0);
		}
		
		int max = Integer.MIN_VALUE;
		diff = Integer.MIN_VALUE;
		for (int i = len -1 ; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			if (prices[i] < max) {
				diff = Math.max(diff, max - prices[i]);
			}
			maxBackward[i] = Math.max(0, diff);
		}
		
		int maxProfit = Integer.MIN_VALUE;
		for (int i = 0; i <= len - 2; i++) {
			maxProfit = Math.max(maxProfit, maxForward[i] + maxBackward[i+1]);
		}
		maxProfit = Math.max(maxProfit, Math.max(maxForward[len - 1], maxBackward[0]));
		
		return Math.max(maxProfit, 0);
    }
}
