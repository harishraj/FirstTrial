package path;

class DistPar {
	// distance and parent 
	// items stored in sPath array
	public int distance; // distance from start to this vertex
	public int parentVert; // current parent of this vertex

	public DistPar(int pv, int d) {
		distance = d;
		parentVert = pv;
	}
}
