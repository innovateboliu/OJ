import java.util.PriorityQueue;


public class Try {
	
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(1);
		pq.add(2);
		for (int i = 0; i < 10000; i++) {
			pq.add(1);
			pq.remove();
		}
		
		
	}

}
