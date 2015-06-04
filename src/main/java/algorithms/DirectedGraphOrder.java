package algorithms;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
import java.util.ArrayDeque;

import utils.DirectedGraph;

/** 
 * Compute depth-first search ordering of the vertices in a directed acyclical graph (DAG), 
 * including preorder, postorder, and reverse postorder.
 * 
 * Preorder: root, left, right
 * Postorder: left, right, root
 * Inorder: left, root, right
 * Reverse preorder: root, right, left
 * Reverse postorder: right, left, root
 * Reverse inorder: right, root, left
 * 
 * This implementation uses depth-first search.
 * 
 * Time complexity is O(N + M), 
 * where N is the number of vertices and M is the number of edges.
 */
public class DirectedGraphOrder {

	// marked[v] = vertex v has been marked in dfs
	private boolean[] marked;

	// preorder[v] = preorder number of vertex v:
	private int[] preorder;

	// postorder[v] = postorder number of vertex v:
	private int[] postorder;

	// vertices in preorder:
	private Queue<Integer> preorderList;

	// vertices in postorder:
	private Queue<Integer> postorderList;

	// counter for preorder numbering:
	private int preorderCounter;

	// counter for postorder numbering:
	private int postorderCounter;

	// compute a depth-first order for the directed acyclical graph (DAG):
	public DirectedGraphOrder(DirectedGraph dag) {

		// init:
		int N = dag.getN();
		marked = new boolean[N];
		preorder = new int[N];
		postorder = new int[N];
		postorderList = new LinkedList<Integer>();
		preorderList = new LinkedList<Integer>();

		// run dfs for each unmarked vertex:
		for (int v = 0; v < N; v++) {
			if (!marked[v]) {
				dfs(dag, v);
			}
		}
	}

	// run DFS in the directed acyclical graph (DAG) from vertex v 
	// and compute preorder/postorder:
	private void dfs(DirectedGraph dag, int v) {

		marked[v] = true;
		
		// preorder: add the vertex to a queue before the recursive calls:
		preorder[v] = preorderCounter++;
		preorderList.offer(v);
		
		// the recursive calls for each unmarked adjacent vertex:
		for (int w : dag.adjacentVertices(v)) {
			if (!marked[w]) {
				dfs(dag, w);
			}
		}
		
		// postorder: add the vertex to a queue after the recursive calls:
		postorderList.offer(v);
		postorder[v] = postorderCounter++;
	}

	// return the vertices in preorder
	public Queue<Integer> preorder() {
		return preorderList;
	}

	// return the vertices in postorder
	public Queue<Integer> postorder() {
		return postorderList;
	}

	// return the vertices in reverse postorder
	public Deque<Integer> reversePostorder() {
		
		Deque<Integer> reverse = new ArrayDeque<Integer>();
		
		// reverse postorder: put the vertex on a stack after the recursive calls:
		for (int v : postorderList) {
			reverse.push(v);
		}
		return reverse;
	}
}
