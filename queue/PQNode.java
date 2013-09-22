/*

 PQNode for Priority Queue
 'Introducing Data Structures with Java
 David Cousins 2010
*/

public class PQNode {
  int priority;
  PQNode next;
  PQNode back;
  //constructor creates new node of given priority
    public PQNode(int value) {
    priority = value;
    next = null;
    back = null;
  }
}
