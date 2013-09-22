import java.util.HashMap;

public class LinkedListUtil {

	/**
	 * Removes all duplicate nodes from the passed in given linkedList. This
	 * method uses a HashMap to maintain a list of all the node values that have
	 * been seen. Each node is checked against the hash map to see if it
	 * contains the given value (CCI_0201)
	 * 
	 */
	public static void removeDuplicates(LinkedList linkedList) {
		if (linkedList == null || linkedList.getHead() == null) {
			return;
		}

		HashMap<Integer, Node> table = new HashMap<Integer, Node>();
		Node current = linkedList.getHead();

		table.put(current.getValue(), current);

		while (current.getNext() != null) {
			if (table.containsKey(current.getNext().getValue())) {
				// We've accessed this node before, so we're going
				// to go ahead and delete it
				Node matchedNode = current.getNext();
				current.setNext(matchedNode.getNext());
			} else {
				table.put(current.getNext().getValue(), current);
				current = current.getNext();
			}
		}
	}

	/**
	 * Removes all duplicate nodes from the passed in given linkedList. This
	 * method does not utilize an additional data structure to keep track of
	 * node values that we have already seen. Rather, it checks each element
	 * against the entire list, so the cost of the search is O(n^2). Checks in
	 * place (CCI_0201)
	 * 
	 * @param linkedList
	 *            the list that needs to be checked for duplicates
	 */
	public static void removeDuplicatesInPlace(LinkedList linkedList) {
		if (linkedList == null) {
			return;
		}

		Node toMatch = linkedList.getHead();

		while (toMatch != null) {
			Node current = toMatch;
			while (current.getNext() != null) {
				if (current.getNext().equals(toMatch)) {
					Node matchedNode = current.getNext();
					current.setNext(matchedNode.getNext());
				} else {
					current = current.getNext();
				}
			}

			toMatch = toMatch.getNext();
		}
	}

	/**
	 * Finds the nth to last element in the linked list (CCI_0202)
	 * 
	 * @param linkedList
	 *            the given list
	 * @param n
	 *            index of the element from the end of the list
	 * @return the nth to last element if found, null otherwise
	 */
	public static Node nthToLast(LinkedList linkedList, int n) {
		return null;
	}

	/**
	 * Deletes a node in the middle of a single linked list, given only access
	 * to that node. For instance:
	 * 
	 * Input: the node ÔcÕ from the linked list a->b->c->d->e Result: nothing is
	 * returned, but the linked list looks like a->b->d->e (CCI_0203)
	 * 
	 * PRE-CONDITION: toBeDeleted must not be the last node of the list
	 * 
	 */
	public static void deleteMiddleNode(Node toBeDeleted) {
		// if the given node is null, or the next one is null (i.e. the given
		// node is the last element of the list), return without any changes
		// as this does not meet the pre-condition of this method
		if (toBeDeleted == null || toBeDeleted.getNext() == null) {
			return;
		}

		toBeDeleted.setValue(toBeDeleted.getNext().getValue());
		toBeDeleted.setNext(toBeDeleted.getNext().getNext());
	}

