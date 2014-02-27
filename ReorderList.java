public class ReorderList {

	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderList ins = new ReorderList();
		ListNode head = ins.build(1, 2, 3, 4, 5);
		ins.reorderList(head);
	}
	
	public ListNode build(int... args) {
		ListNode head = new ListNode(args[0]);
		ListNode cur = head;
		for (int i = 1; i < args.length; i++ ) {
			cur.next = new ListNode(args[i]);
			cur = cur.next;
		}
		return head;
	}
	// 1 2 3 4 5
	
	public void reorderList(ListNode head) {
		ListNode middle = findMiddle(head);
		if (middle == null) {
			return;
		}
		ListNode head2 = middle.next;
		head2 = reverse(head2);
		middle.next = null;
		
		while (head2 != null) {
			ListNode newHead2 = head2.next;
			ListNode newHead = head.next;
			head2.next = head.next;
			head.next = head2;
			head2 = newHead2;
			head = newHead;
		}
	}

	public ListNode reverse(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode next = head.next;
		head.next = null;
		while (next != null) {
			ListNode newNext = next.next;
			next.next = head;
			head = next;
			next = newNext;
		}
		return head;
	}
	public ListNode findMiddle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode m = head;
		while (head.next != null && head.next.next!= null) {
			m = m.next;
			head = head.next.next;
			
		}
		return m;
	}
}
