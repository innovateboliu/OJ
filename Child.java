import java.util.BitSet;



public class Child extends Parent{
//	@Override
	public void foo() {
		System.out.println("in child");
	}
	
	public static void main(String[] args) {
		Child child = new Child();
		Parent parent = child;
		parent.foo();
		
		System.out.println(Math.ceil(67f/9));
		
		BitSet bs1 = new BitSet(16);
		for(int i=0; i<16; i++) {
	        if((i%2) == 0) bs1.set(i);
	     }
		bs1.cardinality();
		bs1.clear(1);
		bs1.equals(bs1);
		bs1.nextSetBit(1);
		
		System.out.println(bs1);
		int i = 0xff;
		System.out.println(Integer.toString(i, 10));
		i = 0100;
		System.out.println(Integer.toString(i, 10));

		i = 0b101;
		System.out.println(Integer.toString(i, 10));

	}
}


