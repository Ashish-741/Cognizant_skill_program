import React, { useState, useEffect } from 'react';
import { useAuth } from './AuthContext';

/**
 * Dashboard Component showcasing useState controlled inputs and useEffect lifecycle hooks.
 */
export default function EmployeeDashboard() {
    const { currentUser } = useAuth();
    
    // Controlled form input state
    const [searchQuery, setSearchQuery] = useState('');
    const [statusMessage, setStatusMessage] = useState('System Idle');
    
    // Data state fetched asynchronously inside useEffect
    const [dataList, setDataList] = useState([]);
    const [isLoading, setIsLoading] = useState(true);

    // useEffect simulating componentDidMount and componentDidUpdate lifecycles
    useEffect(() => {
        let isMounted = true;
        setIsLoading(true);
        setStatusMessage('Fetching associate metrics from backend API...');

        const timer = setTimeout(() => {
            if (isMounted) {
                setDataList([
                    { id: 'ENG-01', metric: 'Code Quality Index', score: '98.4%', trend: '+4%' },
                    { id: 'ENG-02', metric: 'Test Coverage (TDD)', score: '92.0%', trend: '+8%' },
                    { id: 'ENG-03', metric: 'Sprint Velocity', score: '44 pts', trend: 'Optimal' }
                ]);
                setIsLoading(false);
                setStatusMessage('Metrics synchronized successfully.');
            }
        }, 1200);

        // Cleanup function executing when component unmounts or before re-running effect
        return () => {
            isMounted = false;
            clearTimeout(timer);
            console.log('[LIFECYCLE CLEANUP] Dashboard unmounted or effect re-triggered.');
        };
    }, []); // Empty dependency array ensures this effect runs once on mount

    return (
        <div style={{ background: '#1e293b', padding: '2rem', borderRadius: '14px', color: '#fff', margin: '1.5rem 0' }}>
            <div style={{ borderBottom: '1px solid #334155', paddingBottom: '1rem', marginBottom: '1.5rem' }}>
                <h2>Associate Analytics Engine</h2>
                <p style={{ color: '#94a3b8', fontSize: '0.9rem' }}>
                    Active User: <strong>{currentUser.username}</strong> ({currentUser.role})
                </p>
            </div>

            {/* Controlled Input Example */}
            <div style={{ marginBottom: '1.5rem' }}>
                <label style={{ display: 'block', fontSize: '0.85rem', color: '#94a3b8', marginBottom: '0.4rem' }}>
                    Filter Analytics Query (`useState` controlled):
                </label>
                <input 
                    type="text" 
                    value={searchQuery} 
                    onChange={(e) => setSearchQuery(e.target.value)} 
                    placeholder="Search metric name..."
                    style={{ width: '100%', padding: '0.6rem 1rem', borderRadius: '8px', border: '1px solid #334155', background: '#0f172a', color: '#fff' }}
                />
            </div>

            <div style={{ fontSize: '0.85rem', color: '#38bdf8', marginBottom: '1rem' }}>
                ⚡ Status: {statusMessage}
            </div>

            {isLoading ? (
                <div style={{ padding: '2rem', textAlign: 'center', color: '#94a3b8' }}>
                    ⏳ Loading simulated Spring Boot REST metrics...
                </div>
            ) : (
                <div style={{ display: 'grid', gridTemplateColumns: 'repeat(auto-fit, minmax(200px, 1fr))', gap: '1rem' }}>
                    {dataList
                        .filter(item => item.metric.toLowerCase().includes(searchQuery.toLowerCase()))
                        .map(item => (
                            <div key={item.id} style={{ background: '#0f172a', padding: '1.25rem', borderRadius: '10px', border: '1px solid #334155' }}>
                                <span style={{ fontSize: '0.75rem', color: '#64748b' }}>{item.id}</span>
                                <h4 style={{ fontSize: '1rem', margin: '0.25rem 0' }}>{item.metric}</h4>
                                <div style={{ fontSize: '1.75rem', fontWeight: '800', color: '#10b981' }}>{item.score}</div>
                                <span style={{ fontSize: '0.8rem', color: '#38bdf8' }}>Trend: {item.trend}</span>
                            </div>
                        ))}
                </div>
            )}
        </div>
    );
}