	/**
	 * Adds two linked lists which represent numbers. Each node contains a
	 * single digit, and the digits are stored in the reverse order such that
	 * the 1's digit is at the head of the list. For instance:
	 * 
	 * Input: (3 -> 1 -> 5) + (5 -> 9 -> 2) Output: 8 -> 0 -> 8 (CCI_0204)
	 * 
	 * @param lhs
	 *            linked list representing the number on the left side of the
	 *            addition
	 * @param rhs
	 *            linked list representing the number on the right side of the
	 *            addition
	 * @return the result of adding the two numbers
	 */
	public static LinkedList addLinkedLists(LinkedList lhs, LinkedList rhs) {
		// Check to see if either of the lists is null
		if (lhs != null && rhs == null) {
			return lhs;
		} else if (lhs == null && rhs != null) {
			return rhs;
		} else if (lhs == null && rhs == null) {
			return null;
		}

		LinkedList result = new LinkedList();
		Node iter1 = lhs.getHead();
		Node iter2 = rhs.getHead();

		int sum = 0;
		int carry = 0;

		while (iter1 != null && iter2 != null) {
			sum = iter1.getValue() + iter2.getValue() + carry;
			carry = sum / 10;
			sum = sum % 10;

			result.addLast(new Node(sum));
			iter1 = iter1.getNext();
			iter2 = iter2.getNext();
		}

		// At least one of the iters is null now
		while (iter1 != null) {
			sum = iter1.getValue() + carry;
			carry = sum / 10;
			sum = sum % 10;

			result.addLast(new Node(sum));
			iter1 = iter1.getNext();
		}

		while (iter2 != null) {
			sum = iter2.getValue() + carry;
			carry = sum / 10;
			sum = sum % 10;

			result.addLast(new Node(sum));
			iter2 = iter2.getNext();
		}

		if (carry > 0) {
			result.addLast(new Node(carry));
		}

		return result;
	}

	/**
	 * Checks if the given linked list is a circular linked list (i.e. it
	 * contains a loop). This means a list in which a node's next pointer points
	 * to an earlier node, so as to make a loop in the linked list. For
	 * instance: A -> B -> C -> D -> E -> C [the same C as earlier]
	 * 
	 * (CCI_0205)
	 * 
	 * @param linkedList
	 *            the linked list to be tested
	 * @return true if there is a loop, false if there isn't
	 */
	public static boolean hasLoop(LinkedList linkedList) {
		if (linkedList == null || linkedList.getHead() == null) {
			return false;
		}

		Node slow = linkedList.getHead();
		Node fast = linkedList.getHead();

		while (true) {
			slow = slow.getNext();

			if (fast.getNext() != null) {
				fast = fast.getNext().getNext();
			} else {
				return false;
			}

			if (slow == null || fast == null) {
				return false;
			}

			if (slow == fast) {
				return true;
			}
		}
	}

	/**
	 * Returns the node at the start of a loop in the given circular linked
	 * list. A circular list is one in which a node's next pointer points to an
	 * earlier node, so as to make a loop in the linked list. For instance:
	 * 
	 * input: A -> B -> C -> D -> E -> C [the same C as earlier] output: C
	 * 
	 * @param linkedList
	 *            list to be tested
	 * @return the node at the start of the loop if there is a loop, null
	 *         otherwise
	 */
	public static Node findLoopStart(LinkedList linkedList) {
		if (linkedList == null || linkedList.getHead() == null) {
			return null;
		}

		Node loopStartNode = null;
		Node slow = linkedList.getHead();
		Node fast = linkedList.getHead();

		while (slow != null && fast != null) {
			slow = slow.getNext();
			if (fast.getNext() == null) {
				loopStartNode = null;
				break;
			}
			fast = fast.getNext().getNext();

			// If slow and fast point to the same node, it means that the
			// linkedList contains a loop.
			if (slow == fast) {
				slow = linkedList.getHead();

				while (slow != fast) {
					// Keep incrementing the two pointers until they both
					// meet again. When this happens, both the pointers will
					// point to the beginning of the loop
					slow = slow.getNext(); // Can't be null, as we have a loop
					fast = fast.getNext(); // Can't be null, as we have a loop
				}
				loopStartNode = slow;
				break;
			}
		}
		return loopStartNode;
	}

	/**
	 * Compares two lists element by element, to see if they are identical
	 * @return true if the lists are identical (i.e. the elements are equal)
	 */
	public static boolean compareLists(LinkedList lhs, LinkedList rhs) {
		if (lhs == null || rhs == null) {
			return false;
		}
		Node iter1 = lhs.getHead();
		Node iter2 = rhs.getHead();

		while (iter1 != null && iter2 != null) {
			if (!iter1.equals(iter1)) {
				return false;
			}
			iter1 = iter1.getNext();
			iter2 = iter2.getNext();
		}
		return true;
	}

}