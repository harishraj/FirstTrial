public class Stack {

	StackNode stackTop;
 
  public Stack() {
    stackTop = new StackNode(0);
    }
  
  
  public void push(int data) {
      StackNode newitem = new StackNode(data);
      newitem.next = stackTop;
      stackTop = newitem;
    }

    public int pop() throws NullPointerException {
    	StackNode node;
       if (stackTop.next == null) 
    	   	throw new NullPointerException();
       else {
    	   node = stackTop;
           stackTop = stackTop.next;
       }
       return node.data;
    }

    public void retrieve() {
        if (stackTop.next == null) // if pointer null, dummy item only
            System.out.println("Stack empty");
        else
            System.out.println(stackTop.data + " is at top of the stack");
    }
}

