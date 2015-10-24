package utils;

/**
 * The WeightedEdge class represents a weighted edge of a WeightedDirectedGraph. 
 * Each edge consists of two integer vertices and a positive integer weight.
*/
public class WeightedEdge {
	
	private int v;			// tail vertex (from)
	private int w;			// head vertex (to)
	private int weight;		// weight must be > 0
		
	public WeightedEdge(int v, int w, int weight) {
		if (v < 0 || w < 0) {
			throw new IndexOutOfBoundsException("Vertex must be >= 0");
		}
		if (weight <= 0) {
			throw new IndexOutOfBoundsException("Weight must be > 0");
		}
		this.v = v;
		this.w = w;
		this.weight = weight;
	}

	public int getTail() {
		return v;
	}

	public int getHead() {
		return w;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return ("(" + v + "->" + w + ", " + weight + ")");
	}
}
