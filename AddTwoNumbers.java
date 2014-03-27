
public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
        	int num1 = l1 == null ? 0 : l1.val;
        	int num2 = l2 == null ? 0 : l2.val;
        	
        	int sum = num1 + num2 + carry;
        	
        	carry = sum / 10;
        	sum %= 10;
        	
        	if (head == null) {
        		head = new ListNode(sum);
        		tail = head;
        	} else {
        		tail.next = new ListNode(sum);
        		tail = tail.next;
        	}
        	
        	l1 = l1 == null ? null : l1.next;
        	l2 = l2 == null ? null : l2.next;

        }
        
        return head;
    }

}
