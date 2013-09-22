public class Queue { // FIFO
	static QueueNode head, tail;

	public Queue() {
		head = null;
		tail = null;
	}

	public static void enqueue(int value) {
		QueueNode temp = new QueueNode(value);
		if (head == null) { // new item is first in the empty queue
			head = temp;
			tail = temp;
		} else { // add it at the tail
			tail.next = temp;
			tail = temp;
		}
	}

	public static boolean isEmpty() {
		if (head == null)
			return true;
		else
			return false;
	}

	public static void dequeue() {
		if (isEmpty())
			System.out.println("Queue is empty");
		else {
			System.out.println(head.data + " taken from head of queue ");
			head = head.next;
		}
	}
}
