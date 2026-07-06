# Searching Algorithms

## What is Searching?
**Searching Algorithms** are step-by-step computational procedures designed to locate a specific target element or value within a data structure (such as an array, list, or tree).

---

## Key Algorithms

### 1. Linear Search ($O(N)$ Time, $O(1)$ Space)
Sequentially checks each element of the list until a match is found or the whole list has been searched. Works on both sorted and unsorted arrays.

### 2. Binary Search ($O(\log N)$ Time, $O(1)$ Space)
An efficient Divide and Conquer search algorithm that works **strictly on sorted arrays**. It compares the target value to the middle element of the array. If they are unequal, the half in which the target cannot lie is eliminated, and the search continues on the remaining half until it is found.

---

## Advantages of Binary Search
- **Logarithmic Speed:** Searching a sorted database of 1,000,000 records takes at most **20 comparisons** ($\log_2 1000000 \approx 20$), whereas linear search could take 1,000,000 comparisons.
- **Predictable Performance:** Highly reliable worst-case execution bounds for real-time systems.

---

## Disadvantages of Binary Search
- **Requires Sorted Data:** If data is unsorted, the cost of sorting ($O(N \log N)$) outweighs binary search unless multiple search queries are performed.
- **Random Access Requirement:** Cannot be performed efficiently on standard singly linked lists because finding the middle element requires $O(N)$ sequential traversal.

---

## Real World Example
- **Database B-Tree Indexing:** When querying an employee by `emp_id`, relational database engines use binary search variations across sorted B-Tree index pages to locate disk records instantly without scanning the entire table.
- **IP Routing Tables:** Network routers perform binary search over sorted IP address ranges to determine packet forwarding destinations in milliseconds.

---

## Interview Questions

### Q1: Why do we calculate `mid = low + (high - low) / 2` instead of `(low + high) / 2` in Binary Search?
**Answer:** Using `(low + high) / 2` can cause **Integer Overflow** if `low` and `high` are very large values close to `Integer.MAX_VALUE` ($2^{31}-1$). Their sum would wrap around to a negative number, throwing an `ArrayIndexOutOfBoundsException`. Writing `low + (high - low) / 2` is mathematically identical but guarantees the computation never exceeds `high`.

### Q2: What is the time complexity of searching in a Binary Search Tree (BST)?
**Answer:** In a **balanced** BST (like AVL or Red-Black Tree), the time complexity is **$O(\log N)$**. However, in a **degenerate / skewed** BST (where items were inserted in ascending/descending order without rebalancing, resembling a linked list), the worst-case search time degrades to **$O(N)$**.
