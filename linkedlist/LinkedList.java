public class LinkedList {

	private Node head;

	public LinkedList() {
	}

	public void add(int v) {
		Node n = new Node(v);
		n.setNext(head);
		head = n;
	}
	
	public Node getHead(){
		return head;
	}

	public int remove() {
		if (null == head) {
			throw new IllegalStateException("can't remove from empty list");
		}
		int v = head.getValue();
		head = head.getNext();
		return v;
	}

	public void reverse() {
		if (head != null) {
			Node newTail = reverseNodes(head);
			newTail.setNext(null);
		}
	}

	private Node reverseNodes(Node n) {
		if (n.getNext() == null) {
			head = n;
		} else {
			Node tailNode = reverseNodes(n.getNext());
			tailNode.setNext(n);
		}
		return n;
	}

	public void reverse2() {
		if (head != null) {
			Node previous = head;
			Node n = head.getNext();
			head.setNext(null);
			while (n != null) {
				Node oldNext = n.getNext();
				n.setNext(previous);
				previous = n;
				n = oldNext;
			}
			head = previous;
		}
	}

	public void print() {
		Node n = head;
		while (null != n) {
			System.out.print(n.getValue());
			System.out.print(" -> ");
			n = n.getNext();
		}
		System.out.print("null");
		System.out.println();
	}

	public void addFirst(int item) {
		Node previous = head;
		head = new Node(item);
		head.setNext(previous);
	}

	public void addFirst(Node item) {
		Node previous = head;
		head = item;
		head.setNext(previous);
	}

	public void addLast(int item) {
		if (head == null)
			addFirst(item);
		else {
			Node tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;
			tmp.next = new Node(item, null);
		}
	}

	public void addLast(Node item) {
		if (head == null)
			addFirst(item);
		else {
			Node tmp = head;
			while (tmp.next != null)
				tmp = tmp.next;

			tmp.next = item;
		}
	}

	public void insertAfter(int key, int toInsert) {
		Node tmp = new Node(key);

		Node n = head;
		while (n.getValue() != key) {
			n = n.getNext();
		}
		tmp.next = new Node(toInsert, tmp.next);
	}

	public boolean hasLoop(Node first) {
		if (first == null) // list does not exist.. so no loop either.
			return false;
		Node slow, fast; // create two references.
		slow = fast = first; // make both refer to the start of the list.

		while (true) {
			slow = slow.next; // 1 hop.
			if (fast.next != null)
				fast = fast.next.next; // 2 hops.
			else
				return false; // next node null => no loop.

			if (slow == null || fast == null) // if either hits null..no loop.
				return false;

			if (slow == fast) // if the two ever meet...we must have a loop.
				return true;
		}
	}

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.print();

		System.out.println("Add first ");
		list.addFirst(6);
		list.print();

		System.out.println("Add last ");

		list.addLast(9);
		list.print();

		System.out.println("Calling Insert after ");
		list.insertAfter(4, 10);
		list.print();

		System.out.println("Calling reverse 1");
		list.reverse();
		list.print();

		System.out.println("Calling reverse 2");
		list.reverse2();
		list.print();
	}
}