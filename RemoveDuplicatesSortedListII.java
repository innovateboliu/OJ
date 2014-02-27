
public class RemoveDuplicatesSortedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.build(1, 2);
		RemoveDuplicatesSortedListII ins  = new RemoveDuplicatesSortedListII();
		ListNode res = ins.deleteDuplicates(head);
		System.out.println(res);
	}
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
        
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode cur = head;
        ListNode pre = sentinel;
        ListNode newPre = head;
        ListNode newCur = head.next;
        while (newCur != null) {
        	if (newCur.val != cur.val) {
        		if (cur.next == newCur) {
        			pre = cur;
        			cur = cur.next;
        		} else {
        		newPre.next = null;
            	pre.next = newCur;
            	cur = pre.next;
        		}
        	}
        	newPre = newCur;
    		newCur = newCur.next;
        }
        
        if (newCur == null && cur.next != null) {
        	pre.next = null;
        }
        return sentinel.next;
    }
}
