
public class ZigZag {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ZigZag ins = new ZigZag();
		System.out.println(ins.convert("paypalishiring", 3));
	}
	
    public String convert(String s, int nRows) {
    	if (nRows == 1) {
    		return s;
    	}
        StringBuilder sb = new StringBuilder();
        
        int diff = 2 * nRows - 2;
        int len = s.length();
        for (int i = 0; i < nRows; i++) {
        	int index = i;
        	while (index < len) {
        		sb.append(s.charAt(index));
        		int interIdx = index + diff - 2 * i;
        		if (interIdx < len && index < interIdx && interIdx < index + diff) {
        			sb.append(s.charAt(interIdx));
        		}
        		index += diff;
        	}
        }
        return sb.toString();
    }
}
