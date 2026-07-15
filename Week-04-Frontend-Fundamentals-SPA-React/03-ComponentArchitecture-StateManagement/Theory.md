# React State Management & Hook Architecture

## 1. What is Prop Drilling, and How Does the Context API Solve It?
- **Prop Drilling Problem:** When a top-level component (`<App>`) holds user authentication data or theme settings that a deeply nested child component (`<EmployeeDashboard>`) needs, that data must be passed down manually as props through 4-5 intermediate child components that don't even use the data themselves. This pollutes component interfaces.
- **Context API (`createContext`, `useContext`):** Creates a global state broadcasting hub (`<AuthProvider>`) wrapping the application. Any child component at any nesting depth can directly subscribe to the context using the `useContext` hook without requiring props to be drilled through intermediate layers.

---

## 2. Component Lifecycle with `useEffect`
Before React Hooks, component lifecycles were handled by class methods (`componentDidMount`, `componentDidUpdate`, `componentWillUnmount`). The `useEffect` hook unifies all three lifecycles into a single declarative pattern:
```jsx
useEffect(() => {
    // 1. Setup execution (Runs on mount after initial render)
    const subscription = subscribeToBackendAPI();

    // 2. Cleanup function (Runs on unmount OR right before re-running effect)
    return () => {
        subscription.unsubscribe();
    };
}, [dependencies]); // 3. Dependency Array controls when effect re-triggers
```

---

## 3. When to Use `useState` vs. `useReducer`?
- **`useState`:** Best for simple, independent state values such as boolean toggle flags (`filterActiveOnly`), controlled text inputs (`searchQuery`), or straightforward arrays.
- **`useReducer` (`const [state, dispatch] = useReducer(reducer, initialState)`):** Best when state consists of multiple sub-values, complex nested objects (`DepartmentState`), or when the next state calculation depends on the previous state logic. It centralizes all state mutations inside a pure `reducer(state, action)` function using dispatched actions (`ADD_MEMBER`, `UPDATE_BUDGET`), making state changes highly predictable and easy to unit test.

---

## 4. Top GenC Next Interview Questions

### Q1: What are the Two Golden Rules of React Hooks?
**Answer:**
1. **Only call Hooks at the top level:** Never call Hooks (`useState`, `useEffect`) inside loops, `if` conditions, or nested functions. React relies on the exact invocation order of hooks between re-renders to preserve component state correctly.
2. **Only call Hooks from React functional components or custom Hooks:** Never call Hooks from regular JavaScript helper functions or class components.

### Q2: What causes infinite re-render loops inside `useEffect`, and how do you fix it?
**Answer:**
If an effect modifies a state variable (`setDataList(...)`) without specifying a proper dependency array (`[]`), the state update triggers a component re-render. After the re-render, React re-runs the effect again, updating state again and causing an infinite loop. Always pass an empty dependency array `[]` if the effect should only run once on component mount, or include exact dependencies that trigger updates.
