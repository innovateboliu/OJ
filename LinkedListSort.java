public class LinkedListSort {

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public ListNode buildList(int... args) {
		if (args.length == 0) {
			return null;
		}
		ListNode head = new ListNode(args[0]);
		ListNode cur = head;
		for (int i = 1; i < args.length; i++) {
			ListNode newNode  = new ListNode(args[i]);
			cur.next = newNode;
			cur = cur.next;
		}
		return head;
	}
	
	public void printList(ListNode head) {
		while (head != null) {
			System.out.print(head.val + ",");
			head = head.next;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedListSort ins = new LinkedListSort();
		
		ins.printList(ins.sortList(ins.buildList(10, 10, 4, 5)));
	}

	public ListNode sortList(ListNode head) {
		if (head == null) {
			return null;
		} else if (head.next == null) {
			return head;
		}
		ListNode newHead = splitList(head);
		head = sortList(head);
		newHead = sortList(newHead);
		return mergeLists(head, newHead);
	}
	
	public ListNode splitList(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while (true) {
			if (fast != null && (fast = fast.next) != null && (fast = fast.next) != null) {
				slow = slow.next;
			} else {
				break;
			}
		}
		ListNode newHead = slow.next;
		slow.next = null;
		return newHead;
	}

	public ListNode mergeLists(ListNode a, ListNode b) {
		ListNode curA = a;
		ListNode curB = b;
		ListNode newHead = null;
		ListNode newTail = null;
		if (curB.val < curA.val) {
			newHead = curB;
			newTail = curB;
			curB = curB.next;
		} else {
			newHead = curA;
			newTail = curA;
			curA = curA.next;
		}
		while (curA != null && curB != null) {
			if (curB.val < curA.val) {
				newTail.next = curB;
				curB = curB.next;
			} else {
				newTail.next = curA;
				curA = curA.next;
			}
			newTail = newTail.next;
		}
		if (curA != null) {
			newTail.next = curA;
		} else if (curB != null){
			newTail.next = curB;
		}
		
		return newHead;
	}
}
