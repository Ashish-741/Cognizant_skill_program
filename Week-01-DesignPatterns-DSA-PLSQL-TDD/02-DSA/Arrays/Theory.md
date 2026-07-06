# Arrays Data Structure

## What is an Array?
An **Array** is a linear data structure that stores a collection of elements of the same data type in contiguous memory locations. Each element can be accessed randomly using its numeric index (starting from 0).

---

## Advantages
- **$O(1)$ Random Access:** Finding an element by index takes constant time because memory addresses are calculated using basic pointer arithmetic: `address = base_address + (index * element_size)`.
- **Cache Friendliness:** Because elements are stored in contiguous memory blocks, CPUs can cache entire array chunks efficiently, resulting in high traversal performance.
- **Memory Efficiency:** Minimal memory overhead compared to linked lists (no extra memory needed for storing node pointers).

---

## Disadvantages
- **Fixed Size:** In standard arrays, capacity must be declared at instantiation and cannot be resized dynamically at runtime.
- **Costly Insertions & Deletions:** Inserting or deleting an element at arbitrary positions requires shifting subsequent elements, taking $O(N)$ worst-case time.

---

## Real World Example
- **Image Pixel Processing:** Bitmap images are represented as 2D/3D arrays of RGB color integers where matrix transformations (rotations, filters) operate directly on indexed memory coordinates.
- **Database Index Blocks:** B-Tree nodes and database storage pages organize keys into fixed-size sorted array blocks for fast binary search.

---

## Interview Questions

### Q1: What is the difference between Array and ArrayList in Java?
**Answer:** An **Array** is a fixed-size primitive data structure that can store both primitives (`int`, `char`) and objects. An **ArrayList** is a dynamic collection class from `java.util` that implements the `List` interface, resizes automatically (by creating a new array of 1.5x capacity and copying elements when full), and can only store object wrappers (`Integer`, `Character`).

### Q2: How do you find the second largest element in an array in a single pass ($O(N)$ time)?
**Answer:** Maintain two variables, `largest` and `secondLargest`, initialized to `Integer.MIN_VALUE`. Iterate through the array once:
- If current number `num > largest`, set `secondLargest = largest` and `largest = num`.
- Else if `num > secondLargest` and `num != largest`, set `secondLargest = num`.
This solves the problem in $O(N)$ time and $O(1)$ auxiliary space without sorting.
