# Mockito Mocking Framework

## What is Mockito?
**Mockito** is an open-source Java mocking framework used in unit testing to isolate the class under test from its external dependencies (such as databases, REST APIs, or payment gateways) by creating dummy mock implementations.

---

## Why Mocking is Necessary in TDD
In true **Unit Testing**, you must test a single class (`OrderService`) in complete isolation. If `OrderService` depends on `PaymentGateway`, connecting to a real credit card processing network during local unit tests would cause tests to fail without internet access, run slowly, or accidentally charge real credit cards! Mockito replaces `PaymentGateway` with a mock object under developer control.

---

## Advantages
- **Complete Test Isolation:** Pinpoints exact failure locations without worrying about downstream database outages or network latency.
- **Deterministic Edge-Case Simulation:** Easily simulate rare network failures, HTTP 500 server crashes, or database connection timeouts using `when().thenThrow()`.
- **Behavior Verification:** Verify how many times a dependency method was called using `verify(mock, times(1)).process()`.

---

## Disadvantages
- **Over-Mocking:** If you mock internal data models or utility classes instead of just external boundaries, tests become fragile and tied to implementation details rather than business behavior.
- **False Sense of Security:** Mock unit tests might pass 100%, but the application can still fail in production due to real SQL syntax errors or schema mismatches (which requires Integration Testing to catch).

---

## Real World Example
- **E-Commerce Order Checkout:** When testing `OrderService.placeOrder(orderId, amount)`, Mockito stubs the `PaymentGateway` dependency:
  `when(paymentGatewayMock.processPayment("ORD-101", 2500.00)).thenReturn(true);`
  This allows testing the order confirmation workflow instantly without calling a real HDFC or ICICI bank API server.

---

## Interview Questions

### Q1: What is the difference between `@Mock` and `@Spy` in Mockito?
**Answer:** 
- `@Mock`: Creates a complete dummy skeleton. All methods return default values (`null`, `0`, `false`) unless explicitly stubbed using `when().thenReturn()`. No real code from the mocked class executes.
- `@Spy`: Wraps a **real existing object**. When you call methods on a spy, the *actual real implementation executes* unless you explicitly stub that specific method using `doReturn().when(spy).method()`. Used for partial mocking.

### Q2: Why can't Mockito mock private or static methods by default?
**Answer:** Mockito works by generating a proxy subclass at runtime using dynamic proxies and byte-code manipulation (CGLIB / ByteBuddy) and overriding methods. Since `private` and `static` methods in Java cannot be overridden by subclasses, standard Mockito cannot intercept them. *(Note: Since Mockito 3.4+, inline mock makers allow static method mocking via `mockStatic()`).*
