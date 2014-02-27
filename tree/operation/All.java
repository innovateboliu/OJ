package tree.operation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import tree.common.BstNode;
import tree.common.TreeBuilder;

public class All {
	public static ArrayList<BstNode> stack = new ArrayList<BstNode>();

	
	public static void inOrder(BstNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.val);
			inOrder(root.right);
		}
	}
	
	public static void inOrderRecursive(BstNode root) {
		if (null != root) {
			inOrderRecursive(root.left);
			System.out.print(root.val);
			inOrderRecursive(root.right);
		}
	}
	
	public static void inOrderIteration(BstNode node) {
		List<BstNode> stack = new LinkedList<BstNode>();
		if (node == null) {
			return;
		}
		
		while(true) {
			if(node != null) {
				stack.add(node);
				node = node.left;
			}
			else {
				if (!stack.isEmpty()) {
					node = stack.remove(stack.size() - 1);
					System.out.print(node.val);
					node = node.right;
				} else {
					break;
				}
			}
		}
		
	}
	
	public static void preOrderIterative(BstNode node) {
		List<BstNode> stack = new LinkedList<BstNode>();
		while (true) {
			if (node != null) {
				System.out.print(node.val);
				stack.add(node);
				node = node.left;
			} else {
				if (!stack.isEmpty()) {
					node = stack.remove(stack.size() -1 );
					node = node.right;
				} else {
					break;
				}
			}
		}
	}
	
	public static void postOrderIterative(BstNode node) {
		List<BstNode> stack = new LinkedList<BstNode>();
		Set<BstNode> rightChildVisited = new HashSet<BstNode>();
		while (true) {
			if (node != null) {
				stack.add(node);
				node = node.left;
			} else {
				if (!stack.isEmpty()) {
					node = stack.get(stack.size() -1 );
					if (rightChildVisited.contains(node)) {
						node = stack.remove(stack.size() -1 );
						System.out.println(node.val);
						node = null;
					} else {
						rightChildVisited.add(node);
						node = node.right;
					}
				} else {
					break;
				}
			}
		}
	}
	
	public static void deleteAll(BstNode node) {
		if (node == null) {
			return;
		}
		
		deleteAll(node.left);
		deleteAll(node.right);
		node.left = null;
		node.right = null;
	}
	
	public static void levelTraverse(BstNode node) {
		Queue<BstNode> queue = new LinkedList<BstNode>();
		if (node == null) {
			return;
		}
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.remove();
			System.out.println(node.val);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);		
			}
		}
	}
	
	public static boolean isFull(BstNode node) {
		Queue<BstNode> queue = new LinkedList<BstNode>();
		boolean ifCheckRemaining = false;
		if (node == null) {
			return true;
		}
		queue.add(node);
		while (!queue.isEmpty()) {
			node = queue.remove();
			if (ifCheckRemaining) {
				if (node.left != null || node.right != null) {
					return false;
				}
			} else {
				if (node.left == null && node.right == null) {
					ifCheckRemaining = true;
				} else {
					if (node.left != null) {
						queue.add(node.left);
					}
					if (node.right != null) {
						queue.add(node.right);
					}
				}
			}
		}
		return true;
	}

	public static int count(BstNode node) {
		if (node == null) {
			return 0;
		}
		
		return 1 + count(node.right) + count(node.left); 
	}
	
	public static int height(BstNode node) {
		if (node == null) {
			return 0;
		}
		
		int left = height(node.left);
		int right = height(node.right);
		
		return left >= right ? 1 + left : 1 + right;
	}
	
	public static int width(BstNode node) {
		if (node == null) {
			return 0;
		}
		Queue<BstNode> q = new LinkedList<BstNode>();
		q.add(node);
		int curCnt = 1;
		int nextCnt = 0;
		int width = 1;
		int maxWidth = 0;
		
		while (!q.isEmpty()) {
			node = q.remove();
			curCnt--;
			
			
			if (node.left != null) {
				nextCnt++;
				q.add(node.left);
				width++;
			}
			if (node.right != null) {
				nextCnt++;
				q.add(node.right);
				width++;
			}
			if (curCnt == 0) {
				if (width > maxWidth) {
					maxWidth = width;
				}
				width = 0;
				curCnt = nextCnt;
				nextCnt = 0;
			}
		}
		
		return maxWidth;
	}
	
	public static void convertBstToDll(BstNode node) {
		if (node == null) {
			return;
		}
		
		BstNode[] record = new BstNode[2];
		
		innerConvertBstToDll(node, record);
		return;
	}
	
	private static void innerConvertBstToDll(BstNode node, BstNode[] record) {
		BstNode left = null;
		BstNode right = null;
		 if (node.left == null) {
			 left = node;
			 
		 } else {
			 innerConvertBstToDll(node.left, record);
			 node.left = record[1];
			 record[1].right = node;
			 left = record[0];
		 }
		 if (node.right == null) {
			 right = node;
		 } else {
			 innerConvertBstToDll(node.right, record);		
			 node.right = record[0];
			 record[0].left = node;
			 right = record[1];
		 }
		 
		 record[0] = left;
		 record[1] = right;
		 
	}
	
	public static void pathWithSum(BstNode node, int sum) {
		List<BstNode> path = new LinkedList<BstNode>();
		innerPathWithSum(node, path, sum);
	}
	
	private static void innerPathWithSum(BstNode node, List<BstNode> path, int sum) {
		if (node == null || node.val > sum) {
			return;
		}
		
		if (sum == node.val ) {
			path.add(node);
			for (BstNode n:path) {
				System.out.print(n.val);
			}
			System.out.println();
			path.remove(path.size() - 1);
			return;
		}
		
		
		path.add(node);
		innerPathWithSum(node.left, path, sum - node.val);
		innerPathWithSum(node.right, path, sum - node.val);
		path.remove(path.size() - 1);
	}
	
	public static void main(String args[]) {
		BstNode root = TreeBuilder.build();
//		inorder2(root);
//		preorder(root);
//		postorder(root);
//		inOrderRecursive(root);
//		inOrderIteration(root);
//		preOrderIterative(root);
//		postOrderIterative(root);
//		levelTraverse(root);
//		System.out.println(isFull(root));
//		System.out.println(isFull(TreeBuilder.buildComplete()));
//		System.out.println(count(root));
//		System.out.println(height(root));
//		System.out.println(width(TreeBuilder.buildComplete()));
//		convertBstToDll(root);
//		for (int i = 5; i > 0; i--) {
//			System.out.print(root.val);
//			root = root.left;
//		}
//		System.out.println();
//		for (int i = 9; i > 0; i--) {
//			System.out.print(root.val);
//			root = root.right;
//		}
		
		pathWithSum(TreeBuilder.buildPathSum(), 14);
	}
}
