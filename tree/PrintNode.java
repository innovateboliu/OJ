package tree;

public class PrintNode <T> implements NodeOperation <T>{
		
	@Override
	public void operate(BstNode<T> node) {
		// TODO Auto-generated method stub
		System.out.println(node.getValue());
	}


}
