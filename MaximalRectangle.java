import java.util.Deque;
import java.util.LinkedList;


public class MaximalRectangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int maximalRectangle(char[][] matrix) {
    	int lenr = matrix.length;
    	if (lenr == 0) {
    		return 0;
    	}
    	int lenc = matrix[0].length;
        int[][] arr = new int[lenr][lenc];
        
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < lenr; i++) {
        	for (int j = 0; j < lenc; j++) {
        		int val = Integer.parseInt("" + matrix[i][j]) ;
        		if (i == 0) {
        			arr[i][j] = val;
        		} else {
        			if (val == 0) {
        				arr[i][j] = 0;
        			} else {
        				arr[i][j] = val + Integer.parseInt("" + arr[i-1][j]); 
        			}
        		}
        	}
        	max = Math.max(max, largestRectangleArea(arr[i]));
        }
        
        return Math.max(0, max);
    }
    
    public int largestRectangleArea(int[] height) {
    	if (height.length == 0) {
    		return 0;
    	}
    	Deque<Integer> stack = new LinkedList<Integer>();
    	
    	int max = Integer.MIN_VALUE;
    	stack.addLast(0);
    	for (int i = 1; i < height.length; i++) {
    		int idx = stack.peekLast();
    		if (height[i] >= height[idx]) {
    			stack.addLast(i);
    		} else {
    			int pos = i;
    			while (stack.size() > 0 && height[stack.peekLast()] > height[i]) {
    				pos = stack.removeLast();
    				int area = 0;
    				if (stack.size() > 0) {
    					area = height[pos] * (i - stack.peekLast() - 1);
    				} else {
    					area = height[pos] * (i);
    				}
        			max = Math.max(max, area);
    			}
    			
    			stack.addLast(i);
    		}
    	}
    	
    	int pos;
    	while (stack.size() > 0 && height[stack.peekLast()] > 0 ) {
    		pos = stack.removeLast();
			int area = 0;
			if (stack.size() > 0) {
				area = height[pos] * (height.length - stack.peekLast() - 1);
			} else {
				area = height[pos] * (height.length);
			}
			max = Math.max(max, area);
		}
    	
    	return Math.max(0,max);
        
    }

}
