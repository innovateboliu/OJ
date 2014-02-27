package tree.operation;

import java.util.ArrayList;

import tree.common.BstNode;
import tree.common.TreeBuilder;

public class recursion {

	public static ArrayList<BstNode> stack = new ArrayList<BstNode>();
	
	public static boolean recContains(BstNode root, int value) {
		if (root == null) {
			return false;
		}
		if (root.val == value) {
			return true;
		}
		return recContains(root.left, value) || recContains(root.right, value);
	}
	
	public static boolean iteContains(BstNode root, int value) {
		stack.clear();
		if (root == null) {
			return false;
		}
		
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				if (root.val == value) {
					return true;
				}
				stack.add(root);
				root = root.left;
			} else {
				root = stack.remove(stack.size() - 1).right;
			}
		}
		return false;
	}
	
	public static int recSize(BstNode root) {
		if (root == null) {
			return 0;
		}
		
		return recSize(root.left) + recSize(root.right) + 1;  
	}
	
	public static int iteSize(BstNode root) {
		stack.clear();
		int num = 0;
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				stack.add(root);
				root = root.left;
			}
			else {
				root = stack.remove(stack.size() - 1).right;
				num++;
			}
		}
		return num;
	}
	
	public static int recMaxDepth(BstNode root) {
		if (root == null) {
			return 0;
		}
		
		int leftMax = recMaxDepth(root.left);
		int rightMax = recMaxDepth(root.right);
		
		return 1 + (leftMax > rightMax ? leftMax : rightMax);
	}
	
	public static int iteMaxDepth(BstNode root) {
		stack.clear();
		if (root == null) {
			return 0;
		}
		
		root.record = 0;
		int parentDept = 0;
		int maxDepth = 0;
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				root.record = ++parentDept;
				stack.add(root);
				if (root.record > maxDepth) {
					maxDepth = root.record;
				}
				root = root.left;
			} else {
				root = stack.remove(stack.size() - 1);
				parentDept = root.record;
				root = root.right;
			}
		}
		return maxDepth;
	}
	
	public static boolean recHashPathSum(BstNode root, int sum) {
		if (root == null) {
			return sum == 0;
		}
		
		return recHashPathSum(root.left, sum - root.val) || recHashPathSum(root.right, sum - root.val);
	}
	
	public static boolean iteHashPathSum(BstNode root, int sum) {
		stack.clear();
		if (root == null) {
			return false;
		}
		
		int cnt = sum;
		
		while (!stack.isEmpty() || root != null) {
			if (root != null) {
				cnt = cnt - root.val;
				root.record = cnt;
				stack.add(root);
				root = root.left;
			} else {
				if (cnt == 0) {
					return true;
				}
				root = stack.remove(stack.size() - 1);
				cnt = root.record;
				root = root.right;
			}
		}
		return false;
	}
	
	public static void itePrintAllPaths(BstNode cur) {
		stack.clear();
		stack.add(cur);
		BstNode prev = null;
		while (!stack.isEmpty()) {
			int lastIndex = stack.size() - 1;
			cur = stack.get(lastIndex);
			if (prev == null || prev.left == cur || prev.right == cur) {
				if (cur.left != null) {
					stack.add(cur.left);
				} else if (cur.right != null) {
					stack.add(cur.right);
				} else {
					for (BstNode node : stack) {
						System.out.print(node.val);
					}
					System.out.println();
					stack.remove(lastIndex);
				}
			}
			if (cur.left == prev) {
				if (cur.right != null) {
					stack.add(cur.right);
				} else {
					stack.remove(lastIndex);
				}
			} else if (cur.right == prev) {
				stack.remove(lastIndex);
			}
			prev = cur;
		}
	}
	
	public static void recPrintAllPaths(BstNode root) {
		ArrayList<BstNode> path = new ArrayList<BstNode>();
		recSubPrintAllPaths(root, path);
	}
	
	public static void recSubPrintAllPaths(BstNode root, ArrayList<BstNode> oldPath) {
		if (root == null) {
			return;
		}
		ArrayList<BstNode> newPath = (ArrayList<BstNode>)oldPath.clone();
		newPath.add(root);
		
		if (root.left == null && root.right == null) {
//			for (int i = 0; i < len; i++) {
//				System.out.print(newPath.get(i).val);
//			}
			for (BstNode node : newPath) {
				System.out.print(node.val);
			}
			System.out.println();
		} else {
			recSubPrintAllPaths(root.left, newPath);
			recSubPrintAllPaths(root.right, newPath);
		}
	}
	
	public static boolean recIsBst(BstNode root) {
		if (root == null) {
			return false;
		}
		return recIsBstSub(root, Float.MIN_VALUE, Float.MAX_VALUE);
	}
	
	private static boolean recIsBstSub(BstNode root, float min, float max) {
		if (root == null ) {
			return true;
		}
		if (root.val < min || root.val >= max) {
			return false;
		}
		return recIsBstSub(root.left, min, root.val) && recIsBstSub(root.right, root.val, max);
	}
	
	public static boolean recIsBalanced(BstNode root) {
		if (root == null) {
			return true;
		}
		
		boolean subBalanced = recIsBalanced(root.left) && recIsBalanced(root.right);
		
		int leftHeight = recGetHeight(root.left);
		int rightHeight = recGetHeight(root.right);
		if (leftHeight - rightHeight < 1 && rightHeight - leftHeight < 1 && subBalanced ) {
			return true;
		} else {
			return false;
		}
	}
	
	private static int recGetHeight(BstNode root) {
		if (root == null) {
			return 0;
		}
		int leftHeight = recGetHeight(root.left);
		int rightHeight = recGetHeight(root.right);
		return 1 + leftHeight > rightHeight ? leftHeight : rightHeight;
	}
	
	public static void main(String args[]) {
		BstNode root = TreeBuilder.build();
		System.out.println(iteSize(root));
		System.out.println(recContains(root, 10));
		System.out.println(recContains(root, 2));
		System.out.println(iteContains(root, 10));
		System.out.println(iteContains(root, 5));
		System.out.println(recMaxDepth(root));
		
		System.out.println(iteMaxDepth(root.left.right));
		System.out.println(recHashPathSum(root, 16));
		System.out.println(iteHashPathSum(root, 9));
		itePrintAllPaths(root);
		recPrintAllPaths(root);
		System.out.println(recIsBst(root));
		System.out.println(recIsBalanced(root));
	}
}
