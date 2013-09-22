/*
 Class DLNode for double linked list
 */

public class DLNode {
	int value;
	DLNode next;
	DLNode back;

	public DLNode(int data) {
		value = data;
		next = null;
		back = null;
	}
}