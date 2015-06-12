package algorithms;

import java.util.Comparator;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Deque;
import java.util.ArrayDeque;

import utils.WeightedDirectedGraph;
import utils.WeightedEdge;
import utils.VertexScore;

/**
 *  Dijkstra's algorithm of computing the shortest paths in weighted directed graphs 
 *  with positive edge weights.
 *  
 *  Time complexity: O(M log N),
 *  where N is the number of vertices and M is the number of edges.
 *  
 *  This implementation uses PriorityQueue as a min-heap.
 *  
 *  Problem: 
 *  
 *  Need the ability to change the priority of a particular vertex in the priority queue.
 *  java.util.PriorityQueue does not resort all elements whenever an element is added or removed: 
 *  doing that would be too expensive because of the O(n*log n) lower bound for comparison sort, 
 *  while PriorityQueue promises to add/remove nodes in O(log n).
 *  
 *  Solution:
 *  
 *  A straightforward idea to decrease the priority key of the vertex already in the queue: 
 *  remove, change key, reinsert the changed element to force PriorityQueue to resift the heap,
 *  but it is too expensive since remove(Object o) takes O(n) - a linear scan over the heap.
 *   
 *  Instead, insert another element for the same vertex into the PriorityQueue, without removing, 
 *  which is slow, and ignore duplicates when polling the queue by keeping a separate array 
 *  with the elements that should have been removed. 
 *  
 *  This implementation assumes a connected sparse graph. 
 *  Path finding graphs are typically planar with a constant average number of neighbors. 
 *  Therefore the size of the PriorityQueue will increase by a constant factor, 
 *  and its height by a constant offset, without increasing the algorithm's running time of O(M log N).
 * 
 */
public class DijkstraShortestPath {

	private WeightedDirectedGraph graph;

	// distTo[v] = distance of shortest s->v path:
	private int[] distTo;
	
	// edgeTo[v] = last edge on shortest s->v path:
	private WeightedEdge[] edgeTo;
	
	// true if Dijkstra greedy score has been calculated:
	private boolean reached[];
	
	// priority queue of vertices not yet reached:
	private Queue<VertexScore> pq;

	public DijkstraShortestPath(WeightedDirectedGraph graph, int s) {

		// initialization:
		this.graph = graph;

		int N = graph.getN();
		distTo = new int[N];
		edgeTo = new WeightedEdge[N];
		reached = new boolean[N];

		for (int i = 0; i < N; i++) {
			distTo[i] = Integer.MAX_VALUE;
		}
		distTo[s] = 0;

		// min HEAP data structure:
		pq = new PriorityQueue<VertexScore>(N, new Comparator<VertexScore>() {

			public int compare(VertexScore x, VertexScore y) {
				return x.getScore() - y.getScore();
			}
		});
		
		// insert the source vertex s into pq:
		pq.offer(new VertexScore(s, distTo[s]));

		// main while loop:
		while (!pq.isEmpty()) {

			// remove the vertex with the minimum Dijkstra greedy score from pq:
			VertexScore x = pq.poll();

			if (!reached[x.getVertex()]) {

				reached[x.getVertex()] = true;

				// for all edges adjacent to the vertex x:
				for (WeightedEdge e : graph.adjacent(x.getVertex())) {

					int v = e.getTail();
					int w = e.getHead();

					// relax edge e and update pq if Dijkstra greedy score of vertex w changed:
					if (distTo[w] > distTo[v] + e.getWeight()) {

						distTo[w] = distTo[v] + e.getWeight();
						edgeTo[w] = e;

						pq.offer(new VertexScore(w, distTo[w]));
					}
				}
			}
		}
	}

	// return the shortest path length from the source vertex s to vertex v:
	public int distTo(int v) {

		graph.validateVertex(v);
		return distTo[v];
	}

	// return the shortest path lengths from the source vertex s to all vertices:
	public int[] distToAll() {
		return distTo;
	}

	// return true if there is a path from the source vertex s to the vertex v:
	public boolean hasPathTo(int v) {

		return (distTo[v] < Integer.MAX_VALUE);
	}

	// return a shortest path from the source vertex s to vertex v:
	public Deque<Integer> pathTo(int v) {

		graph.validateVertex(v);
		if (!hasPathTo(v)) {
			return null;
		}

		Deque<Integer> path = new ArrayDeque<Integer>();

		path.push(v);
		WeightedEdge e = edgeTo[v];

		while (e != null) {

			path.push(e.getTail());
			e = edgeTo[e.getTail()];
		}
		return path;
	}
}
