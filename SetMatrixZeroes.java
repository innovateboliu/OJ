
public class SetMatrixZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public void setZeroes(int[][] matrix) {
    	int rowNum = matrix.length;
    	if (rowNum == 0) {
    		return;
    	}
    	
    	int colNum = matrix[0].length;
    	
    	
        boolean isFirstRowZero = false;
        boolean isFirstColZero = false;
        
        for (int i = 0; i < colNum; i++) {
        	if (matrix[0][i] == 0) {
        		isFirstRowZero = true;
        		break;
        	}
        }
        
        for (int i = 0; i < rowNum; i++) {
        	if (matrix[i][0] == 0) {
        		isFirstColZero = true;
        		break;
        	}
        }
        
        for (int i = 1; i < rowNum; i++) {
        	for (int j = 1; j < colNum; j++) {
        		if (matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
        		}
        	}
        }
        
        for (int i = 1; i < rowNum; i++) {
        	for (int j = 1; j < colNum; j++) {
        		if (matrix[i][0] == 0 || matrix[0][j] == 0) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        
        if (isFirstRowZero == true) {
        	for (int i = 0; i < colNum; i++) {
        		matrix[0][i] = 0;
        	}
        }
        
        if (isFirstColZero == true) {
        	for (int i = 0; i < rowNum; i++) {
        		matrix[i][0] = 0;
        	}
        }
    }
}
