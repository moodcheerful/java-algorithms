package utils;

import java.util.List;
import java.util.ArrayList;

import utils.WeightedEdge;

/*
 *  A weighted directed graph of vertices named 0 through N - 1, where each
 *  edge is of type WeightedEdge and has a positive weight.
 *  
 *  Parallel edges and self-loops are NOT allowed.
 *  
 *  The implementation uses an adjacency list (an arraylist of lists), 
 *  in which each edge is listed only once.
 *  
 */
public class WeightedDirectedGraph {
	
	private int N;
	private List<List<WeightedEdge>> adjacencyList;
	
    // construct a directed graph of N vertices from the list of edges:
	public WeightedDirectedGraph(int N, List<List<Integer>> edgesList) {
		
		this.N = N;
		
		// initialize a new adjacency list of size N:
		this.adjacencyList = new ArrayList<List<WeightedEdge>>(N);
		for (int i = 0; i < N; i++) {
			this.adjacencyList.add(new ArrayList<WeightedEdge>());
		}
		
		// add each edge from edgesList to the adjacency list only once:
		for (List<Integer> edge: edgesList) {
			
			int v = edge.get(0);
			int w = edge.get(1);
			int weight = edge.get(2);
			
			validateVertex(v);
			validateVertex(w);
	        if (weight <= 0) {
	        	throw new IndexOutOfBoundsException("Weight must be > 0");
	        } 
	        adjacencyList.get(v).add(new WeightedEdge(v, w, weight));		
		}
	}

	// throw an IndexOutOfBoundsException unless 0 <= v < N
	public boolean validateVertex(Integer v) {
		
		if ((v < 0) || (v >= N)) {
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (N - 1));
		}
		return true;
	}

    // return the number of vertices in the graph:
	public int getN() {
		return N;
	}
	
	// return the vertices adjacent from vertex v in the graph:
	public List<WeightedEdge> adjacent(int v) {
		return adjacencyList.get(v);
	}

    // return a string representation of the graph in O(N + M) time:
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		String NEWLINE = System.getProperty("line.separator");
		sb.append(NEWLINE);
		
        for (int v = 0; v < N; v++) {
            sb.append("Edges from vertex " + v + ": " + NEWLINE);
            for (WeightedEdge edge : adjacencyList.get(v)) {
                sb.append(edge + NEWLINE);
            }
        }
		return sb.toString();		
	}
}
