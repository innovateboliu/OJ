import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class amazon {
	public ArrayList<Long> foo(long[] a, long b[]) {
		Set<Long> seta = new HashSet<Long>(); 
		for (long l : a) {
			seta.add(l);
		}
		ArrayList<Long> result = new ArrayList<Long>();
		
		for (long l : b) {
			if (!seta.contains(l)) {
				result.add(l);
			}
		}
		return result;
	}
}
