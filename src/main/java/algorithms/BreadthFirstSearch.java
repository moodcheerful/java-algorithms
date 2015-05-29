package algorithms;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;

import org.apache.log4j.Logger;

import utils.Graph;

/**
 * Breadth First Search algorithm of finding shortest paths
 * from a start vertex s to every other vertex in an undirected graph.
 * 
 * Time complexity is O(N + M),
 * where N is the number of vertices and M is the number of edges.
 */
public class BreadthFirstSearch {
	
	public static final Logger logger = Logger.getLogger(BreadthFirstSearch.class);
	
	// visited[v]: is there a path from the start vertex s to v
	private boolean[] visited; 
	
	// distTo[v]: number of edges of the shortest path from the start vertex s to v
	private int[] distTo; 
	
	// edgeTo[v]: previous edge on the shortest path from the start vertex s to v
	private int[] edgeTo; 
	
	// compute the shortest path from the start vertex s to 
	// every other vertex in the graph
	public BreadthFirstSearch(Graph graph, int s) {
		
		int N = graph.getN();
        if (s < 0 || s >= N) {
        	throw new IndexOutOfBoundsException("vertex " + s + " is not between 0 and " + (N - 1));
        }
		visited = new boolean[N];
		distTo = new int[N];
		edgeTo = new int[N];
		
		bfs(graph, s);
	}

	// Breadth First Search from the start vertex s
	private void bfs(Graph graph, int s) {

		// base case for start vertex s:
		visited[s] = true;
		distTo[s] = 0;
		for (int v = 1; v < graph.getN(); v++) {
			distTo[v] = Integer.MAX_VALUE;
		}

		// FIFO data structure, initialized with s:
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.offer(s);
		
		while (!q.isEmpty()) {
			
			// remove the first vertex from the queue:
			int v = q.poll();
			
			//for each edge v-w:
			for (int w : graph.adjacentVertices(v)) {
				
				// if vertex w hasn't been explored yet:
				if (!visited[w]) {

					visited[w] = true;
					distTo[w] = distTo[v] + 1;
					edgeTo[w] = v;
					
					// add w to the end of the queue
					q.offer(w);
				}
			}
		}
	}
	
    // return true if there is a path from the start vertex s to v:
	public boolean hasPathTo(int v) {
		return visited[v];
	}

    // return the number of edges in a shortest path from the start vertex s to v:
	public int distTo(int v) {
		return distTo[v];
	}

    // return a shortest path from the start vertex s to v, or null if there is no path:
	public Deque<Integer> shortestPathTo(int v) {
		
		if (!hasPathTo(v)) {
			return null;
		}
		// LIFO data structure:
		Deque<Integer> path = new ArrayDeque<Integer>();

		int x = v;
		while (distTo[x] != 0) {
			
			x = edgeTo[x];
			path.addFirst(x);
		}
		return path;
	}
	
    // return a string representation of the shortest paths from the start vertex s;
	// runs in O(N + M) time
	public String printPaths(Graph graph, int s) {
		
		StringBuilder sb = new StringBuilder();		
		String NEWLINE = System.getProperty("line.separator");
		
		for (int v = 0; v < graph.getN(); v++) {
			
			if (this.hasPathTo(v)) {				
				sb.append(NEWLINE + s + " to " + v + ": distance = " + this.distTo(v));				
				if (v != s) {				
					sb.append("; shortest path = " + this.shortestPathTo(v));				
				}
			} else {
				sb.append(NEWLINE + s + " to " + v + ": not connected");
			}
		}
		sb.append(NEWLINE);	
		return sb.toString();
	}
}
