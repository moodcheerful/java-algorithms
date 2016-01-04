package utils;

import java.util.ArrayList;
import java.util.List;

/**
 *  A directed graph of vertices named 0 through N - 1. 
 *  Parallel edges and self-loops are NOT allowed.
 *  The implementation uses an adjacency list (an arraylist of lists), 
 *  in which each edge is listed only once.
 * 
 *  An example of a directed acyclical graph (DAG) with 13 vertices, 15 edges:
 *  
 *  The list of edges:
 *  
 *    2 0
 *    0 5 
 *    0 1 
 *    2 3 
 *    11 12  
 *    9 11 
 *    9 10  
 *    9 12
 *    3 5 
 *    8 7 
 *    5 4 
 *    0 6 
 *    6 9 
 *    6 4 
 *    7 6
 *    
 *    Corresponding adjacency List (each edge listed only once):
 *      
 *    0: 5 1 6
 *    1: 
 *    2: 0 3 
 *    3: 5 
 *    4: 
 *    5: 4 
 *    6: 9 4
 *    7: 6
 *    8: 7
 *    9: 11 10 12
 *    10: 
 *    11: 12 
 *    12:   
 *  
 *  Topological order:
 *  
 *           |------------------------->|
 *           |  |---------------------->|
 *           |  |------------------->|  |
 *  8->7  2->3  0->6->9->10  11->12  1  5->4
 *     |  |---->|  |  |----->|   |         |
 *     |---------->|  |--------->|         |
 *                 |---------------------->|
 *                  
 */

public class DirectedGraph {

	private int N;
	private List<List<Integer>> adjacencyList;

	// construct a directed graph of N vertices from the list of edges:
	public DirectedGraph(int N, List<List<Integer>> edgesList) {

		this.N = N;

		// initialize a new adjacency list of size N:
		this.adjacencyList = new ArrayList<List<Integer>>(N);
		for (int v = 0; v < N; v++) {
			this.adjacencyList.add(new ArrayList<Integer>());
		}

		// add each edge from edgesList to the adjacency list only once:
		for (List<Integer> pair : edgesList) {
			int v = pair.get(0);
			int w = pair.get(1);
			addEdge(v, w);
		}
	}

	// throw an IndexOutOfBoundsException unless 0 <= v < N
	private void validateVertex(int v) {
		if (v < 0 || v >= N) {
			throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (N - 1));
		}
	}

	// add the directed edge v->w to the graph:
	public void addEdge(int v, int w) {
		validateVertex(v);
		validateVertex(w);
		adjacencyList.get(v).add(w);
	}

	// return the number of vertices in the directed graph:
	public int getN() {
		return N;
	}

	// return the vertices adjacent from vertex v in the directed graph:
	public List<Integer> adjacentVertices(int v) {
		validateVertex(v);
		return adjacencyList.get(v);
	}

	// return the number of directed edges from vertex v:
	public int outdegree(int v) {
		validateVertex(v);
		return adjacencyList.get(v).size();
	}

	// return a string representation of the directed graph in O(N + M) time:
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
