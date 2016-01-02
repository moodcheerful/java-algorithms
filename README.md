## :fire: :+1: :interrobang: Common CS Algorithms :interrobang: :+1: :fire: </br> implemented in Java and tested in JUnit 

##### :evergreen_tree: Repo's tree view and :hourglass: Algorithms' time complexities:

```
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── algorithms
│   │   │   │   ├── BinarySearch.java ----------------------- O(log n)
│   │   │   │   ├── BitwiseOperations.java ------------------ O(1)
│   │   │   │   ├── BreadthFirstSearch.java ----------------- O(V + E)
│   │   │   │   ├── DecimalToBinary.java -------------------- O(1)
│   │   │   │   ├── DepthFirstSearch.java ------------------- O(V + E)
│   │   │   │   ├── DepthFirstSearchNonRecursive.java ------- O(V + E)
│   │   │   │   ├── DijkstraShortestPath.java --------------- O(E log V)
│   │   │   │   ├── DirectedGraphOrder.java ----------------- O(V + E)
│   │   │   │   ├── DynamicProgrammingCheckerboard.java ----- O(n^2)
│   │   │   │   ├── GreatestCommonDivisor.java -------------- O((log min(a, b))^2)
│   │   │   │   ├── HeapSort.java --------------------------- O(n log n)
│   │   │   │   ├── KnuthShuffle.java ----------------------- O(n)
│   │   │   │   ├── LZWCompression.java --------------------- O(n)
│   │   │   │   ├── MaintainingMedian.java ------------------ O(log i)
│   │   │   │   ├── MarkovChainPageRank.java ---------------- O(n^2)
│   │   │   │   ├── MergeSort.java -------------------------- O(n log n)
│   │   │   │   ├── Palindrome.java ------------------------- O(n)
│   │   │   │   ├── PrimeSieve.java ------------------------- O(n log(log n))
│   │   │   │   ├── ProbabilityDistributionsContinuous.java - O(1)
│   │   │   │   ├── ProbabilityDistributionsDiscrete.java --- O(n)
│   │   │   │   ├── QuickSort.java -------------------------- O(n log n)
│   │   │   │   ├── RomanToArabic.java ---------------------- O(1)
│   │   │   │   ├── ROT13Cipher.java ------------------------ O(n)
│   │   │   │   ├── SelectKthSmallest.java ------------------ O(n)
│   │   │   │   └── TopologicalSort.java -------------------- O(V + E)
│   │   │   └── utils
│   │   │       ├── DirectedGraph.java
│   │   │       ├── Graph.java
│   │   │       ├── VertexScore.java
│   │   │       ├── WeightedDirectedGraph.java
│   │   │       └── WeightedEdge.java
│   │   └── resources
│   │       └── log4j.properties
│   └── test
│       └── java
│           └── algorithms
│               ├── BinarySearchTest.java
│               ├── BitwiseOperationsTest.java
│               ├── BreadthFirstSearchTest.java
│               ├── DecimalToBinaryTest.java
│               ├── DepthFirstSearchNonRecursiveTest.java
│               ├── DepthFirstSearchTest.java
│               ├── DijkstraShortestPathTest.java
│               ├── DirectedGraphOrderTest.java
│               ├── DynamicProgrammingCheckerboardTest.java
│               ├── GreatestCommonDivisorTest.java
│               ├── HeapSortTest.java
│               ├── KnuthShuffleTest.java
│               ├── LZWCompressionTest.java
│               ├── MaintainingMedianTest.java
│               ├── MarkovChainPageRankTest.java
│               ├── MergeSortTest.java
│               ├── PalindromeTest.java
│               ├── PrimeSieveTest.java
│               ├── ProbabilityDistributionsContinuousTest.java
│               ├── ProbabilityDistributionsDiscreteTest.java
│               ├── QuickSortTest.java
│               ├── RomanToArabicTest.java
│               ├── ROT13CipherTest.java
│               ├── SelectKthSmallestTest.java
│               └── TopologicalSortTest.java
└── target
```

---

#### :arrow_heading_up: Asymptotic Order of Growth (Big O notation):

Description | Order of Growth | Method | Example
:-:|:-:|:-:|:-:
constant | 1 | statement | add 2 numbers; hash table access
logarithmic | log n | divide in half | binary search
linear | n | loop | find the maximum
linearithmic | n log n | divide and conquer | mergesort
quadratic | n<sup>2</sup> | double loop | check all pairs; bubble sort
cubic | n<sup>3</sup> | triple loop | check all triples
exponential | 2<sup>n</sup> | exhaustive search | check all subsets
factorial | n! | brute-force | traveling salesman problem solved by brute force

