
public class BuyStockII {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int sum = 0;
		int i = 1, j = 0;
        for (; i < prices.length; i++) {
        	if (prices[i] <= prices[i-1]) {
        		sum += prices[i-1] - prices[j];
        		j = i;
        	} 
        }
        return sum += prices[i-1] - prices[j];
    }
}
