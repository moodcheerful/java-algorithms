package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;

import utils.Graph;

public class DepthFirstSearchTest {
	
	public static final Logger logger = Logger.getLogger(DepthFirstSearchTest.class);
	
	private static List<Set<Integer>> adjacencyList;
	private static Graph graph;
	
	@BeforeClass
	public static void setupBeforeClass() {
		
		/**
		 *  An undirected graph implemented using an adjacency list (an arraylist of sets)
		 *  8 vertices, 9 edges:
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
		 *     0 
		 *   / | \ 
		 *  |  1 ─ 2
		 *  |      | \
		 *  5 ──── 3 ─ 4
		 *  	
		 *  6 ─ 7
		 *  
		 */
		
		Set<Integer> set0 = new HashSet<Integer>(Arrays.asList(5, 1, 2));
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(2, 0));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(4, 3, 1, 0));
		Set<Integer> set3 = new HashSet<Integer>(Arrays.asList(2, 4, 5));
		Set<Integer> set4 = new HashSet<Integer>(Arrays.asList(2, 3));
		Set<Integer> set5 = new HashSet<Integer>(Arrays.asList(0, 3));
		Set<Integer> set6 = new HashSet<Integer>(Arrays.asList(7));
		Set<Integer> set7 = new HashSet<Integer>(Arrays.asList(6));

		adjacencyList = new ArrayList<Set<Integer>>();
		
		Collections.addAll(adjacencyList, set0, set1, set2, set3, set4, set5, set6, set7);
		
		graph = new Graph(adjacencyList);
		
		logger.info("adjacencyList: " + adjacencyList);	
		logger.info("graph: " + graph);		
	}

	@Test
	public void testDFS() {
		
		int s = 0;
		DepthFirstSearch dfs = new DepthFirstSearch(graph, s);

		logger.info(dfs.printConnected(graph, s));
		
		// number of vertices connected to the source vertex s:
		int expected = 6;
		
		Assert.assertEquals(expected, dfs.count());
		
	}
}
