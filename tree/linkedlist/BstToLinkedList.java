package tree.linkedlist;

import tree.common.TreeBuilder;
import tree.common.BstNode;

public class BstToLinkedList {
	static BstNode head = null;
	static BstNode last = null;
	public static void convertBstToSingleLinkedList(BstNode root) {
		if (root == null) 
			return;
		if (root.left == null && head == null)
			head = root;
		convertBstToSingleLinkedList(root.left);
		if (last != null)
			last.right = root;
		last = root;
		convertBstToSingleLinkedList(root.right);
		
	}
	
	public static void convertBstToDoubleLinkedList(BstNode root) {
		if (root == null) 
			return;
		if (root.left == null && head == null)
			head = root;
		convertBstToDoubleLinkedList(root.left);
		if (last != null) {
			root.left = last;
			last.right = root;
		}
		last = root;
		convertBstToDoubleLinkedList(root.right);
		head.left = last;
		last.right = head;
	}

	public static void main(String args[]) {
		BstNode root = TreeBuilder.build();
//		convertBstToSingleLinkedList(root);
		convertBstToDoubleLinkedList(root);
//		TreeBuilder.printTreeSingleList(head);
		TreeBuilder.printTreeDoubleList(head);
	}
}
