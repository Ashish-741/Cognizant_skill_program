package week1.designpatterns.adapter;

// Adapter translating PaymentProcessor calls to PayPalGateway methods
public class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("[ADAPTER] Translating processPayment() -> sendPayPalFunds()...");
        payPalGateway.sendPayPalFunds(amount);
    }
}
