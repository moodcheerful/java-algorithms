package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import searching.BinarySearchTree;

public class BinarySearchTreeTest {

	private final static Logger logger = Logger.getLogger(BinarySearchTreeTest.class);

	private static BinarySearchTree<Integer> bst;
	private static Integer[] input;

	/*
	 * BinarySearchTree<Integer> bst created from input array: 
	 * { 2, 1, 6, 4, 16, 3, 5, 11, 17, 7, 12, 9, 14 }
	 * 
	 *      2
	 *    /   \
	 *   1     6
	 *       /   \
	 *     4      16
	 *    / \    /   \
	 *   3   5  11    17
	 *        \   \
	 *         7   12
	 *          \    \
	 *           9    14
	 *           
	 */
	@BeforeClass
	public static void setupBeforeClass() {

		input = new Integer[] { 2, 1, 6, 4, 16, 3, 5, 11, 17, 7, 12, 9, 14 };

		bst = new BinarySearchTree<Integer>();
		for (int i = 0; i < input.length; i++) {
			bst.put(input[i]);
		}
		logger.info("input:      " + Arrays.toString(input));
		logger.info("level order: " + bst.levelOrder());
	}

	@Test
	public final void testPut() {

		// assert that all keys are inserted in BST:
		for (int i = 0; i < input.length; i++) {
			Assert.assertTrue(bst.get(input[i]) != null);
		}
		// assert that the BST property is preserved:
		boolean isBST = bst.isBST();
		logger.info("isBST: " + isBST);
		Assert.assertTrue(isBST);
	}

	@Test
	public final void testGet() {

		// assert that search for key in BST returns the key:
		for (int i = 0; i < input.length; i++) {
			Assert.assertEquals(input[i], bst.get(input[i]).getKey());
		}
		// assert that search for key not in BST returns null:
		int keyNotInBST = Integer.MAX_VALUE;
		Assert.assertNull(bst.get(keyNotInBST));
	}

	@Test
	public final void testDelete() {

		// create a list of keys from input array:
		List<Integer> inputKeys = new ArrayList<Integer>();
		for (int i = 0; i < input.length; i++) {
			inputKeys.add(input[i]);
		}

		while (inputKeys.size() != 0) {

			// select a random key to delete:
			Random random = new Random();
			int indexToDelete = random.nextInt(inputKeys.size());
			Integer keyToDelete = inputKeys.get(indexToDelete);
			logger.info("keyToDelete: " + keyToDelete);

			// bst1: create BST from inputKeys, then delete key:
			BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
			for (Integer el : inputKeys) {
				bst1.put(el);
			}
			bst1.delete(keyToDelete);

			// bst2: delete key from inputKeys, then create BST:
			inputKeys.remove(indexToDelete);
			BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
			for (Integer el : inputKeys) {
				bst2.put(el);
			}

			// assert that the BST property in bst1 is preserved:
			boolean isBST = bst1.isBST();
			Assert.assertTrue(isBST);

			// assert that bst1 and bst2 in-order traversals are equal:
			List<Integer> inOrderBst1 = bst1.inOrder();
			List<Integer> inOrderBst2 = bst2.inOrder();
			logger.info("bst1.inOrder(): " + inOrderBst1);
			logger.info("bst2.inOrder(): " + inOrderBst2);
			Assert.assertArrayEquals(inOrderBst1.toArray(), inOrderBst2.toArray());
		}
	}

	@Test
	public final void testInOrder() {

		Integer[] expected = Arrays.copyOf(input, input.length);
		Arrays.sort(expected);

		List<Integer> inOrder = bst.inOrder();

		logger.info("expected inOrder: " + Arrays.toString(expected));
		logger.info("inOrder:          " + bst.inOrder());

		Assert.assertArrayEquals(expected, inOrder.toArray());
	}

	@Test
	public final void testHeight() {

		// expected height of BST (one-node tree has height 0):
		int expected = 5;
		int height = bst.height();
		logger.info("height = " + height + ", expected = " + expected);
		Assert.assertEquals(expected, height);
	}

	@Test
	public final void testFindMin() {

		int expected = Collections.min(Arrays.asList(input));
		int min = bst.findMin();
		logger.info("min = " + min + ", expected = " + expected);
		Assert.assertTrue(expected == min);
	}

	@Test
	public final void testFindMax() {

		int expected = input[0];
		for (int i = 1; i < input.length; i++) {
			if (input[i] > expected) {
				expected = input[i];
			}
		}
		int max = bst.findMax();
		logger.info("max = " + max + ", expected = " + expected);
		Assert.assertTrue(expected == max);
	}

	@Test
	public final void testPredecessor() {

		List<Integer> keysInOrder = bst.inOrder();
		logger.info("keysInOrder = " + keysInOrder);
		int min = bst.findMin();
		int max = bst.findMax();
		int j = 0;
		// test predecessor() for each int from min to max:
		for (int i = min; i < max; i++) {
			Integer predecessor = bst.predecessor(i);
			if (keysInOrder.get(j + 1) <= i) {
				j++;
			}
			Integer expected = keysInOrder.get(j);
			logger.info("i = " + i + ", predecessor = " + predecessor + ", expected = "
					+ expected);
			Assert.assertEquals(expected, predecessor);
		}
		// test endpoints:
		Assert.assertTrue(bst.predecessor(min - 1) == null);
		Assert.assertTrue(bst.predecessor(max + 1) == max);
	}

	@Test
	public final void testSuccessor() {

		List<Integer> keysInOrder = bst.inOrder();
		logger.info("keysInOrder = " + keysInOrder);
		int min = bst.findMin();
		int max = bst.findMax();
		int j = 0;
		// test successor() for each int from min to max:
		for (int i = min; i < max; i++) {
			Integer successor = bst.successor(i);
			if (keysInOrder.get(j) < i) {
				j++;
			}
			Integer expected = keysInOrder.get(j);
			logger.info("i = " + i + ", successor = " + successor + ", expected = "
					+ expected);
			Assert.assertEquals(expected, successor);
		}
		// test endpoints:
		Assert.assertTrue(bst.successor(min - 1) == min);
		Assert.assertTrue(bst.successor(max + 1) == null);
	}
}
