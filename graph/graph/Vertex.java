package graph;

class Vertex {
	public char label; // label (e.g. 'A')
	public boolean wasVisited;

	public Vertex(char lab) {
		label = lab;
		wasVisited = false;
	}
}
