package tree;

public class DeleteNode <T> implements NodeOperation<T>{

	@Override
	public void operate(BstNode<T> node) {
		node.setLeft(null);
		node.setRight(null);
	}

}
