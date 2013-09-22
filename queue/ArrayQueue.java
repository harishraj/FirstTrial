import java.io.*;

public class ArrayQueue {
	int limit;
	int head, tail;
	int[] list;

	public ArrayQueue(int size) {
		limit = size - 1;
		list = new int[size];
		head = 0;
		tail = 0;
	}

	public boolean isEmpty() {
		if (head == tail)
			return true;
		else
			return false;
	}

	public boolean isFull() {
		if (tail > limit)
			return true;
		else
			return false;
	}

	public void enqueue(int data1) throws IOException {
		int data;

		if (isFull())
			System.out.println("Queue is full ");
		else {
			System.out.print("Item to enqueue: ");
			data = data1;
			list[tail] = data;
			tail++;
		}
	}

	public int dequeue() throws NullPointerException {
		int elem;
		if (isEmpty()) {
			System.out.println("Queue is empty ");
		    throw new NullPointerException("Queue is empty");
		} else {
			System.out.println(list[head] + " removed ");

			for (int i = 1; i < tail; i++) {
				list[i - 1] = list[i];
			}
			elem = list[tail];
			tail--;
			return elem;
		}
	}

	public void view() {
		if (isEmpty())
			System.out.println("Queue empty");
		else
			System.out.println(list[head]);
	}
}
