package language;


public class Polymorphism {
	public static void main(String args[]) {
		Car car = new Mercedez();
		car.testInstanceMethod();
		Car.testClassMethod();
		Mercedez.testClassMethod();
	}

}
