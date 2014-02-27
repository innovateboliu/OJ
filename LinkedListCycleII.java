
public class LinkedListCycleII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
        ListNode fast = head.next.next;
        ListNode slow = head.next;
        
        while (fast != slow) {
        	if (fast.next == null || fast.next.next == null) {
        		return null;
        	}
        	fast = fast.next.next;
        	slow = slow.next;
        }
        
        while (head != slow) {
        	head = head.next;
        	slow = slow.next;
        }
        return slow;
    }
}
