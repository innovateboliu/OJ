
public class PartitionList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode partition(ListNode head, int x) {
		ListNode pre = new ListNode(0);
		ListNode sentinel = pre;
		pre.next = head;
		while (pre.next != null && pre.next.val < x) {
			pre = pre.next;
		}
	
		
		ListNode newPre = pre;
		while (newPre != null && newPre.next != null) {
			if (newPre.next.val < x) {
				ListNode tmp = newPre.next;
				newPre.next = newPre.next.next;
				tmp.next = pre.next;
				pre.next = tmp;
				pre = pre.next;

			} else {
			    newPre = newPre.next;
			}
		}
		
		
        return sentinel.next;
    }
}
