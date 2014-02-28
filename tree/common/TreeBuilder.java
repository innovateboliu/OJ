package tree.common;

public class TreeBuilder {
	public static BstNode build() {
		BstNode root = new BstNode(6);
		root.left = new BstNode(2);
		root.left.left = new BstNode(1);
		root.left.right = new BstNode(4);
		root.left.right.left = new BstNode(3);
		root.left.right.right = new BstNode(5);
		root.right = new BstNode(7);
		root.right.right = new BstNode(9);
		root.right.right.left = new BstNode(8);
		return root;
	}
	
	public static BstNode buildPathSum() {
		BstNode root = new BstNode(6);
		root.left = new BstNode(3);
		root.left.left = new BstNode(5);
		root.left.right = new BstNode(2);
		root.left.right.right = new BstNode(3);
		root.right = new BstNode(8);
		root.right.right = new BstNode(2);
		return root;
	}
	
	public static BstNode buildComplete() {
		BstNode root = new BstNode(6);
		root.left = new BstNode(2);
		root.left.left = new BstNode(1);
		root.left.left.left = new BstNode(10);
		root.left.left.right = new BstNode(11);
		root.left.right = new BstNode(4);
		root.left.right.left = new BstNode(3);
		root.left.right.right = new BstNode(5);
		root.right = new BstNode(7);
		root.right.left = new BstNode(12);
		root.right.left.left = new BstNode(13);
		root.right.left.right = new BstNode(14);
		root.right.right = new BstNode(9);
		root.right.right.left = new BstNode(8);
		root.right.right.right = new BstNode(15);
		return root;
	}
	
	public static void printTreeSingleList(BstNode head) {
		while (head != null) {
			System.out.println(head.val + "->"); 
			head = head.right;
		}
	}
	
	public static void printTreeDoubleList(BstNode head) {
		while (head != null) {
			System.out.println(head.val + "->"); 
			head = head.left;
		}
	}
}
