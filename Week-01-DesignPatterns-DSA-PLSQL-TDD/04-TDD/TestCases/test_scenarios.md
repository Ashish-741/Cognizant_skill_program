# Test Scenarios & Design Techniques

## 1. Boundary Value Analysis (BVA)
Used to test boundaries between input domains where errors frequently occur.
**Scenario:** Username length must be between 8 and 15 characters.
- **Lower boundary:** 7 chars (Invalid), 8 chars (Valid)
- **Upper boundary:** 15 chars (Valid), 16 chars (Invalid)

## 2. Equivalence Partitioning (EP)
Divides input data into valid and invalid partitions.
**Scenario:** Age verification for employee onboarding (18 to 60 years).
- **Valid Partition:** Age 18 to 60 (e.g., 25, 40)
- **Invalid Partition 1 (Too young):** Age < 18 (e.g., 16)
- **Invalid Partition 2 (Too old):** Age > 60 (e.g., 65)

## 3. Negative Testing Scenarios
- Passing `null` references to core service methods.
- Passing empty or whitespace-only strings where mandatory inputs are required.
- Simulating network failures or database timeouts using Mockito stubs.
