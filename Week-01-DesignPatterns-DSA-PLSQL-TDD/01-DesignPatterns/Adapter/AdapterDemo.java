package week1.designpatterns.adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("=== Exercise 4: Testing Adapter Pattern with Payment Processing System ===");

        // 1. Using Stripe via Adapter
        System.out.println("\n--- Initiating Stripe Checkout ---");
        StripeGateway stripe = new StripeGateway();
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        stripeProcessor.processPayment(4500.00);

        // 2. Using PayPal via Adapter
        System.out.println("\n--- Initiating PayPal Checkout ---");
        PayPalGateway paypal = new PayPalGateway();
        PaymentProcessor paypalProcessor = new PayPalAdapter(paypal);
        paypalProcessor.processPayment(12500.00);
    }
}
