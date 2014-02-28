
public class EditDistance {

	public static void main(String[] args) {
		EditDistance ins = new EditDistance();
		System.out.println(ins.minDistance("mart", "karma"));
	}
    public int minDistance(String word1, String word2) {
    	int len1 = word1.length();
    	int len2 = word2.length();
    	
    	if (len2 == 0) {
    		return len1;
    	}
    	
    	if (len1 == 0) {
    		return len2;
    	}
    	int[][] arr = new int[2][len2];
    	
    	for (int i = 0; i < len1; i++) {
    		for (int j = 0; j < len2; j++) {
    			if (word1.charAt(i) == word2.charAt(j) ) {
    				if (j == 0) {
    					arr[(i+1)%2][j] =  i;
    					continue;
    				} 
    				if (i == 0) {
    					arr[(i+1)%2][j] = j;
    					continue;
    				}
    				arr[(i+1)%2][j] = arr[i%2][j-1];
    			} else if (word1.charAt(i) != word2.charAt(j) ) {
    				int a = (j==0? i : arr[(i+1)%2][j-1]);
    				int b = (i==0? j : arr[i%2][j]);
    				int c = Math.min(a, b);
    				if (j != 0 && i != 0) {
    					c = Math.min(c, arr[i%2][j-1]);
    				}
    				arr[(i+1)%2][j] = c + 1;
    			}
    			
    		}
    	}
    	
    	return arr[len1%2][len2 - 1];
    }
}
