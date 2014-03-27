import java.math.BigInteger;


public class AddBinary {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int b = Integer.parseInt("11", 2);
		int c = Integer.parseInt("10", 2);
		System.out.println(Integer.toString(b+c, 2));
	}

    public String addBinary(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }
}
