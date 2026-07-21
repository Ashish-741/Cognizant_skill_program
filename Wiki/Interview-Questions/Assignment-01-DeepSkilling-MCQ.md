# Assignment 1: COGNIZANT DIGITAL NURTURE 5.0 — JAVA FSE

## Deep-Skilling MCQ — Practice Question Bank

*Built from the disclosed masterclass topic list (Design Patterns · Spring/Maven/Hibernate · Spring Boot & REST · React · Git · Testing · Core Java · SQL). This is an original practice set.*

---

### Core Java & OOP

**Q1. Which keyword prevents a method from being overridden in a subclass?**
- A. static
- B. final
- C. abstract
- D. private

> **✅ Answer:** B. final
> **Explanation:** `final` on a method blocks overriding; on a class it blocks inheritance.

**Q2. What is the output of `5 / 2` in Java when both operands are `int`?**
- A. 2.5
- B. 2
- C. 3
- D. Compile error

> **✅ Answer:** B. 2
> **Explanation:** Integer division truncates toward zero.

**Q3. Which collection class does NOT allow duplicate elements?**
- A. ArrayList
- B. LinkedList
- C. HashSet
- D. Vector

> **✅ Answer:** C. HashSet
> **Explanation:** `Set` implementations reject duplicates by contract.

**Q4. Which of these is NOT a valid access modifier in Java?**
- A. public
- B. protected
- C. friend
- D. private

> **✅ Answer:** C. friend
> **Explanation:** `friend` is a C++ concept, not Java.

**Q5. What does the 'static' keyword mean when applied to a variable?**
- A. It belongs to each instance separately
- B. It belongs to the class, shared across all instances
- C. It cannot be changed
- D. It is thread-local

> **✅ Answer:** B. It belongs to the class, shared across all instances
> **Explanation:** Static fields are class-level, not per-object.

**Q6. Which interface must a class implement to be used in a for-each loop?**
- A. Comparable
- B. Iterable
- C. Serializable
- D. Cloneable

> **✅ Answer:** B. Iterable
> **Explanation:** `Iterable` provides the `iterator()` that the for-each loop uses.

**Q7. What causes a deadlock in Java threads?**
- A. Too many objects on the heap
- B. Two or more threads waiting on locks the other holds
- C. A single thread running too long
- D. Garbage collection pausing execution

> **✅ Answer:** B. Two or more threads waiting on locks the other holds
> **Explanation:** Circular wait on locks is the classic deadlock condition.

---

### Design Patterns

**Q8. The Singleton pattern ensures:**
- A. Multiple instances can coexist
- B. Only one instance of a class exists with global access
- C. Objects are created via a factory
- D. Classes are decoupled from implementations

> **✅ Answer:** B. Only one instance of a class exists with global access
> **Explanation:** Singleton restricts instantiation to exactly one object.

**Q9. Which pattern is used when you need to create objects without specifying their exact class?**
- A. Observer
- B. Factory
- C. Decorator
- D. Adapter

> **✅ Answer:** B. Factory
> **Explanation:** Factory pattern delegates object creation logic.

**Q10. The Observer pattern is best suited for:**
- A. One-time object creation
- B. Notifying multiple dependents when an object's state changes
- C. Restricting class instantiation
- D. Wrapping incompatible interfaces

> **✅ Answer:** B. Notifying multiple dependents when an object's state changes
> **Explanation:** Observer implements a publish-subscribe relationship.

**Q11. What problem does the Adapter pattern solve?**
- A. Reduces memory usage
- B. Allows incompatible interfaces to work together
- C. Ensures single instantiation
- D. Improves loop performance

> **✅ Answer:** B. Allows incompatible interfaces to work together
> **Explanation:** Adapter converts one interface into another expected by the client.

**Q12. Which pattern adds new behavior to an object dynamically without altering its class?**
- A. Decorator
- B. Singleton
- C. Builder
- D. Proxy

> **✅ Answer:** A. Decorator
> **Explanation:** Decorator wraps objects to add responsibilities at runtime.

