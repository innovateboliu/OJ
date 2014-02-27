
public class RemoveDuplicatesSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
        ListNode cur = head;
        ListNode pre = head;
        ListNode next = head.next;
        
        while (next != null) {
        	if (next.val != cur.val) {
        		pre.next = null;
            	cur.next = next;
            	cur = next;
        	}
        	pre = next;
    		next = next.next;
        }
        
        if (next == null && cur.next != null) {
        	cur.next = null;
        }
        return head;
    }
}
