package strategy;

public class ShoppingCart {
    private double totalAmount;

    public void addItem(String item, double price) {
        this.totalAmount += price;
        System.out.println("Added " + item + " (₹" + price + ") to cart.");
    }

    public void checkout(PaymentStrategy paymentMethod) {
        if (totalAmount == 0) {
            System.out.println("Cart is empty!");
            return;
        }
        paymentMethod.pay(totalAmount);
        totalAmount = 0; // Clear cart after payment
    }
}
