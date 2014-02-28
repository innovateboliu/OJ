package algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Algorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = Arrays.asList(3,4,2,1,7,9,8,5);
		Collections.sort(list);
		Collections.shuffle(list);
		Collections.binarySearch(list, 3);
		HashMap<Integer, String> map = new HashMap<Integer,String>();
		map.keySet();
	}
	
	

}