**Q13. The Builder pattern is most useful when:**
- A. An object has many optional constructor parameters
- B. You need only one instance
- C. Two classes are incompatible
- D. You want lazy initialization

> **✅ Answer:** A. An object has many optional constructor parameters
> **Explanation:** Builder avoids telescoping constructors for complex objects.

---

### Spring Core, Maven & Hibernate

**Q14. What is Dependency Injection in Spring?**
- A. A way to inject SQL queries
- B. A design pattern where objects receive dependencies rather than creating them
- C. A Maven plugin
- D. A Hibernate caching strategy

> **✅ Answer:** B. A design pattern where objects receive dependencies rather than creating them
> **Explanation:** DI is the core IoC mechanism Spring is built around.

**Q15. In Maven, which file defines project dependencies and build configuration?**
- A. web.xml
- B. pom.xml
- C. build.gradle
- D. application.properties

> **✅ Answer:** B. pom.xml
> **Explanation:** `pom.xml` (Project Object Model) is Maven's core config file.

**Q16. What does the Hibernate 'session' represent?**
- A. A database connection pool
- B. A single unit of work between the application and the database
- C. A REST endpoint
- D. A Spring bean scope

> **✅ Answer:** B. A single unit of work between the application and the database
> **Explanation:** A Session wraps a JDBC connection for one unit of work.

**Q17. Which Spring annotation marks a class as a Spring-managed bean generically?**
- A. @Controller
- B. @Repository
- C. @Component
- D. @Service

> **✅ Answer:** C. @Component
> **Explanation:** `@Component` is the generic stereotype; the others are specializations of it.

**Q18. What is Hibernate's first-level cache scoped to?**
- A. The entire application
- B. The Session
- C. The SessionFactory
- D. The database

> **✅ Answer:** B. The Session
> **Explanation:** First-level cache is Session-scoped and enabled by default.

**Q19. What Maven command compiles and packages a project into a JAR/WAR?**
- A. mvn clean
- B. mvn install
- C. mvn package
- D. mvn validate

> **✅ Answer:** C. mvn package
> **Explanation:** `mvn package` builds the artifact; `install` also copies it to the local repo.

---

### Spring Boot & Spring REST

**Q20. What is the main advantage of Spring Boot over plain Spring?**
- A. It removes the need for Java
- B. Auto-configuration and embedded servers reduce boilerplate setup
- C. It replaces Hibernate entirely
- D. It only works with MongoDB

> **✅ Answer:** B. Auto-configuration and embedded servers reduce boilerplate setup
> **Explanation:** Spring Boot's core value is convention-over-configuration and starters.

**Q21. Which annotation combines @Controller and @ResponseBody?**
- A. @RestController
- B. @Service
- C. @Repository
- D. @Configuration

> **✅ Answer:** A. @RestController
> **Explanation:** `@RestController` returns response bodies directly, no view resolution.

**Q22. Which annotation is used to inject values from application.properties?**
- A. @Autowired
- B. @Value
- C. @Bean
- D. @Qualifier

> **✅ Answer:** B. @Value
> **Explanation:** `@Value` reads a property placeholder into a field.

**Q23. What HTTP method does @PostMapping correspond to?**
- A. GET
- B. POST
- C. PUT
- D. DELETE

> **✅ Answer:** B. POST
> **Explanation:** `@PostMapping` is a shortcut for `@RequestMapping(method = POST)`.

**Q24. What does @Autowired do?**
- A. Marks a class as an entity
- B. Automatically injects a matching Spring bean
- C. Starts the embedded server
- D. Configures the database URL

> **✅ Answer:** B. Automatically injects a matching Spring bean
> **Explanation:** It resolves and injects a dependency by type (or qualifier).

**Q25. Which starter dependency would you add for building REST APIs in Spring Boot?**
- A. spring-boot-starter-data-jpa
- B. spring-boot-starter-web
- C. spring-boot-starter-test
- D. spring-boot-starter-security

> **✅ Answer:** B. spring-boot-starter-web
> **Explanation:** `starter-web` brings in Spring MVC and an embedded Tomcat.

---

### React

