# Assignment 2: Digital Nurture 5.0 — 50-Question Compact Practice Set

*Covers: Design Patterns & SOLID · Spring/Maven/Hibernate · Spring Boot & REST · React · Git · JUnit/Mockito*

---

## Section I: Design Patterns & SOLID

**Q1. Which SOLID principle states that a class should have only one reason to change?**
- A) Open/Closed Principle
- B) Single Responsibility Principle
- C) Liskov Substitution Principle
- D) Interface Segregation Principle

> **✅ Answer:** B) Single Responsibility Principle
> **Explanation:** SRP ensures a class only has one job or responsibility.

**Q2. In Spring, which design pattern is primarily used by the BeanFactory?**
- A) Factory Pattern
- B) Singleton Pattern
- C) Decorator Pattern
- D) Observer Pattern

> **✅ Answer:** A) Factory Pattern
> **Explanation:** BeanFactory is an implementation of the Factory design pattern, creating and managing beans.

**Q3. By default, Spring beans are created using which design pattern?**
- A) Prototype
- B) Builder
- C) Singleton
- D) Strategy

> **✅ Answer:** C) Singleton
> **Explanation:** Spring beans are singletons by default, meaning one instance per Spring IoC container.

**Q4. Which pattern is used to add new functionality to an existing object without altering its structure?**
- A) Facade
- B) Adapter
- C) Decorator
- D) Proxy

> **✅ Answer:** C) Decorator
> **Explanation:** The Decorator pattern attaches additional responsibilities to an object dynamically.

**Q5. Spring AOP (Aspect-Oriented Programming) heavily relies on which structural pattern?**
- A) Proxy Pattern
- B) Bridge Pattern
- C) Flyweight Pattern
- D) Composite Pattern

> **✅ Answer:** A) Proxy Pattern
> **Explanation:** Spring AOP uses dynamic proxies (JDK or CGLIB) to wrap target objects and execute cross-cutting concerns.

**Q6. Which pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable?**
- A) State Pattern
- B) Command Pattern
- C) Strategy Pattern
- D) Template Method Pattern

> **✅ Answer:** C) Strategy Pattern
> **Explanation:** Strategy pattern lets the algorithm vary independently from clients that use it.

**Q7. The Liskov Substitution Principle (LSP) ensures that:**
- A) Interfaces should be small and specific
- B) Derived classes must be substitutable for their base classes
- C) High-level modules should not depend on low-level modules
- D) Classes should be open for extension but closed for modification

> **✅ Answer:** B) Derived classes must be substitutable for their base classes
> **Explanation:** LSP states that objects of a superclass shall be replaceable with objects of its subclasses without breaking the application.

**Q8. Which behavioral pattern is used by React's context or Redux store to notify components of state changes?**
- A) Iterator
- B) Mediator
- C) Observer
- D) Memento

> **✅ Answer:** C) Observer
> **Explanation:** The Observer pattern defines a one-to-many dependency so that when one object changes state, all its dependents are notified.

**Q9. What design pattern provides a simplified interface to a larger body of code, such as a class library?**
- A) Facade Pattern
- B) Adapter Pattern
- C) Proxy Pattern
- D) Bridge Pattern

> **✅ Answer:** A) Facade Pattern
> **Explanation:** Facade provides a higher-level, unified interface that makes the subsystem easier to use.

**Q10. Dependency Injection (DI) is a specific implementation of which broader principle?**
- A) Interface Segregation
- B) Inversion of Control (IoC)
- C) Open/Closed Principle
- D) Encapsulation

> **✅ Answer:** B) Inversion of Control (IoC)
> **Explanation:** DI is a technique to achieve Inversion of Control, where the framework manages object creation and binding.

---

## Section II: Spring, Maven & Hibernate

**Q11. In Hibernate, what is the 'N+1 selects' problem?**
- A) Saving N entities requires N+1 database connections
- B) Fetching 1 parent entity and its N children results in N+1 database queries
- C) The L1 cache allows only N+1 objects
- D) A pagination offset issue

> **✅ Answer:** B) Fetching 1 parent entity and its N children results in N+1 database queries
> **Explanation:** It occurs when lazy loading triggers an additional query for each child entity in a collection.

**Q12. Which Hibernate method is used to re-attach a detached object to the current session?**
- A) session.save()
- B) session.update()
- C) session.persist()
- D) session.load()

> **✅ Answer:** B) session.update()
> **Explanation:** `update()` transitions an object from detached to persistent state.

**Q13. What is the primary difference between session.save() and session.persist() in Hibernate?**
- A) save() returns the generated identifier; persist() returns void
- B) persist() returns the generated identifier; save() returns void
- C) There is no difference
- D) persist() only works with JPA annotations

