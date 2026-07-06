# Sorting Algorithms

## What is Sorting?
**Sorting Algorithms** rearrange elements of a list or array into a specific logical order (numerical ascending/descending or lexicographical alphabetical order). Efficient sorting is crucial for optimizing subsequent search and merge operations.

---

## Key Algorithms & Complexities

| Algorithm | Best Case | Average Case | Worst Case | Space Complexity | Stability |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Bubble Sort** | $O(N)$ | $O(N^2)$ | $O(N^2)$ | $O(1)$ | Stable |
| **Selection Sort**| $O(N^2)$ | $O(N^2)$ | $O(N^2)$ | $O(1)$ | Unstable |
| **Insertion Sort**| $O(N)$ | $O(N^2)$ | $O(N^2)$ | $O(1)$ | Stable |
| **Merge Sort** | $O(N \log N)$ | $O(N \log N)$| $O(N \log N)$| $O(N)$ | Stable |
| **Quick Sort** | $O(N \log N)$ | $O(N \log N)$| $O(N^2)$ | $O(\log N)$ stack | Unstable |
| **Heap Sort** | $O(N \log N)$ | $O(N \log N)$| $O(N \log N)$| $O(1)$ | Unstable |

---

## Advantages of Efficient Sorting
- **Enables Binary Search:** Transforms search complexities from $O(N)$ linear scans to $O(\log N)$.
- **Data Deduplication:** Finding duplicates in a sorted array takes $O(N)$ single-pass comparisons by checking adjacent elements.

---

## Disadvantages / Trade-offs
- **Quick Sort Worst Case:** If the chosen pivot is consistently the smallest or largest element (e.g., sorting an already sorted array using the last element as pivot), Quick Sort degrades to $O(N^2)$.
- **Merge Sort Space Overhead:** Merge Sort requires $O(N)$ auxiliary heap memory to merge sub-arrays, making it less ideal for memory-constrained embedded systems compared to Quick Sort or Heap Sort.

---

## Real World Example
- **E-Commerce Product Catalogs:** Sorting millions of products by Price (Low to High), Customer Rating, or Newest Arrivals in real-time.
- **Java TimSort (`Arrays.sort()` for Objects):** Java uses **TimSort** (a hybrid of Merge Sort and Insertion Sort) for sorting object arrays because it is **Stable** and achieves $O(N)$ performance on real-world data that is already partially sorted.

---

## Interview Questions

### Q1: What does it mean for a sorting algorithm to be "Stable"? Why does it matter?
**Answer:** A sorting algorithm is **Stable** if two objects with equal keys retain their relative original order in the sorted output. For example, if you sort a list of employees first by *Department*, and then sort them by *Salary* using a stable sort, employees with identical salaries will still remain grouped by their Department. Unstable sorts (like Quick Sort) scramble identical keys.

### Q2: Why is Quick Sort preferred over Merge Sort for arrays, but Merge Sort is preferred for Linked Lists?
**Answer:** 
- **For Arrays:** Quick Sort is an in-place sort ($O(1)$ heap space) and has excellent **CPU cache locality** because it scans contiguous memory blocks. Merge Sort requires allocating $O(N)$ extra memory arrays.
- **For Linked Lists:** Linked lists do not have random index access, making Quick Sort's partitioning slow. Merge Sort accesses elements sequentially without random jumps and can merge two linked lists without allocating extra nodes (just rearranging pointers), making it $O(1)$ auxiliary space for lists!
