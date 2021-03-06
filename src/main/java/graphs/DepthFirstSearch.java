package graphs;

import utils.Graph;

/**
 *  Depth First Search of the vertices in an undirected graph
 *  that are connected to a given source vertex s.
 *  
 *  Time complexity is O(N + M),
 *  where N is the number of vertices and M is the number of edges.
 *  
 *  Space complexity is O(N) (not including the graph).
 */
public class DepthFirstSearch {
	
	// visited[v] = true if there is a path from s to v:
	private boolean[] visited;
	
	// number of vertices connected to the source vertex s:
	private int count;
	
	// compute the vertices that are connected to the source vertex s:
	public DepthFirstSearch(Graph graph, int s) {
				
		visited = new boolean[graph.getN()];
		count = 0;
		
		dfs(graph, s);
	}
	
	// recursive depth first search from the vertex s:
	public void dfs(Graph graph, int s) {
		
		visited[s] = true;
		count++;
		
		for (int v: graph.adjacentVertices(s)) {
			
			if (!visited[v]) {
				
				//recursive call:
				dfs(graph, v);
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
