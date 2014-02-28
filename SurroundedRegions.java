import java.util.Deque;
import java.util.LinkedList;


public class SurroundedRegions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = new char[][] {"OOO".toCharArray(),"OXO".toCharArray(),"OOO".toCharArray()};
		SurroundedRegions ins = new SurroundedRegions();
		ins.solve(board);
		System.out.println(board.length);
	}
	
	public void solve(char[][] board) {
		if (board == null) {
			return;
		}
		int rowSize = board.length;
		if (rowSize == 0) {
			return;
		}
		int columnSize = board[0].length;
        for (int i = 0; i < board.length; i++) {
        	if (i == 0 || i == rowSize -1 ) {
        		for (int j = 0; j < columnSize; j++) {
        			if (board[i][j] == 'O') {
        				scan(board, i, j);
        			}
        		}
        	}
        	if (board[i][0] == 'O') {
        		scan(board, i, 0);
        	}
        	if (board[i][columnSize - 1] == 'O') {
        	scan(board, i, columnSize - 1);
        	}
        }
        
        refillBoard(board);
    }
	
	private void refillBoard(char[][] board) {
		int rowSize = board.length;
		int columnSize = board[0].length;
		for (int i = 0; i < rowSize; i++) {
			for (int j = 0; j < columnSize; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == 'C') {
					board[i][j] = 'O';
				}
			}
		}
	}
	
	public class Pair {
		int a;
		int b;
		public Pair(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	private void scan(char[][] board, int i, int j) {
		int rowSize = board.length;
		int columnSize = board[0].length;
		
		Deque<Pair> stack = new LinkedList<>();
		stack.addFirst(new Pair(i, j));
		
		while(stack.size() != 0) {
			Pair pair = stack.removeFirst();
			board[pair.a][pair.b] = 'C';
			if (pair.a - 1 >= 0 && board[pair.a - 1][pair.b] == 'O') {
				stack.addFirst(new Pair(pair.a - 1, pair.b));
			}
				
			if (pair.a + 1 != rowSize && board[pair.a + 1][pair.b] == 'O') {
				stack.addFirst(new Pair(pair.a + 1, pair.b));
			}
			
			if (pair.b - 1 >= 0 && board[pair.a][pair.b-1] == 'O') {
				stack.addFirst(new Pair(pair.a, pair.b -1 ));
			}
				
			if (pair.b + 1 != columnSize && board[pair.a][pair.b+1] == 'O') {
				stack.addFirst(new Pair(pair.a, pair.b+1));
			}
		}
		
		
	}

}