---

#### :arrows_counterclockwise: Array Sorting Algorithms:

- __A Sorting Lower Bound__: every "comparison-based" sorting algorithm has worst-case running time of __Ω(n log n)__.
- __Stable__ sort preserves the relative order of equal keys in the array.
- __Quicksort__ is the fastest general-purpose sort, but it's not stable.
- __Mergesort__ might be best if stability is important and space is available.
- __Java's system sort__ method `Arrays.sort()` in the `java.util` library is overloaded:
	- for primitive types: quicksort (with 3-way partitioning) - for speed and memory usage
	- for reference types: mergesort with insertion sort after a small size threshold  - for stability and guaranteed performance

Algorithm | Time Complexity | Space Complexity | Stable | Method
:--- |:---:|:---:|:---:|:---:
Quicksort | O(n log(n))	| log n | No | Partitioning
Mergesort | O(n log(n)) | n | Yes | Merging
Heapsort | O(n log(n)) | 1 | No | Selection
Insertion Sort | O(n<sup>2</sup>) | 1 | Yes | Insertion
Selection Sort | O(n<sup>2</sup>) | 1 | No | Selection
Bubble Sort	| O(n<sup>2</sup>) | 1 | Yes | Exchanging
Shell Sort | O(n (log n)<sup>2</sup>) | 1 | No | Insertion
Bucket Sort	| O(n+k) | O(n) | Yes | (Non-comparison sort)
Radix Sort | O(nk) | O(n+k) | Yes | (Non-comparison sort)

---

#### :globe_with_meridians: Graph Algorithms:

- __Breadth-First Search (BFS)__:
	- __O(V+E)__ time complexity using a `queue` (FIFO)
	- explore nodes in "layers"
	- compute shortest paths
	- compute connected components of an undirected graph

- __Depth-First Search (DFS)__:
	- __O(V+E)__ time complexity using a `stack` (LIFO) (or via recursion)
	- explore aggressively like a maze, backtrack only when necessary
	- compute topological ordering of a directed acyclic graph
	- compute connected components in directed graphs

- __Depth-First Orders__ in a directed acyclical graph (__DAG__):
	- Preorder: root, left, right (put the vertex on a queue before the recursive calls)
	- Postorder: left, right, root (put the vertex on a queue after the recursive calls)
	- Reverse postorder: right, left, root
	- Inorder: left, root, right
	- Reverse preorder: root, right, left
	- Reverse inorder: right, root, left
	- Applications:
		- Preorder: copying a binary tree; prefix expression (Polish notation)
		- Inorder: returning values in order, according to the comparator of a binary search tree
		- Postorder: deleting nodes or an entire binary tree; postfix representation (reverse Polish notation)
		- __Reverse postorder__: __topological sort__

- __Topological Sort__:

	- Given a directed graph, put the vertices in order such that all its directed edges point from a vertex earlier in the order to a vertex later in the order.
	- A directed graph has a topological order if and only if it is a directed acyclical graph (DAG).
	- DFS __reverse postorder__ in a DAG is a topological sort.
	- With DFS, topological sort time complexity is __O(V+E)__.
	- Application: sequence tasks while respecting all precedence constraints.

- __Strongly Connected Components__:

	- strongly connected components (SCCs) of a directed graph G are the equivalence classes of the relation:   
	u<->v <==> there exists a path u->v and a path v->u in G
	- __Kosaraju’s Two-Pass Algorithm__ computes SCCs in 2*DFS = __O(V+E)__ time.


- __Dijkstra's Shortest Path algorithm__:

	- computes the shortest path in an __edge-weighted__ directed graph with non-negative weights
	- canonical use of __Heap__ data structure: fast way to do repeated minimum computations
	- time complexity: __O(E log V)__
	- space complexity: __O(V)__

---

#### :gem: Heap (Priority Queue):

- Canonical use of Heap: :moneybag: __fast way to do repeated minimum computations__ - perform Insert, Extract-Min in O(log n) time
- Supported Operations:
	- __Insert: O(log n)__
	- __Extract-Min: O(log n)__ - remove an object with a minimum key value, ties broken arbitrarily
	- Peek: O(1)  
	also :
	- Heapify: O(n) - batch insert n elements
	- Delete: O(log n)
