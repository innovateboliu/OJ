package leetcode;

import java.util.Arrays;

public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		int [] result = new int[2];
		int len = numbers.length;
        Arrays.sort(numbers);
        
        for (int i = 0, j = len - 1; i < j; ) {
        	if (numbers[i] + numbers[j] == target ) {
        		result[0] = i + 1;
        		result[1] = j + 1;
        		return result;
        	} else if (numbers[i] + numbers[j] < target ) {
        		i++;
        	} else {
        		j--;
        	}
        }
        return null;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
