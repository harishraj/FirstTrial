public class PQueue {

	public static PQNode head, tail;

	public PQueue() {
		head = new PQNode(0);
		tail = head;
	}

	public static boolean isEmpty() {
		if (head.priority == 0)
			return true;
		else
			return false;
	}

	public static void enQueue(int newvalue) {
		PQNode current, previous, temp;
		temp = new PQNode(newvalue);
		if (isEmpty()) {
			temp.back = tail;
			tail.next = temp;
			head = temp;
		} else {
			current = tail;
			previous = tail;
			while (temp.priority > current.priority && current.next != null) {
				previous = current;
				current = current.next;
			}
			if (temp.priority <= current.priority) {
				previous.next = temp;
				temp.back = previous;
				temp.next = current;
				current.back = temp;
			} else {
				current.next = temp;
				temp.back = current;
				head = temp;
			}
		}
	}

	public static void deQueue() {
		if (isEmpty())
			System.out.println("Priority Queue is empty");
		else {
			System.out.println("Item has priority " + head.priority);
			head = head.back;
		}
	}
}
