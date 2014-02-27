import java.util.Deque;
import java.util.LinkedList;



public class LongestValidParentheses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LongestValidParentheses ins = new LongestValidParentheses();
		System.out.println(ins.longestValidParentheses("(()"));
		System.out.println(ins.longestValidParentheses(")()())"));
		System.out.println(ins.longestValidParentheses("()(()"));
		System.out.println(ins.longestValidParentheses("()(())"));
	}

    public int longestValidParentheses(String s) {
    	if (s == null || s.length() == 0) {
    		return 0;
    	}
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxCount = -1;
        int right = -1;
        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == '(') {
        		stack.addLast(i);
        	} else {
        		if (!stack.isEmpty()) {
        			stack.removeLast();
        			if ( stack.isEmpty()) {
        				maxCount = Math.max(maxCount, i - right);
        			} else {
        				maxCount = Math.max(maxCount, i - stack.getLast());
        			}
        		} else {
        			right = i;
        		}
        	}
        }
        
        return Math.max(maxCount, 0);
    }
}
