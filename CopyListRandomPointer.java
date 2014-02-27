import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class CopyListRandomPointer {

	class RandomListNode {
		int label;
		RandomListNode next, random;

		RandomListNode(int x) {
			this.label = x;
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CopyListRandomPointer ins = new CopyListRandomPointer();
		Map<RandomListNode, Integer> map = new HashMap<RandomListNode, Integer>();
		RandomListNode n1 = ins.new RandomListNode(1);
		map.put(n1, 1);
		RandomListNode n2 = ins.new RandomListNode(1);
		map.put(n2, 2);
	}

	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		Deque<RandomListNode> stack = new LinkedList<RandomListNode>();
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();

		stack.addFirst(head);
		map.put(head, new RandomListNode(head.label));
		
		while (stack.size() != 0) {
			RandomListNode cur = stack.removeFirst();
			RandomListNode newCur = map.get(cur);
			
			if (cur.next!=null) {
				if (!map.containsKey(cur.next)) {
					RandomListNode newNext = new RandomListNode(cur.next.label);
					map.put(cur.next, newNext);
					stack.addFirst(cur.next);
				}
				newCur.next = map.get(cur.next);
			}
			
			if (cur.random!=null) {
				if (!map.containsKey(cur.random)) {
					RandomListNode newRandom = new RandomListNode(cur.random.label);
					map.put(cur.random, newRandom);
					stack.addFirst(cur.random);
				}
				newCur.random = map.get(cur.random);
			}

		}

		return map.get(head);
	}

}
