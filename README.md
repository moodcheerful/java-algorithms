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


##### Array Sorting Algorithms:

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

