package oop;

public class MyImplementation<T extends Parent> implements MyInterface<T>{

	@Override
	public T execute() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		MyImplementation<Child> mi = new MyImplementation<Child>();
		mi.execute();
	}

}