> **✅ Answer:** A) save() returns the generated identifier; persist() returns void
> **Explanation:** `save()` immediately returns the generated ID, whereas `persist()` guarantees insertion but returns void.

**Q14. In Maven, which phase compiles the source code of the project?**
- A) validate
- B) compile
- C) test
- D) package

> **✅ Answer:** B) compile
> **Explanation:** The 'compile' phase in the default lifecycle compiles the main source code.

**Q15. What does the `<scope>test</scope>` tag in a Maven dependency mean?**
- A) The dependency is included in the final artifact
- B) The dependency is used for compilation only
- C) The dependency is only required for compiling and running tests
- D) The dependency is provided by the application server

> **✅ Answer:** C) The dependency is only required for compiling and running tests
> **Explanation:** Test scope ensures the library (like JUnit) is not bundled in the production release.

**Q16. Which cache is enabled by default in Hibernate?**
- A) First-level cache (L1)
- B) Second-level cache (L2)
- C) Query cache
- D) None

> **✅ Answer:** A) First-level cache (L1)
> **Explanation:** L1 cache is associated with the Session object and is enabled by default.

**Q17. How do you specify a composite primary key in JPA/Hibernate?**
- A) @CompositeKey
- B) @IdClass or @EmbeddedId
- C) @PrimaryKeyColumn
- D) @MultiId

> **✅ Answer:** B) @IdClass or @EmbeddedId
> **Explanation:** `@IdClass` and `@EmbeddedId` are the standard JPA annotations for composite keys.

**Q18. In Spring, which annotation is used to inject dependencies automatically by type?**
- A) @Resource
- B) @Inject
- C) @Autowired
- D) @Value

> **✅ Answer:** C) @Autowired
> **Explanation:** `@Autowired` resolves dependencies by Type. (`@Resource` resolves by Name).

**Q19. What is a major advantage of using HikariCP in a Spring Boot application?**
- A) It replaces Hibernate as an ORM
- B) It is a high-performance JDBC connection pool
- C) It handles JSON serialization
- D) It manages Spring Security filters

> **✅ Answer:** B) It is a high-performance JDBC connection pool
> **Explanation:** HikariCP is the default, highly optimized connection pool in Spring Boot.

**Q20. What is the correct way to map a One-to-Many relationship in Hibernate without creating a separate join table?**
- A) Use @JoinTable on the parent
- B) Use @JoinColumn on the child and mappedBy on the parent
- C) Use @ManyToMany
- D) Only use @OneToMany without any other annotations

> **✅ Answer:** B) Use @JoinColumn on the child and mappedBy on the parent
> **Explanation:** Using `mappedBy` on the parent side and `@JoinColumn` on the child side establishes a bidirectional relationship without a join table.

---

## Section III: Spring Boot & REST

**Q21. Which dependency is required to expose operational endpoints like /health and /metrics in Spring Boot?**
- A) spring-boot-starter-web
- B) spring-boot-starter-actuator
- C) spring-boot-starter-security
- D) spring-boot-admin-starter

> **✅ Answer:** B) spring-boot-starter-actuator
> **Explanation:** Actuator provides production-ready features to help you monitor and manage your application.

**Q22. Which annotation allows Spring Boot to configure beans based on classpath settings, other beans, and property settings?**
- A) @ComponentScan
- B) @Configuration
- C) @EnableAutoConfiguration
- D) @SpringBootApplication

> **✅ Answer:** C) @EnableAutoConfiguration
> **Explanation:** `@EnableAutoConfiguration` triggers Spring Boot's auto-configuration mechanism.

**Q23. If you want a REST controller to return JSON automatically without using @ResponseBody on every method, which annotation should you use?**
- A) @Controller
- B) @RestController
- C) @JsonController
- D) @WebController

> **✅ Answer:** B) @RestController
> **Explanation:** `@RestController` is a convenience annotation that combines `@Controller` and `@ResponseBody`.

**Q24. What is the correct HTTP method to partially update a resource?**
- A) PUT
- B) POST
- C) PATCH
- D) UPDATE

> **✅ Answer:** C) PATCH
> **Explanation:** PATCH is used for partial modifications, while PUT is intended for complete resource replacement.

**Q25. In Spring REST, which annotation binds a method parameter to a URI template variable (e.g., /users/{id})?**
- A) @RequestParam
- B) @PathVariable
- C) @QueryParam
- D) @UriVariable

> **✅ Answer:** B) @PathVariable
> **Explanation:** `@PathVariable` extracts values from the URI path.

**Q26. What HTTP status code typically represents 'Forbidden' (authenticated but lacks permissions)?**
- A) 401 Unauthorized
- B) 403 Forbidden
- C) 404 Not Found
- D) 405 Method Not Allowed

