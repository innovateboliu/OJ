
public class SudokuSolver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SudokuSolver ins = new SudokuSolver();
		char[][] c = {".....7..9".toCharArray(),".4..812..".toCharArray(),"...9...1.".toCharArray(),"..53...72".toCharArray(),"293....5.".toCharArray(),".....53..".toCharArray(),"8...23...".toCharArray(),"7...5..4.".toCharArray(),"531.7....".toCharArray()};
		ins.solveSudoku(c);
	}
	
    public void solveSudoku(char[][] board) {
    	helper(board);
    }
    
    private boolean helper(char[][] board) {
    	for (int i = 0; i < 9; i++ ) {
    		for (int j = 0; j < 9; j++) {
    			if (board[i][j] == '.') {
    				for (int k = 1; k < 10; k++) {
    					if (isValid(board, i, j, k)) {
    						board[i][j] = (char)('0' + k);
    						if (helper(board)) {
    							return true;
    						} 
    						board[i][j] = '.';
    					}
    				}
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    private boolean isValid(char[][] board, int row, int col, int val) {
    	char c = (char)('0' + val);
    	for (int i = 0; i < 9; i++) {
    		if (board[row][i] == c || board[i][col] == c || board[row / 3 * 3 +  i / 3][col / 3 * 3 + i % 3] == c) {
    			return false;
    		}
    	}
    	return true;
    }
}
