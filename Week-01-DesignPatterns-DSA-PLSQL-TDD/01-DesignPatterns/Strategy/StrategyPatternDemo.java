package strategy;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        System.out.println("=== Exercise 8: Testing Strategy Pattern with PaymentContext ===");

        PaymentContext context = new PaymentContext();

        // 1. Select Credit Card Strategy at runtime
        System.out.println("\n--- Selecting Credit Card Payment ---");
        context.setPaymentStrategy(new CreditCardPayment("Ashish Kumar", "4532-8890-1234-5678"));
        context.executePayment(4500.00);

        // 2. Switch to PayPal Strategy at runtime
        System.out.println("\n--- Switching to PayPal Payment ---");
        context.setPaymentStrategy(new PayPalPayment("ashish.kumar@cognizant.com"));
        context.executePayment(12500.00);
    }
}
