import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class RPN {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(new RPN().evalRPN(new String[]{"4","-2","/","2","-3","-","-"}));
		
//		System.out.println(new RPN().removeBracket("(2.0)"));
	}

	public int evalRPN(String[] tokens){
	    
		Set<String> operators = new HashSet<String>();
		operators.add("+");
		operators.add("-");
		operators.add("*");
		operators.add("/");
		
		Deque<Integer> stack = new LinkedList<Integer>();
		
		for (String str : tokens) {
			if (operators.contains(str)) {
				int second  = stack.removeLast();
				int first = stack.removeLast();
				int result = 0;
				switch(str) {
				case "+":
					result = first + second;
					break;
				case "-":
					result = first - second;
					break;
				case "*":
					result = first * second;
					break;
				case "/":
					result = first / second;
					break;
				}
				stack.addLast(result);
			} else {
				stack.addLast(Integer.parseInt(str));
			}
		}
		
		return stack.element();
	}
	
}
