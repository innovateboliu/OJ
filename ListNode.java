<<<<<<< HEAD
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
      
      public static ListNode build(int... vals) {
    	  if (vals.length == 0) {
    		  return null;
    	  }
    	  ListNode head = new ListNode(vals[0]);
    	  ListNode cur = head;
    	  for (int i = 1; i < vals.length; i++) {
    		  cur.next = new ListNode(vals[i]);
    		  cur = cur.next;
    	  }
    	  
    	  return head;
      }
  }
=======
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
	
	
	public static ListNode build(int... args) {
		ListNode head = new ListNode(args[0]);
		ListNode cur = head;
		for (int i = 1; i < args.length; i++) {
			cur.next = new ListNode(args[i]);
			cur = cur.next;
		}
		return head;
	}
	
	public static void print(ListNode head) {
		while (head != null ) {
			System.out.print(head.val + ",");
			head = head.next;
		}
	}
}
>>>>>>> e3b53077c17017751b238c27ea1551dbd436fe3a