> **✅ Answer:** B) 403 Forbidden
> **Explanation:** 403 Forbidden indicates the server understood the request but refuses to authorize it.

**Q27. Which interface does Spring Data JPA provide that includes pagination and sorting capabilities by default?**
- A) CrudRepository
- B) PagingAndSortingRepository
- C) JpaPagination
- D) QuerydslPredicateExecutor

> **✅ Answer:** B) PagingAndSortingRepository
> **Explanation:** `PagingAndSortingRepository` extends `CrudRepository` to provide methods for pagination and sorting.

**Q28. How can you externalize configuration for different environments (dev, prod) in Spring Boot?**
- A) Using application-{profile}.properties and spring.profiles.active
- B) Creating multiple pom.xml files
- C) Using @EnvironmentConfig
- D) Spring Boot doesn't support environment profiles natively

> **✅ Answer:** A) Using application-{profile}.properties and spring.profiles.active
> **Explanation:** Spring Profiles allow environment-specific configurations.

**Q29. Which class is the modern, non-blocking alternative to RestTemplate for making HTTP requests in Spring WebFlux?**
- A) WebRequest
- B) HttpClient
- C) WebClient
- D) ReactiveRest

> **✅ Answer:** C) WebClient
> **Explanation:** `WebClient` is the reactive, non-blocking HTTP client introduced in Spring 5.

**Q30. What annotation is used to globally handle exceptions across multiple @Controller classes in Spring Boot?**
- A) @ExceptionHandler
- B) @ControllerAdvice
- C) @GlobalError
- D) @RestException

> **✅ Answer:** B) @ControllerAdvice
> **Explanation:** `@ControllerAdvice` (or `@RestControllerAdvice`) allows you to consolidate exception handling logic globally.

---

## Section IV: React Framework

**Q31. What is the primary purpose of the Virtual DOM in React?**
- A) To completely replace the real DOM for security
- B) To improve performance by minimizing direct manipulation of the real DOM
- C) To allow React to be written in TypeScript
- D) To store application state globally

> **✅ Answer:** B) To improve performance by minimizing direct manipulation of the real DOM
> **Explanation:** React computes changes in memory (Virtual DOM) and batches updates to the real DOM efficiently.

**Q32. Which hook is used to access the Context API in a functional component?**
- A) useContext
- B) useReducer
- C) useProvider
- D) useGlobalState

> **✅ Answer:** A) useContext
> **Explanation:** `useContext` accepts a context object and returns the current context value.

**Q33. Why should you never mutate React state directly (e.g., state.count = 1)?**
- A) It causes an infinite loop
- B) React will not know the state changed and will not re-render the component
- C) It throws a compile-time error
- D) It deletes the Virtual DOM

> **✅ Answer:** B) React will not know the state changed and will not re-render the component
> **Explanation:** React relies on the `setState` (or `useState` setter) function to trigger the reconciliation and re-render process.

**Q34. In React Router (v6+), which component is used to define a mapping between a URL path and a Component?**
- A) \<Switch>
- B) \<Route>
- C) \<Link>
- D) \<Navigate>

> **✅ Answer:** B) \<Route>
> **Explanation:** The `<Route>` component defines the path and the element to render.

**Q35. What is 'prop drilling' in React?**
- A) Passing data from a child component to a parent
- B) Fetching data from a deeply nested API
- C) Passing props through multiple layers of components that don't need the data themselves
- D) Modifying a prop directly inside a component

> **✅ Answer:** C) Passing props through multiple layers of components that don't need the data themselves
> **Explanation:** Prop drilling happens when props are passed down deeply through intermediate components. Context API or Redux solves this.

**Q36. What will happen if you forget to include a 'key' prop when rendering a list via Array.map()?**
- A) The code will fail to compile
- B) React will throw a runtime exception and crash the app
- C) React will log a warning in the console and may experience performance issues during re-renders
- D) Only the first element will be rendered

> **✅ Answer:** C) React will log a warning in the console and may experience performance issues during re-renders
> **Explanation:** Keys help React identify which items have changed, are added, or are removed, optimizing list re-renders.

**Q37. Which hook provides functionality similar to 'componentDidMount' and 'componentDidUpdate' lifecycle methods?**
- A) useState
- B) useEffect
- C) useMemo
- D) useRef

> **✅ Answer:** B) useEffect
> **Explanation:** `useEffect` allows you to perform side effects in functional components, running after renders.

**Q38. What does the useRef hook return?**
- A) An array containing a stateful value and a setter function
- B) A mutable object whose .current property is initialized to the passed argument
- C) A memoized callback function
- D) A new Context object

> **✅ Answer:** B) A mutable object whose .current property is initialized to the passed argument
> **Explanation:** `useRef` provides a persistent, mutable reference that does not trigger re-renders when changed.

