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