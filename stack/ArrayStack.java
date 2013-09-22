public class ArrayStack {
	static int limit;
	static int stackTop;
	static int[] list;

	public ArrayStack(int size) {
		limit = size - 1;
		list = new int[size];
		stackTop = -1;
	}

	public static void push(int data) {
		if (stackTop == limit)
			System.out.println("Stack full ");
		else {
			System.out.print("Value to push on stack: ");
			list[stackTop + 1] = data;
			stackTop++;
		}
	}

	public static void pop() {
		if (stackTop < 0)
			System.out.println("Stack empty ");
		else {
			System.out.println(list[stackTop] + " popped ");
			stackTop--;
		}
	}

	public static void retrieve() {
		if (stackTop < 0)
			System.out.println("Stack empty ");
		else
			System.out.println(list[stackTop] + " at stack top ");
	}
}