**Q39. In Redux, what is the role of a 'reducer'?**
- A) To trigger asynchronous API calls
- B) To bind React components to the store
- C) To take the previous state and an action, and return the next state
- D) To define the UI structure

> **✅ Answer:** C) To take the previous state and an action, and return the next state
> **Explanation:** Reducers are pure functions that determine how the application's state changes in response to an action.

**Q40. When optimizing a React app, what does React.memo() do?**
- A) It caches API responses
- B) It memoizes a functional component, preventing re-renders if props haven't changed
- C) It stores variables in local storage
- D) It minifies the production build bundle

> **✅ Answer:** B) It memoizes a functional component, preventing re-renders if props haven't changed
> **Explanation:** `React.memo` is a higher-order component that skips rendering if the component's props are identical to the previous render.

---

## Section V: Git & Testing (JUnit/Mockito)

**Q41. In Git, what command saves your uncommitted changes temporarily so you can switch branches?**
- A) git pause
- B) git stash
- C) git save
- D) git cache

> **✅ Answer:** B) git stash
> **Explanation:** `git stash` temporarily shelves changes you've made to your working copy.

**Q42. What is the effect of the 'git clone' command?**
- A) It creates a duplicate branch locally
- B) It copies a remote repository to your local machine
- C) It copies a file within your repository
- D) It merges two branches

> **✅ Answer:** B) It copies a remote repository to your local machine
> **Explanation:** `git clone` downloads an existing remote repository, creating a local copy.

**Q43. How do you rewrite the most recent commit message in Git?**
- A) git commit --edit
- B) git rebase -msg
- C) git commit --amend
- D) git update-commit

> **✅ Answer:** C) git commit --amend
> **Explanation:** `git commit --amend` allows you to modify the most recent commit.

**Q44. What is a 'merge conflict' in Git?**
- A) When two branches have different names
- B) When Git cannot automatically resolve differences in code between two commits being merged
- C) When a push is rejected by the remote server
- D) When a repository exceeds its storage limit

> **✅ Answer:** B) When Git cannot automatically resolve differences in code between two commits being merged
> **Explanation:** Conflicts occur when two branches have modified the same part of a file differently.

**Q45. Which JUnit 5 annotation is used to execute a method before ALL tests in a class?**
- A) @Before
- B) @BeforeEach
- C) @BeforeClass
- D) @BeforeAll

> **✅ Answer:** D) @BeforeAll
> **Explanation:** `@BeforeAll` runs once before any of the test methods in the class (must be static). `@BeforeClass` was JUnit 4.

**Q46. In Mockito, what is the default return value for a mocked method that returns an Object (and hasn't been stubbed)?**
- A) An empty object
- B) null
- C) It throws a NullPointerException
- D) A new instance of the return type

> **✅ Answer:** B) null
> **Explanation:** By default, unstubbed methods returning objects in Mockito return `null`.

**Q47. What does the Mockito statement `when(service.getData()).thenReturn("Mocked")` do?**
- A) Verifies that getData() was called
- B) Defines a stub that returns 'Mocked' when getData() is invoked
- C) Injects 'Mocked' into the service dependency
- D) Mocks the entire service class automatically

> **✅ Answer:** B) Defines a stub that returns 'Mocked' when getData() is invoked
> **Explanation:** This is standard Mockito stubbing, controlling the behavior of the mocked object.

**Q48. When writing a unit test, why should you mock the database layer?**
- A) To test the database performance
- B) To ensure the test only validates the business logic (Unit under test) independently
- C) Because databases cannot be used in testing environments
- D) To permanently modify the test database records

> **✅ Answer:** B) To ensure the test only validates the business logic (Unit under test) independently
> **Explanation:** Unit tests must be isolated. Mocking the DB ensures you are only testing the logic of the service, not the DB configuration/connection.

**Q49. Which assertion method in JUnit 5 checks if a method throws a specific exception?**
- A) assertThrows()
- B) assertException()
- C) expectThrows()
- D) @Test(expected=Exception.class)

> **✅ Answer:** A) assertThrows()
> **Explanation:** `assertThrows()` is the JUnit 5 standard for verifying exceptions. The `@Test(expected=...)` syntax is from JUnit 4.

**Q50. What is the difference between @Mock and @InjectMocks in Mockito?**
- A) @Mock injects dependencies, @InjectMocks creates them
- B) @Mock creates a mock object, @InjectMocks creates an instance of the class and injects the mocks into it
- C) They are functionally identical
- D) @InjectMocks is used for Spring Contexts only

> **✅ Answer:** B) @Mock creates a mock object, @InjectMocks creates an instance of the class and injects the mocks into it
> **Explanation:** `@Mock` builds the fake object. `@InjectMocks` instantiates the real class you are testing and pushes the `@Mock`s into it.
