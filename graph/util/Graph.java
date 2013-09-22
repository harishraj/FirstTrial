package util;

import java.util.ArrayList;
import java.util.List;

//graph node does not have next or left right pointers this thing is controlled 
//by adjacency matrix in Graph
class GNode {

	public Object data;
	public State state;

	public GNode(Object o) {
		data = o;
		state = State.UNVISTED;
	}
}

enum State {
	UNVISTED, VISITED, PROCESSED;
}

public class Graph {
	public GNode root;
	public ArrayList<GNode> nodes = new ArrayList<GNode>();
	public int[][] adjMatrix;
	public final int size;

	public Graph(int size) {
		this.size = size;
		adjMatrix = new int[size][size];
	}

	public void add(Object val) {
		GNode node = new GNode(val);
		nodes.add(node);
	}

	public void connect(GNode a, GNode b) {
		int aIndex = nodes.indexOf(a);
		int bIndex = nodes.indexOf(b);

		if (aIndex == -1 || bIndex == -1)
			return;

		adjMatrix[aIndex][bIndex] = 1;
		adjMatrix[bIndex][aIndex] = 1;
	}

	public void removeConnection(GNode a, GNode b) {
		int aIndex = nodes.indexOf(a);
		int bIndex = nodes.indexOf(b);

		if (aIndex == -1 || bIndex == -1)
			return;

		adjMatrix[aIndex][bIndex] = 0;
		adjMatrix[bIndex][aIndex] = 0;
	}

	public List<GNode> getAdjacents(GNode n) {
		ArrayList<GNode> list = new ArrayList<GNode>();
		int nIdx = nodes.indexOf(n);

		int[] adjacentsOfN = adjMatrix[nIdx];

		for (int i : adjacentsOfN) {
			n = nodes.get(i);
			list.add(n);
		}
		return list;
	}
}