**Q26. What is JSX?**
- A. A CSS preprocessor
- B. A syntax extension letting you write HTML-like code in JavaScript
- C. A state management library
- D. A testing framework

> **✅ Answer:** B. A syntax extension letting you write HTML-like code in JavaScript
> **Explanation:** JSX compiles to `React.createElement` calls.

**Q27. Which hook is used to manage state in a functional component?**
- A. useEffect
- B. useState
- C. useContext
- D. useRef

> **✅ Answer:** B. useState
> **Explanation:** `useState` returns a state value and setter for functional components.

**Q28. What triggers a React component to re-render?**
- A. Changing a local variable
- B. A change in state or props
- C. Refreshing the browser only
- D. Calling console.log

> **✅ Answer:** B. A change in state or props
> **Explanation:** React re-renders on state/prop changes via its reconciliation process.

**Q29. What is the purpose of useEffect?**
- A. To define component styling
- B. To perform side effects like data fetching after render
- C. To create new components
- D. To bind event listeners only on click

> **✅ Answer:** B. To perform side effects like data fetching after render
> **Explanation:** `useEffect` handles side effects tied to the component lifecycle.

**Q30. In React, what are 'props'?**
- A. Internal mutable state
- B. Read-only data passed from parent to child components
- C. CSS class names
- D. Lifecycle methods

> **✅ Answer:** B. Read-only data passed from parent to child components
> **Explanation:** Props flow one-way, parent to child, and are immutable within the child.

**Q31. What does the virtual DOM primarily improve?**
- A. Security
- B. Rendering performance by minimizing direct DOM updates
- C. Network latency
- D. Database queries

> **✅ Answer:** B. Rendering performance by minimizing direct DOM updates
> **Explanation:** React diffs the virtual DOM and batches minimal real-DOM updates.

---

### Git

**Q32. Which command stages changes for the next commit?**
- A. git commit
- B. git add
- C. git push
- D. git merge

> **✅ Answer:** B. git add
> **Explanation:** `git add` moves changes to the staging area.

**Q33. What does 'git clone' do?**
- A. Creates a new branch
- B. Copies a remote repository to your local machine
- C. Deletes a repository
- D. Merges two branches

> **✅ Answer:** B. Copies a remote repository to your local machine
> **Explanation:** Clone creates a full local copy of a remote repo.

**Q34. Which command shows the commit history?**
- A. git status
- B. git log
- C. git diff
- D. git branch

> **✅ Answer:** B. git log
> **Explanation:** `git log` lists commits in reverse chronological order.

**Q35. What is the difference between 'git merge' and 'git rebase'?**
- A. They are identical
- B. Merge preserves history with a merge commit; rebase rewrites commit history onto a new base
- C. Rebase deletes commits permanently
- D. Merge only works on the main branch

> **✅ Answer:** B. Merge preserves history with a merge commit; rebase rewrites commit history onto a new base
> **Explanation:** Merge creates a merge commit; rebase replays commits linearly.

**Q36. Which command creates and switches to a new branch in one step?**
- A. git branch new-branch
- B. git checkout -b new-branch
- C. git switch old-branch
- D. git merge new-branch

> **✅ Answer:** B. git checkout -b new-branch
> **Explanation:** `-b` flag creates the branch then checks it out.

**Q37. What does 'git pull' do?**
- A. Only fetches remote changes without merging
- B. Fetches and merges remote changes into the current branch
- C. Pushes local commits to remote
- D. Deletes local commits

> **✅ Answer:** B. Fetches and merges remote changes into the current branch
> **Explanation:** `git pull = git fetch + git merge` in one step.

---

### SQL

**Q38. Which query correctly finds the Nth highest salary using LIMIT/OFFSET (MySQL)?**
- A. SELECT salary FROM emp ORDER BY salary ASC LIMIT 1
- B. SELECT DISTINCT salary FROM emp ORDER BY salary DESC LIMIT 1 OFFSET (N-1)
- C. SELECT MAX(salary) FROM emp
- D. SELECT salary FROM emp WHERE salary = N

