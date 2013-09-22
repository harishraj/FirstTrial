public class Node {
	private int value;
	public Node next;

	public Node(int value) {
		this.value = value;
	}

	public Node(int value, Node node) {
		this.value = value;
		this.next =  node;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
}
