package utils;

import java.util.List;
import java.util.Set;

/**
 *  An undirected graph of vertices named 0 through N - 1. 
 *  Parallel edges and self-loops are NOT allowed.
 *  
 *  The implementation uses an adjacency list (an arraylist of sets).
 *  Example:
 *  
 *  0: 1 2 5 
 *  1: 0 2 
 *  2: 0 1 3 4 
 *  3: 2 4 5 
 *  4: 2 3 
 *  5: 0 3 
 *  6: 7
 *  7: 6
 *  
 *  | ── 0 ── |
 *  |    |    |
 *  |    1 ── 2 ── |
 *  |         |    |
 *  5 ─────── 3 ── 4
 *  	
 *  6 ── 7
 *  
 */
public class Graph {
	
    private int N;
    private List<Set<Integer>> adjacencyList;
    
    // construct a graph from the adjacency list:
	public Graph(List<Set<Integer>> adjacencyList) {
		
        this.N = adjacencyList.size();
		this.adjacencyList = adjacencyList;
    }

    // return the number of vertices in the graph:
    public int getN() {
        return N;
    }

    // return the vertices adjacent to vertex v:
    public Set<Integer> adjacentVertices(int v) {

        if (v < 0 || v >= N) {
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (N-1));
        }
        return adjacencyList.get(v);
    }
    
    // return a string representation of the graph in O(N + M) time:
    @Override
    public String toString() {
    	
        StringBuilder sb = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        sb.append(NEWLINE);
        
        for (int v = 0; v < N; v++) {
            sb.append(v + ": ");
            for (int w : adjacencyList.get(v)) {
                sb.append(w + " ");
            }
            sb.append(NEWLINE);
        }
        return sb.toString();
    }
}
