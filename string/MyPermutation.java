package string;

import java.util.HashSet;
import java.util.Set;

public class MyPermutation {

	private static void permutation(String str) {
		Set<Character> used = new HashSet<Character>();
		for (int i = 1; i <= str.length(); i++) {
			innerPermutation(str, new StringBuilder(), used, i);
		}
	}

	private static void innerPermutation(String str, StringBuilder output,
			Set<Character> used, int depth) {
		if (output.length() == depth) {
			System.out.println(output.toString());

			return;
		}
		int len = str.length();
		for (int i = 0; i < len; i++) {
			char c = str.charAt(i);
			if (!used.contains(c)) {
				used.add(c);
				innerPermutation(str, output.append(c), used, depth);
				output.setLength(output.length() - 1);
				used.remove(c);
			}
		}

	}

	private static void combination(String str) {
		for (int i = 1; i <= str.length(); i++) {
			innerCombination(str, new StringBuilder(), 0);
		}
	}

	private static void innerCombination(String str, StringBuilder output, int startIndex) {
		int len = str.length();
		for (int i = startIndex; i < len; i++) {
			char c = str.charAt(i);
			output.append(c);
			System.out.println(output.toString());
			innerCombination(str, output, i + 1);
			output.setLength(output.length() - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// permutation("abcd");
//		combination("abcd");
		innerCombination("abcd", new StringBuilder(), 0);
	}

}
