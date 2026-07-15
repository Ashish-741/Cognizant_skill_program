import React, { useReducer, useState } from 'react';
import { departmentReducer, initialDepartmentState } from './departmentReducer';

/**
 * Component demonstrating useReducer for advanced state transitions.
 */
export default function DepartmentManager() {
    const [state, dispatch] = useReducer(departmentReducer, initialDepartmentState);
    const [newMemberName, setNewMemberName] = useState('');
    const [newMemberRole, setNewMemberRole] = useState('Java FSE');

    const handleAdd = (e) => {
        e.preventDefault();
        if (!newMemberName.trim()) return;
        
        dispatch({
            type: 'ADD_MEMBER',
            payload: { name: newMemberName.trim(), role: newMemberRole }
        });
        setNewMemberName('');
    };

    return (
        <div style={{ background: '#1e293b', padding: '2rem', borderRadius: '14px', color: '#fff', margin: '1.5rem 0' }}>
            <div style={{ display: 'flex', justify-content: 'space-between', alignItems: 'center', borderBottom: '1px solid #334155', paddingBottom: '1rem', marginBottom: '1.5rem' }}>
                <div>
                    <h2>Department State Controller (`useReducer`)</h2>
                    <p style={{ color: '#94a3b8', fontSize: '0.9rem' }}>Department: <strong>{state.deptName}</strong></p>
                </div>
                <div style={{ textAlign: 'right' }}>
                    <div style={{ fontSize: '1.2rem', fontWeight: '800', color: '#10b981' }}>
                        ₹{(state.budgetAllocation / 100000).toFixed(2)} LPA
                    </div>
                    <span style={{ fontSize: '0.75rem', color: '#64748b' }}>Last Modified: {state.lastModified}</span>
                </div>
            </div>

            <div style={{ display: 'grid', gridTemplateColumns: '1fr 1fr', gap: '2rem' }}>
                {/* Add Member Form */}
                <form onSubmit={handleAdd} style={{ background: '#0f172a', padding: '1.5rem', borderRadius: '10px', border: '1px solid #334155' }}>
                    <h3 style={{ fontSize: '1.1rem', marginBottom: '1rem' }}>Dispatch `ADD_MEMBER` Action</h3>
                    <div style={{ marginBottom: '1rem' }}>
                        <label style={{ display: 'block', fontSize: '0.8rem', color: '#94a3b8', marginBottom: '0.3rem' }}>Associate Name:</label>
                        <input 
                            type="text" 
                            value={newMemberName} 
                            onChange={(e) => setNewMemberName(e.target.value)} 
                            placeholder="e.g. Ananya Verma" 
                            style={{ width: '100%', padding: '0.6rem', borderRadius: '6px', border: '1px solid #334155', background: '#1e293b', color: '#fff' }}
                        />
                    </div>
                    <div style={{ marginBottom: '1.25rem' }}>
                        <label style={{ display: 'block', fontSize: '0.8rem', color: '#94a3b8', marginBottom: '0.3rem' }}>Assigned Role:</label>
                        <select 
                            value={newMemberRole} 
                            onChange={(e) => setNewMemberRole(e.target.value)}
                            style={{ width: '100%', padding: '0.6rem', borderRadius: '6px', border: '1px solid #334155', background: '#1e293b', color: '#fff' }}
                        >
                            <option value="Java FSE">Java FSE</option>
                            <option value="Cloud Architect">Cloud Architect</option>
                            <option value="Data Engineer">Data Engineer</option>
                        </select>
                    </div>
                    <button type="submit" style={{ width: '100%', padding: '0.75rem', background: '#3b82f6', color: '#fff', border: 'none', borderRadius: '6px', fontWeight: '600', cursor: 'pointer' }}>
                        Dispatch Action
                    </button>
                </form>

                {/* Member List & Budget Controls */}
                <div>
                    <div style={{ display: 'flex', gap: '0.75rem', marginBottom: '1rem' }}>
                        <button 
                            onClick={() => dispatch({ type: 'UPDATE_BUDGET', payload: { amount: 500000 } })}
                            style={{ flex: 1, padding: '0.6rem', background: '#10b981', color: '#fff', border: 'none', borderRadius: '6px', fontWeight: '600', cursor: 'pointer' }}
                        >
                            + ₹5 LPA Budget
                        </button>
                        <button 
                            onClick={() => dispatch({ type: 'RESET' })}
                            style={{ padding: '0.6rem 1rem', background: '#64748b', color: '#fff', border: 'none', borderRadius: '6px', fontWeight: '600', cursor: 'pointer' }}
                        >
                            Reset State
                        </button>
                    </div>

                    <h3 style={{ fontSize: '1.1rem', marginBottom: '0.75rem' }}>Active Roster ({state.members.length})</h3>
                    <ul style={{ listStyle: 'none', display: 'flex', flexDirection: 'column', gap: '0.5rem' }}>
                        {state.members.map(member => (
                            <li key={member.id} style={{ display: 'flex', justify-content: 'space-between', alignItems: 'center', background: '#0f172a', padding: '0.75rem 1rem', borderRadius: '8px', border: '1px solid #334155' }}>
                                <div>
                                    <strong style={{ fontSize: '0.95rem' }}>{member.name}</strong>
                                    <span style={{ fontSize: '0.8rem', color: '#94a3b8', display: 'block' }}>{member.role}</span>
                                </div>
                                <button 
                                    onClick={() => dispatch({ type: 'REMOVE_MEMBER', payload: { id: member.id } })}
                                    style={{ background: '#ef4444', color: '#fff', border: 'none', padding: '0.35rem 0.7rem', borderRadius: '4px', fontSize: '0.75rem', cursor: 'pointer' }}
                                >
                                    Remove
                                </button>
                            </li>
                        ))}
                    </ul>
                </div>
            </div>
        </div>
    );
}
