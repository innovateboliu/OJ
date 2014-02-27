import java.util.Deque;
import java.util.LinkedList;


public class LargestRectangleHistogram {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LargestRectangleHistogram ins = new LargestRectangleHistogram();
		System.out.println(ins.largestRectangleArea(new int[] {2,4}));
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
