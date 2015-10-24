package algorithms;

import java.util.Deque;

import utils.DirectedGraph;

/**
 * Compute topological order of a directed acyclic graph (DAG).
 * 
 * Assume there is NO directed cycle: a directed graph has a topological order if and only if it is
 * a DAG.
 * 
 * This implementation uses depth-first search.
 * 
 * Time complexity is O(N + M), where N is the number of vertices and M is the number of edges.
 */
public class TopologicalSort {

	// topological order:
	private Deque<Integer> order;

	// find a topological order of the DAG:
	public TopologicalSort(DirectedGraph dag) {

		DirectedGraphOrder dfs = new DirectedGraphOrder(dag);
		order = dfs.reversePostorder();
	}

	// return a topological order of the vertices for a DAG:
	public Deque<Integer> order() {
		return order;
	}
}
