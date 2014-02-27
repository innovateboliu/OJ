package tree;

public class Traversal {
	public static <T> void inorder(BstNode<T> root, NodeOperation<T> operation) {
		if (root == null) {
			return;
		}
		inorder(root.getLeft(), operation);
		operation.operate(root);
		inorder(root.getRight(), operation);
	}
	
	public static <T> void preOrder(BstNode<T> root, NodeOperation<T> operation) {
		if (root == null) {
			return;
		}
		
		operation.operate(root);
		preOrder(root.getLeft(), operation);
		preOrder(root.getRight(), operation);
	}
	
	public static <T> void postOrder(BstNode<T> root, NodeOperation<T> operation) {
		if (root == null) {
			return;
		}
		
		
		postOrder(root.getLeft(), operation);
		postOrder(root.getRight(), operation);
		operation.operate(root);
		root = null;
	}
	
	public static void main(String[] args) {
		BstNode<Integer> root = init();
//		postOrder(root, new PrintNode<Integer>());
		
		postOrder(root, new DeleteNode<Integer>());
	}
	
	private static BstNode<Integer> init() {
		BstNode<Integer> root = new BstNode<Integer>();
		root.setValue(0);
		BstNode<Integer> left = new BstNode<Integer>();
		left.setValue(1);
		root.setLeft(left);
		BstNode<Integer> right = new BstNode<Integer>();
		right.setValue(2);
		root.setRight(right);
		return root;
	}
}
