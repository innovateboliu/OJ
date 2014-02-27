
public class WordSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordSearch ins = new WordSearch();
		char[][] arr = new char[][] {"ABCE".toCharArray(), "SFCS".toCharArray(), "ADEE".toCharArray()};
//		System.out.println(ins.exist(arr, "ABCCED"));
		System.out.println(ins.exist(arr, "SEE"));
		System.out.println(ins.exist(arr, "ABCB"));
	}
	
    public boolean exist(char[][] board, String word) {
    	if (board.length == 0) {
    		return false;
    	}
    	
    	for (int i = 0; i < board.length; i++) {
    		for (int j = 0; j < board[0].length; j++) {
    			if( helper(board, word, i, j, 0)) {
    				return true;
    			}
    		}
    	}
        return false;
    }
    
    private boolean helper(char[][] board, String word, int x, int y, int idx) {
    	if (idx == word.length() - 1 && board[x][y] == word.charAt(idx)) {
    		return true;
    	}
    	if (board[x][y] != word.charAt(idx)) {
    		return false;
    	}
    	
    	char tmp = board[x][y];
		board[x][y] = '#';

    	if (x - 1 >= 0) {
    		if (helper(board,  word, x -1, y, idx + 1)) {
    			return true;
    		}
    	}
    	
    	if (y + 1 < board[0].length) {
    		if (helper(board, word, x, y+1, idx + 1)) {
    			return true;
    		}
    	}
    	
    	if (x + 1 < board.length) {
    		if (helper(board, word, x+1, y, idx + 1)) {
    			return true;
    		}
    	}
    	
    	if (y - 1 >= 0) {
    		if (helper(board, word, x, y-1, idx + 1)) {
    			return true;
    		}
    	}
    	
    	board[x][y] = tmp;
    	return false;
    }
}
