package algorithms;

import java.util.Deque;
import java.util.ArrayDeque;

import utils.Graph;

/**
 *  Depth First Search of the vertices in an undirected graph
 *  that are connected to a given source vertex s.
 *  
 *  NON-recursive implementation using a LIFO data structure.
 *  
 *  Time complexity is O(N + M),
 *  where N is the number of vertices and M is the number of edges.
 *  
 *  Space complexity is O(N) (not including the graph).
 */
public class DepthFirstSearchNonRecursive {
	
	// visited[v] = true if there is a path from s to v:
	private boolean[] visited;
	
	// number of vertices connected to the source vertex s:
	private int count;
	
	// compute the vertices that are connected to the source vertex s:
	public DepthFirstSearchNonRecursive(Graph graph, int s) {
				
		visited = new boolean[graph.getN()];
		count = 0;
		
		dfs(graph, s);
	}
	
	// NON-recursive depth first search from the vertex s:
	public void dfs(Graph graph, int s) {
				
		// LIFO data structure, initialized with the source vertex s:
		Deque<Integer> stack = new ArrayDeque<Integer>(graph.getN());
		
		stack.push(s);

		while (!stack.isEmpty()) {
			
			int v = stack.pop();

			// first check if visited, then push adjacent:
			if (!visited[v]) {
				
				visited[v] = true;
				count++;
				
				for (int w: graph.adjacentVertices(v)) {
					
					stack.push(w);
				}
			}
		}
	}

    // return true if there is a path from the source vertex s to v:
    public boolean visited(int v) {
    	
        return visited[v];
    }

    
    // return the number of vertices connected to the source vertex s:
    public int count() {
    	
        return count;
    }
    
    
    // return a string representation of DFS results:
    public String printConnected(Graph graph, int s) {
    	
    	StringBuilder sb = new StringBuilder();
    	String NEWLINE = System.getProperty("line.separator");
    	sb.append(NEWLINE + "Vertices connected to the source vertex " + s + ": " + NEWLINE);
    	
    	for (int v = 0; v < graph.getN(); v++) {
    		
    		if (this.visited[v]) {
    			
    			sb.append(v + " " );
    		}
    	}
    	sb.append(NEWLINE + "Number of vertices connected to the source vertex " + s + ": " + this.count());
    	sb.append(NEWLINE + "Total number of vertices in the graph: " + graph.getN());
    	
    	if (this.count() != graph.getN()) {   		
    		sb.append(NEWLINE + "Graph is NOT connected." + NEWLINE);
    	} else {  		
    		sb.append(NEWLINE + "Graph is connected." + NEWLINE);
    	}
    	return sb.toString();
    }

}
