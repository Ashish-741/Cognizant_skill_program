# Single Page Applications (SPA) & React Component Architecture

## 1. SPA vs. Multi-Page Applications (MPA)
- **Multi-Page Application (MPA):** Every time the user navigates to a new URL, the browser requests a completely new HTML page from the server, causing a full screen refresh and rebuilding the DOM tree from scratch.
- **Single Page Application (SPA):** The browser loads a single root HTML page (`index.html`) upon initial load. Subsequent navigation and user interactions dynamically rewrite the DOM structure using client-side JavaScript (`React Router` / `ReactDOM`), resulting in instantaneous, desktop-app-like user transitions without full page reloads.

---

## 2. Virtual DOM & Reconciliation Diffing Algorithm
Manipulating the browser's Real DOM directly (via `document.createElement`) is computationally expensive because it forces the browser to recalculate layout flow and repaint pixels.
- **Virtual DOM:** React maintains a lightweight JavaScript object tree representation of the DOM (`Virtual DOM`).
- **Diffing & Reconciliation:** When component state (`useState`) changes, React creates a new Virtual DOM tree and compares (`diffs`) it against the previous Virtual DOM tree. React then calculates the exact minimum set of changes needed and batch-updates **only those specific nodes** in the Real DOM (`Reconciliation`), achieving state-of-the-art UI performance.

---

## 3. JSX Syntax & Component Rules
- **JSX (JavaScript XML):** Syntactic sugar that allows writing HTML-like markup directly inside JavaScript. Under the hood, Babel compiles `<div className="box">` into `React.createElement('div', { className: 'box' })`.
- **Why `className` instead of `class`?** Since `class` is a reserved keyword in JavaScript ES6+, JSX uses `className`.
- **Why unique `key` prop inside lists?** When rendering arrays via `.map()`, React requires a stable, unique `key={item.id}` prop. This allows React's diffing algorithm to instantly identify exactly which items were added, removed, or reordered without re-rendering the entire list.

---

## 4. Top GenC Next Interview Questions

### Q1: What is the difference between Functional Components and Class Components in React?
**Answer:**
Prior to React 16.8, **Class Components** (`class App extends React.Component`) were mandatory if a component needed state or lifecycle methods (`componentDidMount`). **Functional Components** were stateless UI renderers. With the introduction of **React Hooks** (`useState`, `useEffect`), Functional Components can manage complex state and lifecycles with significantly cleaner syntax, zero boilerplate `this` binding, and better minification optimization. Functional components are now the absolute industry standard.

### Q2: What is the difference between `props` and `state`?
**Answer:**
- **`props` (Properties):** Immutable data parameters passed **downwards** from a parent component to a child component (`<EmployeeCard employee={data} />`). A child component cannot modify its own props.
- **`state` (`useState`):** Internal, mutable data managed **inside** a specific component. When state changes (`setAssociates(...)`), React automatically re-renders that component and its children.
