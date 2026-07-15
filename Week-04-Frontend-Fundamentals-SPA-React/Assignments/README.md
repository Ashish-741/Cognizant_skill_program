# Week 4 Assignments & Mini-Project Evaluation

## Hands-on Tasks

1. **HTML5 & CSS3 Responsive Landing Page:**
   - Build a mobile-first responsive portfolio landing page using Semantic HTML5 elements (`<header>`, `<nav>`, `<main>`, `<section>`, `<footer>`).
   - Implement a 3-column feature grid using CSS Grid and Flexbox navigation bar.
   - Use CSS custom properties (`:root` variables) for dark/light theme switching.

2. **ES6+ Asynchronous API Dashboard:**
   - Create an application that fetches user profiles from `https://jsonplaceholder.typicode.com/users` using `fetch()` and `async/await`.
   - Implement dynamic DOM rendering using ES6 template literals and array `.map()`.
   - Add local filtering by name/email and persist favorite profiles in `localStorage`.

3. **React Single Page Application (SPA) with State Management:**
   - Build an **Associate Skill Matrix Dashboard** in React.
   - Use `useState` for local form controlled components and dynamic search/filtering.
   - Use `useEffect` to simulate fetching associate competency scores from a mock REST endpoint on component mount (`componentDidMount` lifecycle).
   - Use `useReducer` to manage complex multi-step competency assessment evaluations (`START_EXAM`, `RECORD_SCORE`, `COMPLETE_EXAM`).
   - Use Context API (`createContext`, `useContext`) to share current logged-in mentor authorization status across deeply nested components.
