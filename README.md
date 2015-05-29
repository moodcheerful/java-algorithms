### Java Algorithms
---

Repo's tree view:

```
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── algorithms
│   │   │   │   ├── BinarySearch.java
│   │   │   │   ├── BreadthFirstSearch.java
│   │   │   │   ├── DepthFirstSearch.java
│   │   │   │   ├── GreatestCommonDivisor.java
│   │   │   │   ├── HeapSort.java
│   │   │   │   ├── KnuthShuffle.java
│   │   │   │   ├── MergeSort.java
│   │   │   │   ├── QuickSort.java
│   │   │   │   └── SelectKthSmallest.java
│   │   │   └── utils
│   │   │       └── Graph.java
│   │   └── resources
│   │       └── log4j.properties
│   └── test
│       └── java
│           └── algorithms
│               ├── BinarySearchTest.java
│               ├── BreadthFirstSearchTest.java
│               ├── DepthFirstSearchTest.java
│               ├── GreatestCommonDivisorTest.java
│               ├── HeapSortTest.java
│               ├── KnuthShuffleTest.java
│               ├── MergeSortTest.java
│               ├── QuickSortTest.java
│               └── SelectKthSmallestTest.java
└── target
```

---

#### Asymptotic Order of Growth (Big O notation):

Description | Order of Growth | Method | Example
:-:|:-:|:-:|:-:
constant | 1 | statement | add 2 numbers; hash table access
logarithmic | log n | divide in half | binary search
linear | n | loop | find the maximum
linearithmic | n log n | divide and conquer | mergesort
quadratic | n^2 | double loop | check all pairs; bubble sort
cubic | n^3 | triple loop | check all triples
exponential | 2^n | exhaustive search | check all subsets
factorial | n! | brute-force | travelling salesman problem solved by brute force

---

#### Array Sorting Algorithms:

- __A Sorting Lower Bound__: every "comparison-based" sorting algorithm has worst-case running time of __Ω(n log n)__.
- __Stable__ sort preserves the relative order of equal keys in the array.
- __Quicksort__ is the fastest general-purpose sort, but it's not stable. 
- __Mergesort__ might be best if stability is important and space is available.
- __Java's system sort__ method `Arrays.sort()` in the `java.util` library is overloaded:
	- for primitive types: quicksort (with 3-way partitioning) - for speed and memory usage
	- for reference types: mergesort with insertion sort after a small size threshold  - for stability and guaranteed performance

Algorithm | Time Complexity | Space Complexity | Stable | Method
:--- |:---:|:---:|:---:|:---:
Quicksort | O(n log(n))	| log(n) | No | Partitioning
Mergesort | O(n log(n)) | n | Yes | Merging
Heapsort | O(n log(n)) | 1 | No | Selection
Insertion Sort | O(n^2) | 1 | Yes | Insertion
Selection Sort | O(n^2) | 1 | No | Selection
Bubble Sort	| O(n^2) | 1 | Yes | Exchanging
Shell Sort | O(n (log(n))^2) | 1 | No | Insertion
Bucket Sort	| O(n+k) | O(n) | Yes | (Non-comparison sort)
Radix Sort | O(nk) | O(n+k) | Yes | (Non-comparison sort)

---





















