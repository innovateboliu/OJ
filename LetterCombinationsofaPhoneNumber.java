import java.util.ArrayList;


public class LetterCombinationsofaPhoneNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LetterCombinationsofaPhoneNumber ins = new LetterCombinationsofaPhoneNumber();
		System.out.println(ins.letterCombinations("23"));
		System.out.println(ins.letterCombinations("02"));

	}

    public ArrayList<String> letterCombinations(String digits) {
        String[] letters = {" ", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        
        helper(0, digits, sb, result, letters);
        
        return result;
    }
    
    private void helper(int cur, String digits, StringBuilder sb, ArrayList<String> result,String[] letters) {
    	if (cur == digits.length()) {
    		result.add(sb.toString());
    		return;
    	}
    	
    	String str = letters[digits.charAt(cur) - '0'];
    	
    	for (int i = 0; i < str.length(); i++) {
    		sb.append(str.charAt(i));
    		helper(cur + 1, digits, sb, result, letters);
    		sb.deleteCharAt(sb.length() - 1);
    	}
    	
    }
}
