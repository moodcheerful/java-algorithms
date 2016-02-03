package graphs;

/*
 * Binary Search Tree implementation.
 * 
 * 1. Binary Search Tree is NOT balanced
 * 2. No dublicate keys allowed
 * 
 * Time complexity:
 * 1. get, put, delete, findMin/findMax, predecessor/successor methods: O(height), 
 * where log n <= height <= n, and n is the number of nodes, height is the height of BST.
 * 2. inOrder, levelOrder, height, isBST methods: O(n)
 * 3. building BST: O(n*height), with worst-case time of O(n^2):
 * 
 * If we put into the BST a sorted list of values, it chains them into a linked 
 * list with no left subtrees, constructing an unbalanced degenerate tree,
 * where for each parent node there is only one associated child node, 
 * and its performance degrades to that of a linked list data structure. 
 * 
 * Possible modifications:
 * 1. Implement self-balancing binary search tree.
 * 2. Implement rank and select methods by adding and keeping track of 
 * another variable in put and delete methods: N - number of nodes in subtree.
 * 
 * Sorting applications:
 * 1. BST is not efficient for static list sorting:
 * the added overhead in time and space for a tree-based sort (particularly for node 
 * allocation) makes it inferior to other asymptotically optimal sorts such as heapsort. 
 * 2. BST is efficient for incremental sorting:
 * adding items to a list over time while keeping the list sorted at all times.
 * 
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>> {

	private Node root; // root of BST

	// Node class of BST
	public class Node {

		private Key key; // nodes are sorted by key
		private Node left; // left subtree
		private Node right; // right subtree

		public Node(Key key) {
			this.key = key;
		}

		public Key getKey() {
			return this.key;
		}
	}

	// search BST for a given key and return associated node if found,
	// return null if not found
	public Node get(Key key) {
		return get(root, key);
	}

	private Node get(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int comp = key.compareTo(x.key);
		if (comp < 0) {
			return get(x.left, key);
		} else if (comp > 0) {
			return get(x.right, key);
		} else {
			return x;
		}
	}

	// insert key into BST
	public void put(Key key) {
		root = put(root, key);
	}

	private Node put(Node x, Key key) {
		if (x == null) {
			return new Node(key);
		}
		int comp = key.compareTo(x.key);
		if (comp < 0) {
			x.left = put(x.left, key);
		} else if (comp > 0) {
			x.right = put(x.right, key);
		}
		return x;
	}

	// delete key from BST
	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int comp = key.compareTo(x.key);
		if (comp < 0) {
			x.left = delete(x.left, key);
		} else if (comp > 0) {
			x.right = delete(x.right, key);
		} else {
			if (x.left == null && x.right == null) {
				x = null;
			} else if (x.left == null && x.right != null) {
				x = x.right;
			} else if (x.left != null && x.right == null) {
				x = x.left;
			} else {
				Node successor = findMin(x.right);
				successor.right = deleteMin(x.right);
				successor.left = x.left;
				x = successor;
			}
		}
		return x;
	}

	// delete the minimum key in the tree rooted at Node x
	private Node deleteMin(Node x) {
		if (x == null) {
			return null;
		}
		if (x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		return x;
	}

	// return minimum key in BST
	public Key findMin() {
		if (root == null) {
			return null;
		}
		return findMin(root).key;
	}

	private Node findMin(Node x) {
		if (x == null) {
			return null;
		}
		if (x.left == null) {
			return x;
		} else {
			return findMin(x.left);
		}
	}

	// return maximum key in BST
	public Key findMax() {
		if (root == null) {
			return null;
		}
		return findMax(root).key;
	}

	private Node findMax(Node x) {
		if (x == null) {
			return null;
		}
		if (x.right == null) {
			return x;
		} else {
			return findMax(x.right);
		}
	}

	// return height of BST (one-node tree has height 0)
	public int height() {
		return height(root);
	}

	private int height(Node x) {
		if (x == null) {
			return -1;
		}
		return 1 + Math.max(height(x.left), height(x.right));
	}

	// return largest key from BST that is smaller or equal to a given key
	public Key predecessor(Key key) {
		Node x = predecessor(root, key);
		if (x == null) {
			return null;
		} else {
			return x.key;
		}
	}

	private Node predecessor(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int comp = key.compareTo(x.key);
		if (comp == 0) {
			return x;
		}
		if (comp < 0) {
			return predecessor(x.left, key);
		}
		Node t = predecessor(x.right, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}
	}

	// return smallest key from BST that is larger or equal to a given key
	public Key successor(Key key) {
		Node x = successor(root, key);
		if (x == null) {
			return null;
		} else {
			return x.key;
		}
	}

	private Node successor(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int comp = key.compareTo(x.key);
		if (comp == 0) {
			return x;
		} else if (comp > 0) {
			return successor(x.right, key);
		} else { // if (comp < 0)
			Node temp = successor(x.left, key);
			if (temp != null) {
				return temp;
			} else {
				return x;
			}
		}
	}

	// level order traversal (breadth-first)
	public Queue<Key> levelOrder() {
		Queue<Key> keys = new LinkedList<Key>();
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node x = queue.remove();
			if (x != null) {
				keys.add(x.key);
				queue.add(x.left);
				queue.add(x.right);
			}
		}
		return keys;
	}

	// in-order traversal, returns sorted list of keys
	public List<Key> inOrder() {
		return inOrder(root);
	}

	private List<Key> inOrder(Node x) {
		List<Key> keys = new LinkedList<Key>();
		if (x == null) {
			return keys;
		}
		if (x.left != null) {
			keys.addAll(inOrder(x.left));
		}
		keys.add(x.key);
		if (x.right != null) {
			keys.addAll(inOrder(x.right));
		}
		return keys;
	}

	// validate integrity of BST data structure
	// by checking if the BST property is preserved
	public boolean isBST() {
		return isBST(root, null, null);
	}

	// check if the BST property is preserved
	// (if min or max is null, treat as empty constraint)
	private boolean isBST(Node x, Key min, Key max) {
		if (x == null) {
			return true;
		}
		if (min != null && min.compareTo(x.key) >= 0) {
			return false;
		}
		if (max != null && max.compareTo(x.key) <= 0) {
			return false;
		}
		return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
	}
}
