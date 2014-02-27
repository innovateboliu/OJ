
public class ReversLinkedListII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.build(1,2,3,4,5);
		ReversLinkedListII ins =  new ReversLinkedListII();
		ins.reverseBetween(head, 2, 4);
	}
	
//	1->2->3->4->5->NULL
//	1->4->3->2->5->NULL
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode tmp = new ListNode(0);
		tmp.next = head;
		ListNode pre = tmp;

        for (int i = 0; i < m  - 1; i++) {
        	pre = pre.next;
        }
        ListNode cur = pre.next;
        if (cur == null) {
        	return head;
        }
		ListNode next = cur.next;
		if (next == null) {
			if (m == n) {
				return head;
			} else {
				head = cur;
				cur.next = pre;
				pre.next = null;
			}
		}
        
        for (int i = 0; i < n - m; i++) {
        	cur.next = next.next;
        	next.next = pre.next;
        	pre.next = next;
        	next = cur.next;
        }
        
        return tmp.next;
    }
}
