import React, { useState } from 'react';
import EmployeeList from './EmployeeList';
import './index.css';

/**
 * Root Functional Component — Single Page Application (SPA) Hub.
 * Demonstrates JSX rules, conditional rendering, and parent state passing down as props.
 */
export default function App() {
    // Initial static state illustrating SPA client-side rendering without full page reloads
    const [associates, setAssociates] = useState([
        { id: 101, name: 'Ashish Kumar Chahar', track: 'Java FSE', status: 'Active', tier: 'GenC Next' },
        { id: 102, name: 'Priya Sharma', track: 'Cloud & DevOps', status: 'Active', tier: 'GenC Next' },
        { id: 103, name: 'Rohan Mehta', track: 'Data Engineering', status: 'On Leave', tier: 'GenC Pro' },
        { id: 104, name: 'Ananya Verma', track: 'AI & ML', status: 'Active', tier: 'GenC Next' }
    ]);

    const [filterActiveOnly, setFilterActiveOnly] = useState(false);

    // Event handlers passed down as callback props
    const handleDelete = (id) => {
        console.log(`[SPA ACTION] Deleting associate ID: ${id}`);
        setAssociates(prev => prev.filter(assoc => assoc.id !== id));
    };

    const handlePromote = (id) => {
        console.log(`[SPA ACTION] Promoting associate ID: ${id} to GenC Next`);
        setAssociates(prev => prev.map(assoc => 
            assoc.id === id ? { ...assoc, tier: 'GenC Next' } : assoc
        ));
    };

    const displayedAssociates = filterActiveOnly 
        ? associates.filter(a => a.status === 'Active') 
        : associates;

    return (
        <div className="spa-container">
            <header className="spa-header">
                <div className="header-badge">React SPA Engine</div>
                <h1>SkillSpring Associate Management Dashboard</h1>
                <p>Client-Side Virtual DOM Diffing & Reconciliation Demo</p>
            </header>

            <main className="spa-main">
                <div className="controls-bar">
                    <span>Total Onboarded: <strong>{displayedAssociates.length}</strong></span>
                    <button 
                        className={`filter-btn ${filterActiveOnly ? 'active' : ''}`}
                        onClick={() => setFilterActiveOnly(!filterActiveOnly)}
                    >
                        {filterActiveOnly ? 'Showing Active Only' : 'Show All Associates'}
                    </button>
                </div>

                {/* Conditional Rendering using Ternary Operator */}
                {displayedAssociates.length === 0 ? (
                    <div className="empty-state">
                        <p>No associates match the current filtering criteria.</p>
                    </div>
                ) : (
                    <EmployeeList 
                        employees={displayedAssociates} 
                        onDelete={handleDelete} 
                        onPromote={handlePromote} 
                    />
                )}
            </main>
        </div>
    );
}
