/**
 * Pure Reducer Function for handling state transitions via useReducer.
 * Preferred over useState when state logic involves complex sub-values or next state depends on previous state.
 */

export const initialDepartmentState = {
    deptName: 'Digital Engineering & Cloud FSE',
    budgetAllocation: 2500000,
    members: [
        { id: 1, name: 'Ashish Kumar Chahar', role: 'Lead Architect' },
        { id: 2, name: 'Rohan Mehta', role: 'Full Stack Engineer' }
    ],
    lastModified: new Date().toLocaleTimeString()
};

export function departmentReducer(state, action) {
    switch (action.type) {
        case 'ADD_MEMBER':
            return {
                ...state,
                members: [
                    ...state.members,
                    { id: Date.now(), name: action.payload.name, role: action.payload.role }
                ],
                lastModified: new Date().toLocaleTimeString()
            };

        case 'REMOVE_MEMBER':
            return {
                ...state,
                members: state.members.filter(member => member.id !== action.payload.id),
                lastModified: new Date().toLocaleTimeString()
            };

        case 'UPDATE_BUDGET':
            return {
                ...state,
                budgetAllocation: state.budgetAllocation + action.payload.amount,
                lastModified: new Date().toLocaleTimeString()
            };

        case 'RESET':
            return initialDepartmentState;

        default:
            throw new Error(`Unsupported action type: ${action.type}`);
    }
}
