// LIFO implementation

public class ArrayStack<T> {
	 Object t;
	 int limit;
	 int stackTop;
	 T[] list;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int size) {
		limit = size - 1;
		list = (T[]) new Object[size];
		stackTop = -1;
	}

	public  void push(T data) {
		if (stackTop == limit)
			System.out.println("Stack full ");
		else {
			System.out.print("Value to push on stack: ");
			list[stackTop + 1] = data;
			stackTop++;
		}
	}

	public  void pop() {
		if (stackTop < 0)
			System.out.println("Stack empty ");
		else {
			System.out.println(list[stackTop] + " popped ");
			stackTop--;
		}
	}

	public  void retrieve() {
		if (stackTop < 0)
			System.out.println("Stack empty ");
		else
			System.out.println(list[stackTop] + " at stack top ");
	}
}
