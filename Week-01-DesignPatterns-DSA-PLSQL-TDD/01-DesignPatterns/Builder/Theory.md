# Builder Design Pattern

## What is Builder?
The **Builder Pattern** is a creational design pattern that allows step-by-step construction of complex objects. It separates the construction of a complex object from its representation, enabling the same construction process to create different representations.

---

## Advantages
- **Readable & Expressive Code:** Eliminates telescoping constructor anti-pattern (constructors with endless lists of parameters).
- **Immutability:** The target class (`Computer`) can have all private final fields and no setter methods, guaranteeing thread safety and immutability after construction.
- **Parameter Validation:** You can validate complex parameter combinations inside the `build()` method before creating the final object.

---

## Disadvantages
- **Verbose Boilerplate:** Requires duplicating all fields from the target class inside the static nested `Builder` class.
- **Slight Memory Overhead:** Creates an intermediate builder object in memory before generating the final product.

---

## Real World Example
- **PC Customizer:** When configuring a custom workstation, users pick mandatory components (RAM, CPU, HDD) and optional peripherals (Graphics Card, Bluetooth, RGB lighting). The `ComputerBuilder` lets you specify only the desired options fluently: `.setBluetoothEnabled(true).build()`.
- **Java `StringBuilder` & `HttpClient.Builder`:** Standard Java libraries frequently use builders to configure HTTP requests or manipulate strings efficiently.

---

## Interview Questions

### Q1: How does the Builder pattern differ from the Factory pattern?
**Answer:** The **Factory pattern** is used when object creation is a single-step process and you want polymorphism (returning different subclasses of an interface). The **Builder pattern** is used when constructing a single complex object requires a multi-step configuration process with many optional parameters.

### Q2: Why do we make the `Builder` class static and nested inside the target class?
**Answer:** Making it **nested** allows the `Builder` to access the private constructor of the outer target class, preventing external code from bypassing the builder. Making it **static** allows clients to instantiate the builder without needing an existing instance of the outer class (`new Computer.ComputerBuilder(...)`).
