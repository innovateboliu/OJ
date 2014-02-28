import java.util.HashMap;
import java.util.Map;

public class LRUCache {

	public class Node {
		private int val;
		private int key;
		private Node prev;
		private Node next;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.prev = this;
			this.next = this;
		}
	}

	private int capacity = 0;
	private int size = 0;
	private Node head;
	private Node tail;

	Map<Integer, Node> addr = new HashMap<>();

	

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (addr.containsKey(key)) {
			Node node = addr.get(key);
			removeNode(node);
			addLast(node);
			return node.val;
		} else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (capacity == 0) {
			return;
		}
		if (size == 0 && size < capacity) {
			Node newNode = new Node(key, value);
			head = newNode;
			tail = newNode;

			addr.put(key, newNode);
			size++;
			return;
		}

		if (addr.containsKey(key)) {
			Node node = addr.get(key);
			node.val = value;
			removeNode(node);

			addLast(node);
		} else {
			Node newNode = new Node(key, value);
			if (size == capacity) {
				removeHead();
			} 
			addLast(newNode);
			addr.put(key, newNode);
		}
	}

	private void addLast(Node node) {
		if (size == 0) {
			tail = node;
			head = node;
		} else {
			tail.next = node;
			node.prev = tail;
			tail = node;
			node.next = head;
			head.prev = node;
		}
		size++;
	}

	private void removeHead() {
		if (size > 0) {
			Node node = head;
			addr.remove(node.key);
			tail.next = head.next;
			head.next.prev = tail;
			head = head.next;
		} else {
			tail = null;
			head = null;
		}
		size--;
	}
	
	private void removeNode(Node node) {
		if (size == 1) {
			head = null;
			tail = null;
		} else {
			if (node == tail) {
				tail = node.prev;
			}
			if (node == head) {
				head = node.next;
			}
			node.prev.next = node.next;
			node.next.prev = node.prev;
		}
		size--;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache ins = new LRUCache(2);
		ins.set(2, 1);
		ins.set(1, 1);
		System.out.println(ins.get(2));
		ins.set(4, 1);
		System.out.println(ins.get(1));
		System.out.println(ins.get(2));
	}
}
