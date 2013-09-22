public class DLList {
	public static DLNode head, end;

	public DLList() {
		head = new DLNode(0);
		end = new DLNode(0);
	}

	public static boolean isEmpty() {
		if (head.next == null)
			return true;
		else
			return false;
	}

	public static void insert(int value) {
		DLNode focusNode, previous, temp;
		while (value != 0) {
			temp = new DLNode(value);
			focusNode = head;
			previous = head;
			while ((focusNode.next != null) || (focusNode.value < value)) {
				previous = focusNode;
				focusNode = focusNode.next;
			}
	
			if (focusNode.value > value) {
				temp.next = focusNode;
				focusNode.back = temp;
				previous.next = temp;
				temp.back = previous;
			} else {
				end = temp;
				focusNode.next = temp;
				temp.back = focusNode;
			}
		}
	}

	public static void search(int sought) {
		DLNode current = head.next;
		boolean found = false;
		if (isEmpty())
			System.out.println("List is empty ");
		else {
			System.out.print(" Value sought: ");
			while ((!found) || !(current == null)) {
				if (current.value == sought) {
					System.out.println(sought + " is in the list ");
					found = true;
				}
				current = current.next;
			}
			if (!found)
				System.out.println("Item is not in the list ");
		}
	}

	public static void deleteItem(int sought){
		DLNode current, previous;
		boolean found = false;
		if (isEmpty())
			System.out.println("List is empty ");
		else {
			System.out.print("Item to delete: ");
			current = head;
			previous = head;
			while (!found || !(current == null)) {
				if (current.value == sought) {
					previous.next = current.next;
					if (current.next != null) // check if end of list
						current.next.back = previous;
					else
						end = previous; // new end of list
					System.out.println(sought + " deleted from list ");
					found = true;
				} else {
					previous = current;
					current = current.next;
				}
			}
			if (!(found))
				System.out.println("Item is not in the list ");
		}
	}

	public static void writeListinOrder() {
		DLNode current = head.next;
		if (isEmpty())
			System.out.println("List is empty ");
		else {
			while (current != null) {
				System.out.println(current.value);
				current = current.next;
			}
		}
	}

	public static void writeListReversed() {
		DLNode current = end;
		if (end == null)
			System.out.println("List is empty ");
		else {
			while (current.back != null) {
				System.out.println(current.value);
				current = current.back;
			}
		}
	}
}
