
public class BinaryTreeMaximumPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public int maxPathSum(TreeNode root) {
    	int leftSum = Integer.MIN_VALUE;
    	int rightSum = Integer.MIN_VALUE;
        if (root.left != null) {
        	leftSum = maxPathSum(root.left);
        }
        
        if (root.right != null) {
        	rightSum = maxPathSum(root.right);
        }
        
        int max = Integer.MIN_VALUE;
        
        if (root.val >= 0) {
        	max = Math.max(leftSum, leftSum + root.val);
        	max = Math.max(max, max+rightSum);
        } else {
        	max = Math.max(leftSum, rightSum);
        	max = Math.max(max, root.val);
        }
        
        return max;
    }
}
