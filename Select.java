import java.util.Arrays;


public class Select {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] list = {2, 3 ,4, 5 ,3      ,2 ,3 ,3 ,4 ,5     ,1 ,2 ,3 ,2 ,1      ,3 ,2 ,1};
//		int[] list = {2, 3 ,4, 5 ,1};
		System.out.println(fib_B(0));
		System.out.println(fib_B(1));
		System.out.println(fib_B(10));
//		
//		System.out.println(partition(list, 0, list.length, 3));
	}
	
	public static long fib_B(long n) { 
		int previous = -1; 
		int result = 1; 
		for (int i = 0; i <= n; i++) 
		{ 
		int sum = result + previous; 
		previous = result; 
		result = sum; 
		} 
		return result;
	}
	public static int select(int[] list) {
		return innerSelect(list, 0, list.length, 3);
	}
	
	private static int innerSelect(int[] list, int start, int end, int k) {
		double lenDouble = end - start;
		int len = end - start;
		if (len == 1) {
			return list[start];
		}
		int numGroup = (int)Math.ceil(lenDouble/5);
		int[] medians = new int[numGroup];
		
		int i = 0;
		for (; i < numGroup - 1; i++ ) {
			medians[i] = getMedian(list, start + 5 * i, start + 5 * (i + 1));
		}
		medians[i] = getMedian(list, start + 5 * i, end);
		
		int pivot = innerSelect(medians, 0, numGroup, (int)Math.ceil(lenDouble/10));
		
		int posPivot = partition(list, start, end, pivot);
		
		if (k - 1 == posPivot) {
			return pivot;
		} else if (k - 1 < posPivot) {
			return innerSelect(list, start, start + posPivot, k);
		} else {
			return innerSelect(list, start + posPivot + 1, end, k - posPivot - 1);
		}
	}
		
	private static int getMedian(int[] list, int start, int end) {
		int len = end - start;
		int[] copy = new int[len];
		System.arraycopy(list, start, copy, 0, len);
		Arrays.sort(copy);
		return copy[len / 2];
	}
	
	private static int partition(int[] list, int start, int end, int pivot) {
		for (int i = start; i < end; i++) {
			if (list[i] == pivot) {
				exchange(list, i, end - 1);
				break;
			}
		}
		int i = start - 1;
		for (int j = start; j < end - 1; j++) {
			if (list[j] <= pivot) {
				++i;
				exchange(list, i, j);
			}
		}
		exchange(list, i + 1, end -1);
		return i + 1 - start;
	}
	
	private static void exchange(int[] list, int i, int j) {
		int tmp = list[i];
		list[i] = list[j];
		list[j] = tmp;
	}

}