> **✅ Answer:** B. SELECT DISTINCT salary FROM emp ORDER BY salary DESC LIMIT 1 OFFSET (N-1)
> **Explanation:** DESC order with OFFSET (N-1) skips the top N-1 salaries.

**Q39. What is the key difference between TRUNCATE and DELETE?**
- A. No difference
- B. TRUNCATE is DDL and resets identity/can't be rolled back easily; DELETE is DML and can use WHERE with rollback
- C. DELETE removes the table structure
- D. TRUNCATE only works on views

> **✅ Answer:** B. TRUNCATE is DDL and resets identity/can't be rolled back easily; DELETE is DML and can use WHERE with rollback
> **Explanation:** TRUNCATE is a DDL operation, generally faster and non-selective.

**Q40. Which JOIN returns all rows from both tables, with NULLs where there's no match?**
- A. INNER JOIN
- B. LEFT JOIN
- C. RIGHT JOIN
- D. FULL OUTER JOIN

> **✅ Answer:** D. FULL OUTER JOIN
> **Explanation:** FULL OUTER JOIN combines LEFT and RIGHT JOIN results.

**Q41. What does the GROUP BY clause require when selecting non-aggregated columns?**
- A. Nothing extra
- B. Those columns must appear in the GROUP BY clause
- C. An ORDER BY clause
- D. A subquery

> **✅ Answer:** B. Those columns must appear in the GROUP BY clause
> **Explanation:** SQL requires non-aggregated selected columns to be grouped.

**Q42. What is a primary key constraint?**
- A. Allows duplicate NULLs
- B. Uniquely identifies each row and disallows NULLs
- C. Speeds up only INSERT statements
- D. Is optional in every table

> **✅ Answer:** B. Uniquely identifies each row and disallows NULLs
> **Explanation:** Primary keys enforce uniqueness and NOT NULL.

**Q43. Which clause filters groups after aggregation, unlike WHERE?**
- A. HAVING
- B. WHERE
- C. ORDER BY
- D. GROUP BY

> **✅ Answer:** A. HAVING
> **Explanation:** HAVING filters on aggregated results; WHERE filters rows before grouping.

---

### Testing Tools & Web Basics

**Q44. In JUnit, which annotation marks a method to run before every test case?**
- A. @Test
- B. @BeforeEach
- C. @AfterAll
- D. @Disabled

> **✅ Answer:** B. @BeforeEach
> **Explanation:** `@BeforeEach` runs setup logic before each individual test.

**Q45. What is the primary purpose of Mockito in unit testing?**
- A. To run integration tests only
- B. To create mock objects and isolate the unit under test from dependencies
- C. To manage database migrations
- D. To compile Java code

> **✅ Answer:** B. To create mock objects and isolate the unit under test from dependencies
> **Explanation:** Mockito mocks dependencies so tests focus on one unit's logic.

**Q46. What HTTP status code indicates a successful resource creation via POST?**
- A. 200
- B. 201
- C. 204
- D. 400

> **✅ Answer:** B. 201
> **Explanation:** 201 Created is the standard response for successful resource creation.

**Q47. What's the key difference between GET and POST?**
- A. GET modifies server data, POST retrieves it
- B. GET retrieves data and is idempotent; POST submits data and can change server state
- C. They are functionally identical
- D. POST cannot carry a request body

> **✅ Answer:** B. GET retrieves data and is idempotent; POST submits data and can change server state
> **Explanation:** GET is safe/idempotent for retrieval; POST typically creates/changes state.

**Q48. Which HTML tag is used to create a form?**
- A. \<div>
- B. \<form>
- C. \<input>
- D. \<section>

> **✅ Answer:** B. \<form>
> **Explanation:** `<form>` wraps form controls and defines submission behavior.

**Q49. What does `assertEquals(expected, actual)` do in a JUnit test?**
- A. Logs a warning if values differ
- B. Fails the test if expected and actual values are not equal
- C. Only works with Strings
- D. Skips the test

> **✅ Answer:** B. Fails the test if expected and actual values are not equal
> **Explanation:** It's the core assertion that fails a test on mismatch.
