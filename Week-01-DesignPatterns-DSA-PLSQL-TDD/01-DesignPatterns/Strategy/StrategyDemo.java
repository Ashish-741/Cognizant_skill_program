package strategy;

public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("--- Strategy Pattern Demo ---");
        
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Java Design Patterns Book", 650.00);
        cart.addItem("Wireless Mouse", 850.00);

        System.out.println("\nChecking out using UPI:");
        cart.checkout(new UPIPayment("ashish@okhdfcbank"));

        System.out.println("\nAdding new item and checking out using Credit Card:");
        cart.addItem("Mechanical Keyboard", 3200.00);
        cart.checkout(new CreditCardPayment("4532789012345678", "Ashish Kumar"));
    }
}
