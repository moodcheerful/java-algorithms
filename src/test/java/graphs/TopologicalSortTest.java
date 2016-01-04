package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import graphs.TopologicalSort;

import utils.DirectedGraph;

public class TopologicalSortTest {
	
	public static final Logger logger = Logger.getLogger(TopologicalSortTest.class);

	/**
	 *  A directed acyclical graph (DAG) with 13 vertices, 15 edges:
	 *  
	 *  The list of edges:
	 *  
	 *  2 0 
	 *  0 5 
	 *  0 1 
	 *  2 3 
	 *  11 12  
	 *  9 11 
	 *  9 10  
	 *  9 12
	 *  3 5 
	 *  8 7 
	 *  5 4 
	 *  0 6 
	 *  6 9 
	 *  6 4 
	 *  7 6
	 * 
	 *  Corresponding adjacency List (each edge listed only once):
	 *  
	 *  0: 5 1 6
	 *  1: 
	 *  2: 0 3 
	 *  3: 5 
	 *  4: 
	 *  5: 4 
	 *  6: 9 4
	 *  7: 6
	 *  8: 7
	 *  9: 11 10 12
	 *  10: 
	 *  11: 12 
	 *  12:  
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
	
	private static DirectedGraph dag;
	private static int N;
	private static List<List<Integer>> edgesList;
	
	@BeforeClass
	public static void setupBeforeClass() {
				
		edgesList = new ArrayList<List<Integer>>();
 
		edgesList.add(Arrays.asList(2, 0));
		edgesList.add(Arrays.asList(0, 5));
		edgesList.add(Arrays.asList(0, 1));
		edgesList.add(Arrays.asList(2, 3));
		edgesList.add(Arrays.asList(11, 12));
		edgesList.add(Arrays.asList(9, 11));
		edgesList.add(Arrays.asList(9, 10));
		edgesList.add(Arrays.asList(9, 12));
		edgesList.add(Arrays.asList(3, 5));
		edgesList.add(Arrays.asList(8, 7));
		edgesList.add(Arrays.asList(5, 4));
		edgesList.add(Arrays.asList(0, 6));
		edgesList.add(Arrays.asList(6, 9));
		edgesList.add(Arrays.asList(6, 4));
		edgesList.add(Arrays.asList(7, 6));

		N = 13;

		dag = new DirectedGraph(N, edgesList);

		logger.info("edgesList: " + edgesList);
		logger.info("graph: " + dag);
	}

	@Test
	public void testTopologicalSort() {

		TopologicalSort ts = new TopologicalSort(dag);

		Integer[] expectedOrder = new Integer[] { 8, 7, 2, 3, 0, 6, 9, 10, 11, 12, 1, 5, 4 };

		Deque<Integer> result = ts.order();
		logger.info("Topological order: " + result);

		Assert.assertArrayEquals(expectedOrder, result.toArray());
	}
}
