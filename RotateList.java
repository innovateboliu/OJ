
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
        	return null;
        }
    	ListNode tail = head;
    	for (int i = 0; i < n; i++) {
    		tail = tail.next;
    		if (tail == null) {
    			tail = head;
    		}
    	}
    	
    	ListNode newTail = head;
    	while (tail.next != null) {
    		newTail = newTail.next;
    		tail = tail.next;
    	}
    	
    	if (tail != newTail) {
    	tail.next = head;
    	head = newTail.next;
    	newTail.next = null;
    	}
    	
    	return head;
    }
    
    public static void main(String[] args) {
    	RotateList ins = new RotateList();
    	ListNode head = ListNode.build(1);
    	ListNode result = ins.rotateRight(head, 1);
    }
}

// 1 2 3 4 5
// 4 5 1 2 3