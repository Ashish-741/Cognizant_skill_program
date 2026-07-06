# Software Test Case Design Techniques

## What is Test Case Design?
**Test Case Design Techniques** are structured engineering methodologies used by QA and developers to select a minimal set of highly effective test input data that maximizes bug detection while minimizing redundant testing effort.

---

## Key Methodologies

### 1. Boundary Value Analysis (BVA)
Software bugs frequently occur at the extreme boundaries of input domains rather than in the middle. BVA specifically tests values at, immediately below, and immediately above the allowed boundaries.
- **Example:** Username length must be between 8 and 15 characters.
- **BVA Test Inputs:** 7 chars (Invalid), 8 chars (Valid min), 15 chars (Valid max), 16 chars (Invalid).

### 2. Equivalence Partitioning (EP)
Divides the entire input data domain into distinct logical partitions where the application is expected to behave identically for any value within that partition. You only need to test *one* representative sample from each partition.
- **Example:** Age verification for employment (18 to 60 years).
- **Valid Partition:** Age 18–60 (Test sample: 30).
- **Invalid Partition 1 (Too Young):** Age < 18 (Test sample: 15).
- **Invalid Partition 2 (Too Old):** Age > 60 (Test sample: 65).

---

## Advantages of Structured Test Design
- **Eliminates Redundancy:** Instead of writing 43 random tests for age (testing 19, 20, 21, 22...), EP proves that testing just Age 30 covers the entire valid range.
- **High Defect Yield:** BVA systematically uncovers off-by-one errors (using `<` instead of `<=` in `if` statements).

---

## Disadvantages
- **Does Not Cover Combinatorial Bugs:** BVA and EP evaluate one input field at a time; they may miss bugs caused by complex interactions between multiple fields (which requires Decision Table Testing).

---

## Real World Example
- **Password Strength Validation:** Testing user registration forms by inputting passwords that hit exact character limits (8 chars, 64 chars), testing blank spaces, and checking special symbol partitions.

---

## Interview Questions

### Q1: What is the difference between Black-Box and White-Box testing?
**Answer:**
- **Black-Box Testing (Functional Testing):** The tester evaluates the application strictly through its external interfaces and inputs/outputs without seeing or knowing the internal source code. BVA and EP are Black-Box techniques.
- **White-Box Testing (Structural Testing):** The tester inspects internal source code, branches, loops, and conditions to write unit tests ensuring high code coverage (e.g., Statement Coverage, Branch Coverage). JUnit unit tests are White-Box testing.

### Q2: What is the Test-Driven Development (TDD) cycle?
**Answer:** TDD follows the **Red-Green-Refactor** loop:
1. **Red:** Write a unit test for a new feature *before* writing the implementation code. Run the test and watch it fail (Red).
2. **Green:** Write the minimal amount of production code required to make the failing test pass (Green).
3. **Refactor:** Clean up code duplication, improve naming, and optimize performance while ensuring all tests continue to pass.
