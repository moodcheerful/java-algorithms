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
│   │   │   │   ├── HeapSort.java
│   │   │   │   ├── KnuthShuffle.java
│   │   │   │   ├── MergeSort.java
│   │   │   │   └── QuickSort.java
│   │   │   └── utils
│   │   └── resources
│   │       └── log4j.properties
│   └── test
│       └── java
│           └── algorithms
│               ├── HeapSortTest.java
│               ├── KnuthShuffleTest.java
│               ├── MergeSortTest.java
│               └── QuickSortTest.java
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
factorial | n! | brute-force search | travelling salesman problem solved by brute force

---

#### Array Sorting Algorithms:

A Sorting Lower Bound: every "comparison-based" sorting algorithm has worst-case running time of Ω(n log n)

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





















