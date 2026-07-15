import React from 'react';
import EmployeeCard from './EmployeeCard';

/**
 * List Component iterating over an array of employee objects.
 * Demonstrates the mandatory React 'key' prop for optimal Virtual DOM reconciliation.
 */
export default function EmployeeList({ employees, onDelete, onPromote }) {
    return (
        <div className="employee-list-grid">
            {employees.map((employee) => (
                <EmployeeCard 
                    key={employee.id} 
                    employee={employee} 
                    onDelete={onDelete} 
                    onPromote={onPromote} 
                />
            ))}
        </div>
    );
}
