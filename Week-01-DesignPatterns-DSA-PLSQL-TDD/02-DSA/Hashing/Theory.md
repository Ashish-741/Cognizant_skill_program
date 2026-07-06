# Hashing Data Structure

## What is Hashing?
**Hashing** is a technique that maps data of arbitrary size (keys) to fixed-size integer values (hash codes) using a mathematical **Hash Function**. These hash codes serve as array indices in a **Hash Table**, enabling near-instant data retrieval and insertion.

---

## Advantages
- **$O(1)$ Average Time Complexity:** Insertions, deletions, and lookups take constant average time regardless of how large the database grows.
- **Fast Duplicate Detection:** Using a `HashSet`, checking if an item exists or removing duplicates from a dataset takes $O(N)$ total time for $N$ elements.

---

## Disadvantages
- **Hash Collisions:** Two different keys can produce the exact same hash code index. Collisions must be resolved using chaining (linked lists/trees) or open addressing (linear probing).
- **Unordered Data:** Standard Hash Tables do not maintain insertion order or natural sorting order (unlike `TreeSet` or `TreeMap`).
- **Resizing Overhead:** When load factor exceeds threshold (default 0.75 in Java), the internal table capacity doubles, requiring an expensive $O(N)$ **rehashing** operation.

---

## Real World Example
- **Database Caching (Redis / Memcached):** Web servers store frequently accessed user session profiles and API query responses in in-memory key-value hash stores for sub-millisecond retrieval.
- **Password Cryptography (SHA-256 / BCrypt):** User passwords are never stored in plain text. Systems store cryptographic hashes; during login, the input password is hashed and compared against the stored hash.

---

## Interview Questions

### Q1: What is a Hash Collision, and how does Java `HashMap` resolve it?
**Answer:** A collision occurs when two distinct keys generate the exact same bucket index: `hash(key) % capacity`. Java resolves this using **Separate Chaining**:
1. Each bucket stores a Linked List of nodes containing key-value pairs.
2. If collision occurs, the new node is appended to that list.
3. When searching, `HashMap` traverses the list using `.equals(key)` to find the exact match.
4. *Java 8 Optimization:* If a single bucket list exceeds **8 elements**, it transforms into a **Red-Black Tree** ($O(\log N)$ search time).

### Q2: Why must you always override `hashCode()` whenever you override `equals()` in Java?
**Answer:** The Java Object contract mandates that **if two objects are equal according to `.equals()`, they MUST produce the exact same integer `hashCode()`**. If you override `.equals()` without `.hashCode()`, two logically identical objects (e.g., two `Employee` objects with ID 101) will hash to completely different bucket indices in a `HashMap` or `HashSet`. As a result, `map.get(new Employee(101))` will return `null` even if the employee was just stored!
