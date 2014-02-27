import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> tri = new ArrayList<ArrayList<Integer>>();
		tri.add(new ArrayList<Integer>( Arrays.asList(-1)));
		tri.add(new ArrayList<Integer>( Arrays.asList(2, 3)));
		tri.add(new ArrayList<Integer>( Arrays.asList(1, -1, -3)));
		
//		tri.add(new ArrayList<Integer>( Arrays.asList(1)));
//		tri.add(new ArrayList<Integer>( Arrays.asList(2, 3)));

		Triangle ins = new Triangle();
		int r = ins.minimumTotal(tri);
		System.out.println(r);
	}

//	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
//		if (triangle == null || triangle.size() == 0) {
//			return 0;
//		}
//		int[] min = new int[1];
//		min[0] = Integer.MAX_VALUE;
//		helper(triangle, min, 0, 0, 0, 0);
//		return min[0];
//	}

	public void helper(ArrayList<ArrayList<Integer>> tri, int[] min, int row, int col, int level, int sum) {
		sum += tri.get(row).get(col);
		if (level == tri.size() - 1) {
			min[0] = Math.min(min[0], sum);
			return;
		}

		helper(tri, min, row + 1, col, level + 1, sum);
		helper(tri, min, row + 1, col + 1, level + 1, sum);
	}
	
	public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0) {
			return 0;
		}
		int row = triangle.size();
		int col = triangle.get(row - 1).size();
		
		int[] arr = new int[row];
		int min = Integer.MAX_VALUE;
		int r = 0;
		arr[0] = triangle.get(0).get(0);
		for (int i = 1; i < row; i++) {
			arr[i] = triangle.get(i).get(0) + arr[i-1];
		}
		min = Math.min(min, arr[row-1]);
		for (int c = 1; c < col; c++) {
			arr[0] = arr[0] + triangle.get(c).get(c);
			for (r = 1; r < row - c; r++) {
				arr[r] = Math.min(arr[r], arr[r-1]) + triangle.get(r+c).get(c);
			}
			min = Math.min(min, arr[r-1]);
		}
		
		return min;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
