public class InsertionSortList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InsertionSortList ins = new InsertionSortList();
		
		ListNode head = ListNode.build(3,4,1);
		ListNode.print(head);
		head = ins.insertionSortList(head);
		System.out.println(head);
		
	}
	
	



	public ListNode insertionSortList(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode pre = head;
		ListNode cur = pre.next;

		while (cur != null) {
			ListNode subPre = null;
			ListNode subCur = head;
			
			while (cur.val >= subCur.val && subCur != cur) {
				subPre = subCur;
				subCur = subCur.next;
			}
			ListNode next = cur.next;
			
			

			if (subCur != cur) {
				pre.next = cur.next;
				
				cur.next = subCur;
				if (subPre == null) {
					head = cur;
				} else {
					subPre.next = cur;
				}
			}  else {
				pre = cur;
				
			}
			cur = next;
			
			
		}
		
		return head;
	}
}
