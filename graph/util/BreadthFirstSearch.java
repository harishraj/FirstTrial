package util;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {

	public void doBFS(Graph g, GNode root) {

		GNode n = root;
		List<GNode> adjacents = null;

		// using a queue
		// Note in Java - Queue is an Interface and not a class like Stack.
		// LinkedList internally implements it.
		// Queue provides add and poll methods for enqueue and dequeue respectively

		Queue<GNode> q = new LinkedList<GNode>();
		// in BFS - we process the siblings first than the children. Example -
		// process nodes at same depth in a tree before going to the next level.

		q.add(n);

		while (!q.isEmpty()) {

			// dequeue  
			// poll gets the head element
			n = q.poll();
			if (n == null)
				continue;

			// get all nodes that are linked to n. This method getAdjacents() is
			// implemented in my Graph class

			adjacents = g.getAdjacents(n);
			for (GNode node : adjacents) {

				// In a graph pick an element only ones, to avoid cycles and loops
				if (node.state == State.UNVISTED) {
					// once picked, mark as visited and put in stack for processing
					node.state = State.VISITED;
					q.add(node);

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

	public void processEdge(GNode a, GNode b) {
		System.out.println("Edge processd in : " + a.toString() + ", "
				+ b.toString());
	}

	public void processVertex(GNode n) {
		System.out.println("Vertex processd : " + n.toString());
	}
}