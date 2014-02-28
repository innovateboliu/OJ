package language;

import string.MyPermutation;

public class StringManip {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] helloArray = { 'h', 'e', 'l', 'l', 'o'};
		String helloString = new String(helloArray);
//		System.out.println(helloString);
		
		char[] tmpArray = new char[helloString.length()];

		helloString.getChars(0, helloString.length(), tmpArray, 0);
//		System.out.println(tmpArray);
		
		helloString.concat(" world");
		StringBuilder sb = new StringBuilder();
		sb.append(helloString);
		
		float f = Float.valueOf("10.3").floatValue();
		f = Float.parseFloat("10.2");
		
		String str = "boo:and:foo";
		String[] result = str.split("o", -2);
//		for (String s : result) {
//			System.out.println(s);
//		}
//		System.out.println("$");
		
		str = "bo.liu.innovate";
		result = str.split("\\.");
		for (String s : result) {
			System.out.println(s);
		}
		System.out.println("$");
		
		str.trim();
		str.toLowerCase();
		
		str.indexOf("bo");
		
		str = "bo";
		String str2 = "bo";
		System.out.println(str == str2);
		str2 = new String("bo");
		System.out.println(str != str2);
		str2 = new String("bo").intern();
		System.out.println(str == str2);
		
		str.replace('a', 'b');
		str.replaceAll("a", "b");
		
		int i = Integer.parseInt("ff", 16);
		
		int k = myParseInt("", 16);
		System.out.println(k);
		
		System.out.println(Integer.toString(10, 16));
	}
	
	private static int myParseInt(String str, int radix) {
		int sum = 0;
		int len = str.length();
		int base = 1;
		for (int i = len - 1; i >= 0; i--) {
			char c = str.charAt(i);
			int diff = getDiff(c, radix);
			if (diff != -1) {
				sum += diff * base;
				base *= radix;
			} else {
				throw new  NumberFormatException();
			}
		}
		return sum;
	}
	
	private static int getDiff(char c, int radix) {
		int[] diffArray = {c - '0', c - 'A' + 10,  c - 'a' + 10};
		
		for (int diff : diffArray) {
			if (0 <= diff && diff < radix) {
				return diff;
			}
		}
		
		return -1;
	}

}
