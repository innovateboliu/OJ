import java.util.ArrayList;


public class RestoreIPAddresses {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestoreIPAddresses ins = new RestoreIPAddresses();
//		ArrayList<String> res = ins.restoreIpAddresses("25525511135");
		ArrayList<String> res = ins.restoreIpAddresses("010010");
		System.out.println(res);
	}
    public ArrayList<String> restoreIpAddresses(String s) {
    	ArrayList<String> result = new ArrayList<String>();
    	if (s == null || s.length() > 12 || s.length() < 4) {
    		return result;
    	}
        
    	helper(result, new StringBuilder(), s, 0, 0);
    	
    	return result;
    }
    
    private void helper(ArrayList<String> result, StringBuilder sb, String s, int idx, int seg) {
    	if (seg == 4 && sb.length() == s.length() + 4) {
    		result.add(sb.toString().substring(0, sb.length() - 1));
    		return;
    	}
    	
    	for (int i = idx; i <= idx + 2 && i < s.length(); i++) {
    		String tmp = s.substring(idx, i + 1);
    		if (!isValid(tmp)) {
    			continue;
    		}
    		sb.append(tmp+".");
    		helper(result, sb, s, i + 1, seg + 1);
    		sb.delete(sb.length() - (i-idx+1) -1, sb.length());
    	}
    	return;
    }
    
    private  boolean isValid(String s) {
    	if (s == null || s.length() == 0 || (s.length() > 1 && s.charAt(0) == '0')) {
    		return false;
    	}
    	int i = Integer.parseInt(s);
    	if (0 <= i && i <= 255) {
    		return true;
    	}
    	return false;
    }

}
