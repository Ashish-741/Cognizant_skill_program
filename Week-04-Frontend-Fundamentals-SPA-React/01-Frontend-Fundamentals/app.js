/**
 * Modern ES6+ JavaScript — Cognizant SkillSpring Associate Portal
 * Demonstrates: let/const, Arrow Functions, Destructuring, Spread Operator,
 * Async/Await Promises, and DOM Event Delegation.
 */

// Initial Seed Data stored using ES6 const and Objects
const SEED_ASSOCIATES = [
    { id: 'DNS-101', name: 'Ashish Kumar Chahar', email: 'ashish@cognizant.com', track: 'Java FSE', tier: 'GenC Next (6.75+ LPA)' },
    { id: 'DNS-102', name: 'Priya Sharma', email: 'priya@cognizant.com', track: 'Cloud Infra', tier: 'GenC Next (6.75+ LPA)' },
    { id: 'DNS-103', name: 'Rohan Mehta', email: 'rohan@cognizant.com', track: 'Data Eng', tier: 'GenC Pro (5.4 LPA)' }
];

// ES6+ Class representing the Associate Portfolio Service
class AssociateManager {
    constructor() {
        this.associates = this.loadFromStorage();
        this.init();
    }

    loadFromStorage() {
        const stored = localStorage.getItem('dns_associates');
        return stored ? JSON.parse(stored) : [...SEED_ASSOCIATES];
    }

    saveToStorage() {
        localStorage.setItem('dns_associates', JSON.stringify(this.associates));
    }

    // Async function simulating remote backend API call with Promise delay
    async registerAssociateAsync(newAssociate) {
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                if (this.associates.some(assoc => assoc.email.toLowerCase() === newAssociate.email.toLowerCase())) {
                    reject(new Error(`Associate with email '${newAssociate.email}' is already onboarded.`));
                } else {
                    const created = {
                        id: `DNS-${Math.floor(100 + Math.random() * 900)}`,
                        ...newAssociate
                    };
                    this.associates = [created, ...this.associates];
                    this.saveToStorage();
                    resolve(created);
                }
            }, 600); // Simulate 600ms network round-trip
        });
    }

    renderRoster() {
        const rosterGrid = document.getElementById('roster-grid');
        const totalCountEl = document.getElementById('total-count');
        
        if (!rosterGrid || !totalCountEl) return;

        totalCountEl.textContent = this.associates.length;
        rosterGrid.innerHTML = '';

        // ES6 Array map and Template Literals for clean DOM rendering
        const cardsHTML = this.associates.map(({ id, name, email, track, tier }) => `
            <div class="roster-card">
                <div style="display: flex; justify-content: space-between; align-items: center; margin-bottom: 0.5rem;">
                    <strong style="color: #60a5fa;">${id}</strong>
                    <span style="font-size: 0.75rem; background: #334155; padding: 0.2rem 0.5rem; border-radius: 4px;">${track}</span>
                </div>
                <h4 style="font-size: 1.1rem; margin-bottom: 0.25rem;">${name}</h4>
                <p style="font-size: 0.85rem; color: #94a3b8; margin-bottom: 0.75rem;">${email}</p>
                <div style="border-top: 1px solid #334155; padding-top: 0.5rem; font-size: 0.8rem; color: #10b981; font-weight: 600;">
                    Target: ${tier}
                </div>
            </div>
        `).join('');

        rosterGrid.innerHTML = cardsHTML;
    }

    init() {
        this.renderRoster();
        this.attachFormListener();
    }

    attachFormListener() {
        const form = document.getElementById('associate-form');
        if (!form) return;

        form.addEventListener('submit', async (event) => {
            event.preventDefault();
            
            // Clear previous errors
            document.querySelectorAll('.error-msg').forEach(el => el.textContent = '');

            const fullNameInput = document.getElementById('fullName');
            const emailInput = document.getElementById('emailAddress');
            const trackInput = document.getElementById('track');
            const tierInput = document.getElementById('ctcTier');

            // Basic UI Validation
            if (!fullNameInput.value || fullNameInput.value.trim().length < 3) {
                document.getElementById('name-error').textContent = 'Please enter a valid full name (min 3 chars).';
                return;
            }
            if (!emailInput.value || !emailInput.value.includes('@')) {
                document.getElementById('email-error').textContent = 'Please enter a valid corporate email.';
                return;
            }

            const submitBtn = form.querySelector('button[type="submit"]');
            const originalText = submitBtn.textContent;
            submitBtn.textContent = 'Onboarding...';
            submitBtn.disabled = true;

            try {
                // ES6 Destructuring & Async/Await execution
                const payload = {
                    name: fullNameInput.value.trim(),
                    email: emailInput.value.trim(),
                    track: trackInput.value,
                    tier: tierInput.value
                };

                const newAssociate = await this.registerAssociateAsync(payload);
                console.log('[SUCCESS] Onboarded new associate:', newAssociate);
                
                this.renderRoster();
                form.reset();
            } catch (error) {
                console.error('[API ERROR]', error.message);
                document.getElementById('email-error').textContent = error.message;
            } finally {
                submitBtn.textContent = originalText;
                submitBtn.disabled = false;
            }
        });
    }
}

// Initialize Application when DOM is fully loaded
document.addEventListener('DOMContentLoaded', () => {
    new AssociateManager();
    console.log('=== Week 4 Topic 1: ES6+ Frontend Fundamentals Application Loaded ===');
});
