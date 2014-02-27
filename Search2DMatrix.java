
public class Search2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Search2DMatrix ins = new Search2DMatrix();
		int[][] arr = new int[][] {{1,   3,  5,  7},{10, 11, 16, 20}, {23, 30, 34, 50}};
		System.out.println(ins.searchMatrix(arr,50));
	}
	
    public boolean searchMatrix(int[][] matrix, int target) {
        int numr = matrix.length;
        if (numr == 0) {
        	return false;
        }
        int numc = matrix[0].length;
        
        int end = numr * numc;
        int start = 0;
        
        int cur = end / 2;
        
        if (target > matrix[numr - 1][numc - 1] || target < matrix[0][0]) {
    		return false;
    	}
        while (start <= cur && cur <= end) {
        	int val = matrix[(cur) / numc][(cur) % numc];
        	if (val == target) {
        		return true;
        	}else if (val > target) {
        		end = cur - 1;
        	} else {
        		start = cur + 1;
        	}
        	
        	cur = (start + end) / 2;
        }
        return false;
    }

}
