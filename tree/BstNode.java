package tree;

public class BstNode <T> {
	private T value;
	private BstNode<T> left;
	private BstNode<T> right;
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public BstNode<T> getLeft() {
		return left;
	}
	public void setLeft(BstNode<T> left) {
		this.left = left;
	}
	public BstNode<T> getRight() {
		return right;
	}
	public void setRight(BstNode<T> right) {
		this.right = right;
	}
	
}
