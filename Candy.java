
public class Candy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Candy ins = new Candy();
		System.out.println(ins.candy(new int[]{1,2,2}));
	}

	
	public int candy(int[] ratings) {
		int len = ratings.length;
        int[] candy = new int[len];
        candy[0] = 1;
        
        
        for (int i = 1; i < len  ; i++) {
        	int preRating = ratings[i-1];
        	if (ratings[i] > ratings[i-1]) {
        		candy[i] = candy[i-1] + 1;
        	}  else {
        		candy[i] = 1;
        	}
        	
        }
        
        int cnt = candy[len-1];
        for (int i = len - 2; i >= 0; i--) {
        	if (ratings[i] > ratings[i+1] && candy[i] <= candy[i+1]) {
        		candy[i] = candy[i+1] + 1;
        	}
        	cnt += candy[i];
        }
        return cnt;
    }
}
