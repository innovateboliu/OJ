package oop;

public class InheritenceDemo {
	public static void main(String[] args) {
		Child p = new Child();
		p.print("a");
		
		p.exclusiveMethod(new Child());
	}
}
