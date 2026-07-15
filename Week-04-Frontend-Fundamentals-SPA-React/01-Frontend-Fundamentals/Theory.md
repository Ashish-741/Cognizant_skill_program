# Frontend Fundamentals: HTML5, CSS3 & ES6+ JavaScript

## 1. Why Semantic HTML5 Matters?
Semantic HTML tags (`<header>`, `<nav>`, `<main>`, `<section>`, `<article>`, `<aside>`, `<footer>`) describe the *meaning* and *structure* of web content rather than just its visual appearance (`<div>` and `<span>`).
- **Accessibility (a11y):** Screen readers use semantic boundaries to navigate web pages effortlessly for visually impaired users.
- **Search Engine Optimization (SEO):** Search engines rank well-structured semantic pages higher because crawlers easily distinguish primary article content from secondary navigation or sidebars.

---

## 2. Flexbox vs. CSS Grid Layouts
- **Flexbox (1-Dimensional Layout):** Designed for distributing space along a single axis (either row OR column). Ideal for navigation bars, button groups, and card alignments (`display: flex; justify-content: space-between;`).
- **CSS Grid (2-Dimensional Layout):** Designed for placing elements across both rows AND columns simultaneously. Ideal for overall page skeletons, executive statistical dashboards, and photo grids (`display: grid; grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));`).

---

## 3. ES6+ JavaScript Key Features
- **`let` and `const` vs. `var`:** `let` and `const` have **block scope** (`{ ... }`) and do not suffer from variable hoisting anomalies like function-scoped `var`. `const` guarantees variable reference immutability.
- **Arrow Functions:** (`(param) => { ... }`) provide concise syntax and lexical binding of `this` (they inherit `this` from the surrounding parent scope).
- **Destructuring & Spread Operator:**
  ```javascript
  const { name, email } = associateObject;        // Object destructuring
  const updatedList = [newAssociate, ...oldList]; // Spread syntax for immutable arrays
  ```
- **Promises & `async/await`:** Eliminates callback hell (`setTimeout` pyramid) by writing asynchronous API code in a sequential, synchronous-looking readability pattern.

---

## 4. Top GenC Next Interview Questions

### Q1: What is the Event Loop in JavaScript, and how does it handle asynchronous operations?
**Answer:**
JavaScript is a single-threaded language executed inside the V8 engine call stack. When asynchronous operations occur (e.g., `fetch()` API calls, `setTimeout`), they are handed off to Web APIs/Node C++ threads. When complete, their callback functions are pushed to the **Microtask Queue** (for Promises) or **Macrotask/Callback Queue** (for `setTimeout`). The **Event Loop** continuously checks if the main call stack is empty; when empty, it prioritizes draining the Microtask Queue before processing the Callback Queue.

### Q2: What is Event Delegation in the DOM?
**Answer:**
Instead of attaching individual event listeners to 100 separate child elements (`<button>` or `<li>`), **Event Delegation** attaches a single event listener to their common parent container (`<ul>` or `<div>`). Because DOM events **bubble up** from the target element to its ancestors, the parent handler inspects `event.target` to determine exactly which child was clicked. This drastically reduces memory overhead.
