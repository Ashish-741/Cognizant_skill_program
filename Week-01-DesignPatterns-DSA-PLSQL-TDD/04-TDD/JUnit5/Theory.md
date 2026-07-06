# JUnit 5 Testing Framework

## What is JUnit 5?
**JUnit 5** is the industry-standard unit testing framework for the Java ecosystem. Unlike previous versions, JUnit 5 is composed of three distinct sub-projects:
- **JUnit Platform:** Launches testing frameworks on the JVM.
- **JUnit Jupiter:** Provides the modern programming model and annotations (`@Test`, `@BeforeEach`, `@DisplayName`).
- **JUnit Vintage:** Backward compatibility engine for running older JUnit 4 tests.

---

## Advantages
- **Early Bug Detection:** Catching logical bugs during local unit testing takes minutes, whereas finding them in staging/production costs exponential time and money.
- **Refactoring Confidence:** Developers can clean up legacy code or upgrade library dependencies fearlessly; if all JUnit assertions pass, business logic remains intact.
- **Living Documentation:** Well-named test cases (`testWithdrawInsufficientFundsThrowsException()`) document exactly how a class behaves under valid and edge-case inputs.

---

## Disadvantages
- **Development Time Overhead:** Writing comprehensive unit tests can increase initial feature development time by 30-50%.
- **Maintenance Burden:** When business requirements change, dozens of existing assertions must be updated manually.

---

## Real World Example
- **Banking Transaction Validation:** A `BankAccount` service handles money deposits and withdrawals. JUnit tests simulate valid deposits, edge cases (depositing ₹0), and negative testing (attempting to withdraw more than account balance, verifying that an `IllegalStateException` is thrown).

---

## Interview Questions

### Q1: What is the difference between `@BeforeEach` and `@BeforeAll` in JUnit 5?
**Answer:**
- `@BeforeEach`: Executes before *each individual* `@Test` method in the class. Used to reset fresh test objects (like instantiating a new `BankAccount` before every test to prevent shared state contamination).
- `@BeforeAll`: Executes exactly *once* before any test method runs. Must be declared on a `static` method. Used for expensive global setups (e.g., spinning up an embedded database or initializing database connection pools).

### Q2: How do you test exception throwing in JUnit 5?
**Answer:** Use the `assertThrows()` method, which takes the expected exception class and an executable lambda expression:
```java
Exception exception = assertThrows(IllegalStateException.class, () -> {
    account.withdraw(99999.00);
});
assertEquals("Insufficient balance in account", exception.getMessage());
```
