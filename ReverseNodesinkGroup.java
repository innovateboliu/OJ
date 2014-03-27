public class ReverseNodesinkGroup {
	
	public static void main(String[] args) {
		ReverseNodesinkGroup ins = new ReverseNodesinkGroup();
		ListNode head = ListNode.build(1);
//		head = ins.reverseKGroup(head, 1);
		
//		head = ListNode.build(1,2);
//		head = ins.reverseKGroup(head, 2);
		
//		head = ListNode.build(1,2);
//		head = ins.reverseKGroup(head, 3);
		
		head = ListNode.build(1,2,3,4);
		head = ins.reverseKGroup(head, 2);
	}
	
	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null) {
			return head;
		}
		ListNode senital = new ListNode(0);
		ListNode tail = senital;
		ListNode newTail = tail;
		tail.next = head;
		boolean running = true;
		while (running) {
			tail = newTail;
			for (int i = 0; i < k; i++) {
				newTail = newTail.next;
				if (newTail == null) {
					running = false;
					break;
				}
			}
			if (running) {
				newTail = reverse(tail, k);
			}
		}
		// 1 2 3 4 
		return senital.next;
	}

	private ListNode reverse(ListNode senital, int k) {
		ListNode newTail = senital.next;
		for (int i = 1; i < k; i++) {
			ListNode next = newTail.next;
			newTail.next = newTail.next.next;
			next.next = senital.next;
			senital.next = next;
		}
		
		return newTail;
	}

}
