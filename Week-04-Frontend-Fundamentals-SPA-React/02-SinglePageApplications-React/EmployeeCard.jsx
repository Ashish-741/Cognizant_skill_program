import React from 'react';

/**
 * Reusable Functional Component representing an individual Associate Card.
 * Receives destructured props and triggers callback functions passed from the parent App component.
 */
export default function EmployeeCard({ employee, onDelete, onPromote }) {
    const { id, name, track, status, tier } = employee;
    const isGenCNext = tier === 'GenC Next';

    return (
        <div className={`employee-card ${isGenCNext ? 'card-next-tier' : ''}`}>
            <div className="card-header">
                <span className="emp-id">#{id}</span>
                <span className={`emp-status status-${status.toLowerCase().replace(' ', '-')}`}>
                    {status}
                </span>
            </div>

            <h3 className="emp-name">{name}</h3>
            <p className="emp-track">Track: <strong>{track}</strong></p>
            
            <div className="tier-badge-container">
                <span className={`tier-badge ${isGenCNext ? 'badge-next' : 'badge-standard'}`}>
                    {tier}
                </span>
            </div>

            <div className="card-actions">
                {!isGenCNext && (
                    <button 
                        className="btn-promote" 
                        onClick={() => onPromote(id)}
                        title="Promote to GenC Next Tier"
                    >
                        ⚡ Promote
                    </button>
                )}
                <button 
                    className="btn-delete" 
                    onClick={() => onDelete(id)}
                    title="Remove Associate"
                >
                    🗑️ Remove
                </button>
            </div>
        </div>
    );
}
