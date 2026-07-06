package week1.designpatterns.adapter;

// Third-party API with incompatible method signature (Adaptee 1)
public class StripeGateway {
    public void makeStripePayment(double amountInCents) {
        System.out.printf("[STRIPE API] Charging card via Stripe: ₹%,.2f (Transaction ID: STR-8849)%n", amountInCents);
    }
}
