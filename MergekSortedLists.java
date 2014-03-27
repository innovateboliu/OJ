import java.util.ArrayList;
import java.util.Comparator;


public class MergekSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergekSortedLists ins = new MergekSortedLists();
		
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(ListNode.build(1,2,3,3,4));
		lists.add(ListNode.build(5,6,7,8));
		lists.add(ListNode.build(9,10,11,12));
		
		ListNode head = ins.mergeKLists(lists);
		while (head.next != null) {
			System.out.print(head.val + ",");
			head = head.next;
		}
	}

    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        BinaryHeap<ListNode> bh = new BinaryHeap<ListNode>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
        	
        });
        
        ListNode head = null, tail = null;
        
        for (ListNode p : lists) {
        	if (p != null) {
        		bh.add(p);
        	}
        }
        
        while (!bh.isEmpty()) {
        	ListNode min = bh.remove();
        	if (min.next != null) {
        		bh.add(min.next);
        	}
        	
        	if (head == null) {
        		head = new ListNode(min.val);
        		tail = head;
        	} else {
        		tail.next = new ListNode(min.val);
        		tail = tail.next;
        	}
        }
        
        return head;
    }
}