- Conceptually: a perfectly balanced binary tree of height = log n
- __Heap Property__: at every node, key <= children’s keys
- Implementation: array (index starts at 1)
	- children of i = 2i, 2i+1
	- parent of i = [i/2]
	- Extract-Min: swapping up last leaf and then bubbling down
	- Insert: bubbling up from the last leaf
- Applications: sorting, Dijkstra's Shortest Path algorithm, event manager, median maintenance

---

#### :evergreen_tree: Balanced Binary Search Tree:

- Raison d’etre: :moneybag: __like sorted array + fast (logarithmic) inserts and deletes__
- __Search Tree Property__: each node's key > all keys in the node's left subtree, and < all keys in the node's right subtree
- Binary: each node has at most 2 children
- The height of a BST:
	log<sub>2</sub>(n) (best case, balanced) <= height <= n (worst case, a chain)
- Insert a new key k into a tree:
	- search for k (unsuccessfully)
	- rewire final NULL pointer to point to new node with key k
- Search and Insert worst-case running time: Θ(height)
- Delete a key k:
	1. easy case: k’s node has no children
	2. medium case: k’s node has 1 child
	3. difficult case: k’s node has 2 children
- __Balanced Search Tree__:
	- Idea: ensure that height is always best possible: O(log n)
	- then Search / Insert / Delete / Min / Max / Predecessor / Successor will run in __O(log n)__ time
	- Example: red-black trees, AUL trees, splay trees, B trees
- __Red-Black Tree__:
	- Red-Black Tree Invariants:
		1. Each node red or black
		2. Root is black
		3. No 2 reds in a row (red node => only black children)
		4. Every root-null path (like in an unsuccessful search) has same number of black nodes
	- Height Guarantee: every red-black tree with n nodes has a height of O(log n).
	- Time complexity of Search, Insert, Delete in a red-black tree: __O(log n)__.  

Operations / Running Times | Balanced Search Tree | Sorted Array
:--- | :--- | :---
Search | Θ(log n) | Θ(log n)
Select (given order statistic i) | O(log n) | O(1)
Min/Max | O(log n) | O(1)
Predecessor/Successor (given pointer to a key) | O(log n) | O(1)
Rank (# of keys <= a given value) | O(log n) | O(log n)
Output in Sorted Order | O(n) | O(n)
Insert | O(log n) | - (would take Θ(n) time)
Delete | O(log n) | - (would take Θ(n) time)

Also supported by heaps: Select, Insert, Delete  
Also supported by hash tables: Search, Insert, Delete

---
#### :bar_chart: Hash Tables

- Purpose: maintain a (possibly evolving) set of values indexed by key
- Clue to use Hash Table: __repeated lookups (fast constant time)__
- :moneybag: Amazing Guarantee:  
__Insert, Delete, Search__ - all operations in __O(1)__ time, using a key, subject to 2 caveats:
	1. Hash function properly implemented (provides a uniform distribution of hash values)
	2. No worst bound guarantee for pathological data
- Resolving collisions:
   - Solution 1: separate chaining (keep linked list in each bucket)
   - Solution 2: open addressing (only one object per bucket): linear probing, double hashing
- Sample applications: de-duplication, the 2-sum problem, symbol tables in compilers, game tree exploration.
- The Load of a hash table _alpha_ = # of objects in hash table divided by # of buckets of hash table
	- load _alpha_ = O(1) is necessary condition for operations to run in constant time
	- for good Hash Table performance, need to control load
- Pathological Data can paralyze real-world systems by exploiting badly designed open source hash functions. Solutions:
	1. cryptographic hash functions (infeasible to reverse engineer)
	2. randomization ("universal family of hash functions")

---

#### :books: Algorithm Design Paradigms:

- Divide & conquer:
	- Example: Mergesort
	- Master Method, straightforward inductive correctness proof
- Randomized algorithms:
	- Example: Quicksort
- Greedy algorithms:
	- Iteratively make "myopic" locally optimal decisions, hope everything works out at the end.
	- Examples:
		- Dijkstra’s shortest path (process each destination once, irrevocably)
		- Optimal caching (Farthest-in-Future or Least Recently Used algorithm, given the locality of reference)
	- :bomb: Danger: Most greedy algorithms are NOT correct: for example, Dijkstra with negative edge weights.
- Dynamic programming:
	- Main difference from greedy algorithms: After every stage, dynamic programming makes decisions based on all the decisions made in the previous stage, and may reconsider the previous stage's choices.
	- Example: Sequence alignment
