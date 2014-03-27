import java.util.ArrayList;
import java.util.Arrays;


public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	int len = num.length;
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < len - 3; i++) {
        	if (i > 0 && num[i] == num[i-1])
        		continue;
        	for (int j = i + 1; j < len - 2; j++) {
        		if (j > i+1 && num[j] == num[j-1])
        			continue;
        		
        		int subSum = target - num[i] - num[j];
        		int l = j + 1;
        		int k = len - 1;
        		
        		while (l < k) {
        			if (num[l] + num[k] == subSum) {
        				result.add(new ArrayList<Integer>(Arrays.asList(num[i], num[j], num[l], num[k])));
        				l++;
        				k--;
        				while (l < k && num[l-1] == num[l]) {
        					l++;
        				}
        				while (l < k && num[k+1] == num[k]) {
        					k--;
        				}
        			} else if (num[l] + num[k] < subSum) {
        				l++;
        			} else {
        				k--;
        			}
        		}
        	}
        }
        
        return result;
    }
    
    public static void main(String[] args) {
    	FourSum ins = new FourSum();
//    	int[] num = new int[] {2,1,0,-1};
    	int[] num = new int[] {-1,0,-5,-2,-2,-4,0,1,-2};
    	// -5, -4, -2, -2, -2, -1, 0, 0, 1
    	System.out.println(ins.fourSum(num, -9));

    }
}
