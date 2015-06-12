package algorithms;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

import org.apache.log4j.Logger;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import utils.WeightedDirectedGraph;

public class DijkstraShortestPathTest {
	
	private static final Logger logger = Logger.getLogger(DijkstraShortestPathTest.class);
	
	private static int N;
	private static WeightedDirectedGraph graph;
	
	/*	WeightedDirectedGraph with 8 vertices and 14 edges:
	 *  
	 *  0->1, weight 2
	 *  0->2, weight 5
	 *  0->3, weight 4
	 *  1->2, weight 2
	 *  1->4, weight 7
	 *  1->6, weight 12
	 *  2->3, weight 1
	 *  2->4, weight 4
	 *  2->5, weight 3
	 *  3->5, weight 4
	 *  4->7, weight 5
	 *  5->4, weight 1
	 *  5->7, weight 7
	 *  6->7, weight 3
	 *  
	 */	
	@BeforeClass
	public static void setupBeforeClass() {
		
		N = 8;
		
		List<List<Integer>> edgesList = new ArrayList<List<Integer>>();
				
		edgesList.add(Arrays.asList(0, 1, 2));
		edgesList.add(Arrays.asList(0, 2, 5));
		edgesList.add(Arrays.asList(0, 3, 4));
		edgesList.add(Arrays.asList(1, 2, 2));
		edgesList.add(Arrays.asList(1, 4, 7));
		edgesList.add(Arrays.asList(1, 6, 12));
		edgesList.add(Arrays.asList(2, 3, 1));
		edgesList.add(Arrays.asList(2, 4, 4));
		edgesList.add(Arrays.asList(2, 5, 3));
		edgesList.add(Arrays.asList(3, 5, 4));
		edgesList.add(Arrays.asList(4, 7, 5));
		edgesList.add(Arrays.asList(5, 4, 1));
		edgesList.add(Arrays.asList(5, 7, 7));
		edgesList.add(Arrays.asList(6, 7, 3));

		graph = new WeightedDirectedGraph(N, edgesList);
		logger.info("graph: " + graph);	
	}

	@Test
	public void testDistTo() {
		
		int s = 0;
		int t = 7;
		int expected = 13;
		
		DijkstraShortestPath dijkstra = new DijkstraShortestPath(graph, s);
		
		int result = dijkstra.distTo(t);
				
		Assert.assertEquals(expected, result);
	}

	@Test
	public void testDistToAll() {
		
		int s = 0;
		int[] expected = new int[]{0, 2, 4, 4, 8, 7, 14, 13};
		
		DijkstraShortestPath dijkstra = new DijkstraShortestPath(graph, s);
		
		int[] result = dijkstra.distToAll();
		logger.info("distances from " + s + ": " + Arrays.toString(result));
						
		Assert.assertArrayEquals(expected, result);
	}
	
	@Test
	public void testPathTo() {
		
		int s = 0;
		int t = 7;
		Integer[] expected = new Integer[]{0, 1, 2, 4, 7};

		DijkstraShortestPath dijkstra = new DijkstraShortestPath(graph, s);

		Deque<Integer> result = dijkstra.pathTo(t);
		logger.info("path from " + s + " to " + t + ": " + result);
		
		Assert.assertArrayEquals(expected, result.toArray());
	}
}
