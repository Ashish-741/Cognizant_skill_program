package week1.designpatterns.adapter;

// Adapter translating PaymentProcessor calls to StripeGateway methods
public class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("[ADAPTER] Translating processPayment() -> makeStripePayment()...");
        stripeGateway.makeStripePayment(amount);
    }
}
