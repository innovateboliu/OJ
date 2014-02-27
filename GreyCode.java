import java.util.ArrayList;


public class GreyCode {
	
	public static void main(String[] args) {
		GreyCode ins = new GreyCode();
		System.out.println(ins.grayCode(3));
	}
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);

        if (n == 0) {
        	return result;
        }
    	result.add(1);
    	
        if (n == 1) {
        	return result;
        }
        
        for (int i = 2; i <= n; i++) {
        	ArrayList<Integer> tmp = new ArrayList<Integer>();
        	for (int j = result.size() - 1; j >= 0; j--) {
        		String val = Integer.toString(result.get(j), 2);
        		String b = "1" ;
        		for (int k = 1; k <= i - 1 - val.length(); k++) {
        			b += "0";
        		}
        		tmp.add(Integer.valueOf(b+val,2));
        	}
        	result.addAll(tmp);
        }
        
        return result;
    }
}
