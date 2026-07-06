# Model-View-Controller (MVC) Architectural Pattern

## What is MVC?
The **Model-View-Controller (MVC)** pattern is an architectural design pattern that separates an application into three interconnected components. This separation of concerns allows efficient modular development and parallel workflow across engineering teams.

---

## The 3 Components
1. **Model:** Represents the core business data, state, and domain rules (`Student`). It is independent of user interface elements and notifies controllers or observers when its state changes.
2. **View:** Responsible solely for presenting the data to the user (`StudentView`). It renders visual elements (console text, HTML/CSS, or desktop UI widgets) without containing business logic.
3. **Controller:** Acts as the mediator between the Model and the View (`StudentController`). It receives user input, manipulates the Model's data accordingly, and refreshes the View.

---

## Advantages
- **Separation of Concerns:** High cohesion and loose coupling allow frontend developers (View) and backend engineers (Model/Controller) to work concurrently without blocking each other.
- **Multiple Views for One Model:** You can attach multiple views (e.g., a Web Dashboard, a Mobile Screen, and a PDF Export view) to the exact same underlying `Student` model.
- **Ease of Maintenance and Testing:** Since business logic is isolated in the Model and Controller, unit testing can be performed without spinning up complex GUI environments.

---

## Disadvantages
- **Increased File Complexity:** Even a simple CRUD feature requires creating at least three separate classes/files, which can feel bloated for tiny applications.
- **Controller Bloat (Fat Controller):** In poorly disciplined teams, controllers can accumulate too much business logic over time, becoming difficult to maintain.

---

## Real World Example
- **Spring MVC / Spring Boot Web:** When a browser sends an HTTP request to `GET /students/101`, the Spring **DispatcherServlet (Controller)** intercepts the call, queries the database to populate the **Student DTO (Model)**, and passes the model to a Thymeleaf HTML template or Jackson JSON serializer **(View)** to render the final response.

---

## Interview Questions

### Q1: What is the difference between MVC and MVP (Model-View-Presenter)?
**Answer:**
- In **MVC**, the View can sometimes communicate directly with the Model (in passive Observer MVC setups) to read data for rendering.
- In **MVP**, the Presenter takes complete control over UI rendering. The View is completely passive ("Humble View") and has zero direct knowledge of the Model. All data binding passes strictly through the Presenter.

### Q2: Why is MVC considered an architectural pattern rather than a GoF design pattern?
**Answer:** Standard GoF (Gang of Four) patterns (like Singleton or Strategy) solve specific micro-level problems between individual objects. **MVC** is a macro-level architectural blueprint that organizes an entire application layout. In fact, MVC is a **composite pattern** that uses several GoF patterns under the hood:
- **Observer:** For View-Model synchronization.
- **Strategy:** For Controller-View input handling.
- **Composite:** For hierarchical UI view rendering.
