package util;

import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {

	public void doDFS(Graph g, GNode root) {

		GNode n = root;
		List<GNode> adjacents = null;

		// using a stack
		Stack<GNode> s = new Stack<GNode>();
		// in stack - we drill down the edge first - finish the legs before
		// picking the siblings
		// in BFS - we use  Queue (linkedlist internally). Queue uses less
		// memory as compared to a stack - because in stack - every level of
		// recursion adds a new layer to the memory.

		s.push(n);

		while (!s.isEmpty()) {
			n = s.pop();
			if (n == null)
				continue;
			 
			// get all nodes that are linked to n. This method getAdjacents() is
			// implemented in my Graph class

			adjacents = g.getAdjacents(n);
			
			for (GNode node : adjacents) {
				// In a graph pick an element only ones, to avoid cycles and loops
				if (node.state == State.UNVISTED) {

					// once picked, mark as visited and put in stack for
					// processing
					node.state = State.VISITED;
					s.push(node);

					// if we want to process and edge
					processEdge(n, node);
				}
			}
			// we have picked all the connecting edges of a vertex n. Now if we
			// want to process a vertex.
			// now we are done with that vertex, we mark it as processed.
			processVertex(n);
			n.state = State.PROCESSED;
		}
	}

	// this can be used to process edge - like check if 2 nodes are connected
	public void processEdge(GNode a, GNode b) {
		System.out.println("Edge processd in : " + a.toString() + ", "
				+ b.toString());
	}

	public void processVertex(GNode n) {
		System.out.println("Vertex processd : " + n.toString());
	}

}