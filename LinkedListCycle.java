
public class LinkedListCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return false;
		}
        ListNode fast = head.next.next;
        ListNode slow = head;
        
        while (fast != slow) {
        	if (fast.next == null || fast.next.next == null) {
        		return false;
        	}
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
        return true;
    }
}
