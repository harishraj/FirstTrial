package graph;

import java.util.*;

public class Graph {

	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // list of vertices
	private int adjMat[][]; // adjacency matrix
	private int nVerts; // current number of vertices
	private Queue theQueue;
	private Stack<Integer> theStack;
	
	public Graph() {

		vertexList = new Vertex[MAX_VERTS];
		// adjacency matrix
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++)
			// set adjacency
			for (int k = 0; k < MAX_VERTS; k++)
				// matrix to 0
				adjMat[j][k] = 0;
		theQueue = new Queue();
		theStack = new Stack<>();
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public void bfs() {
		// BFS involves searching a node and it's siblings before going to any children.
		// begin at vertex 0
		vertexList[0].wasVisited = true;
		displayVertex(0);
		theQueue.insert(0);
		int v2;

		while (!theQueue.isEmpty()) // until queue empty,
		{
			int v1 = theQueue.remove(); // remove vertex at head
			// until it has no unvisited neighbors
			while ((v2 = getAdjUnvisitedVertex(v1)) != -1) { // get one,
				vertexList[v2].wasVisited = true; // mark it
				displayVertex(v2); // display it
				theQueue.insert(v2); // insert it
			}
		}

		// queue is empty, so we're done
		for (int j = 0; j < nVerts; j++)
			// reset flags
			vertexList[j].wasVisited = false;
	}

	public void dfs() {
		// DFS involves searching a node and all it's children before proceeding 
		//to its siblings.
		// begin at vertex 0
		vertexList[0].wasVisited = true; // mark it
		displayVertex(0); // display it
		theStack.push(0); // push it

		while (!theStack.isEmpty()) {
			// until stack empty,
			// get an unvisited vertex adjacent to stack top
			int v = getAdjUnvisitedVertex(theStack.peek());
			if (v == -1) // if no such vertex,
				theStack.pop();
			else // if it exists,
			{
				vertexList[v].wasVisited = true; // mark it
				displayVertex(v); // display it
				theStack.push(v); // push it
			}
		}

		// stack is empty, so we're done
		for (int j = 0; j < nVerts; j++)
			// reset flags
			vertexList[j].wasVisited = false;
	}

	public void mst() {
		// minimum spanning tree (depth first)
		// start at 0
		vertexList[0].wasVisited = true; // mark it
		theStack.push(0); // push it

		while (!theStack.isEmpty()) // until stack empty
		{ // get stack top
			int currentVertex = theStack.peek();
			// get next unvisited neighbor
			int v = getAdjUnvisitedVertex(currentVertex);
			if (v == -1) // if no more neighbors
				theStack.pop(); // pop it away
			else // got a neighbor
			{
				vertexList[v].wasVisited = true; // mark it
				theStack.push(v); // push it
				// display edge
				displayVertex(currentVertex); // from currentV
				displayVertex(v); // to v
				System.out.print(" ");
			}
		}

		// stack is empty, so we're done
		for (int j = 0; j < nVerts; j++)
			// reset flags
			vertexList[j].wasVisited = false;
	}

	// returns an unvisited vertex adj to v
	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++)
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		return -1;
	}

	
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4

		theGraph.addEdge(0, 1); // AB
		theGraph.addEdge(1, 2); // BC
		theGraph.addEdge(0, 3); // AD
		theGraph.addEdge(3, 4); // DE

		System.out.print("BFS Visits: ");
		theGraph.bfs(); // breadth-first search
		System.out.println();

		System.out.print("DFS Visits: ");
		theGraph.dfs(); // depth-first search
		System.out.println();

		System.out.print("Minimum spanning tree: ");
		theGraph.mst(); // minimum spanning tree
		System.out.println();
		
	}
}
