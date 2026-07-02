package assignments.miniproject;

import java.util.ArrayList;
import java.util.List;

// Mini Project: Integrating OOP, Design Patterns (Factory & Strategy), and Collections
interface FoodItem {
    String getName();
    double getPrice();
}

class Pizza implements FoodItem {
    public String getName() { return "Margherita Pizza"; }
    public double getPrice() { return 350.00; }
}

class Burger implements FoodItem {
    public String getName() { return "Cheese Veggie Burger"; }
    public double getPrice() { return 150.00; }
}

class FoodFactory {
    public static FoodItem createFoodItem(String type) {
        if ("PIZZA".equalsIgnoreCase(type)) return new Pizza();
        if ("BURGER".equalsIgnoreCase(type)) return new Burger();
        throw new IllegalArgumentException("Item not available: " + type);
    }
}

interface PaymentOption {
    void pay(double amount);
}

class UPIPaymentOption implements PaymentOption {
    private String upiId;
    public UPIPaymentOption(String upiId) { this.upiId = upiId; }
    public void pay(double amount) {
        System.out.println("[PAID] ₹" + amount + " debited via UPI ID: " + upiId);
    }
}

public class OnlineFoodOrderSystem {
    private List<FoodItem> orderCart = new ArrayList<>();

    public void addToCart(String itemType) {
        FoodItem item = FoodFactory.createFoodItem(itemType);
        orderCart.add(item);
        System.out.println("Added to Cart: " + item.getName() + " (₹" + item.getPrice() + ")");
    }

    public void checkout(PaymentOption paymentOption) {
        double total = orderCart.stream().mapToDouble(FoodItem::getPrice).sum();
        System.out.println("\n--- Order Summary ---");
        orderCart.forEach(item -> System.out.println("- " + item.getName() + ": ₹" + item.getPrice()));
        System.out.println("Total Amount Payable: ₹" + total);
        paymentOption.pay(total);
        orderCart.clear();
    }

    public static void main(String[] args) {
        System.out.println("=== Cognizant Food Delivery Mini Project ===");
        OnlineFoodOrderSystem orderSystem = new OnlineFoodOrderSystem();
        
        orderSystem.addToCart("PIZZA");
        orderSystem.addToCart("BURGER");
        orderSystem.addToCart("PIZZA");

        orderSystem.checkout(new UPIPaymentOption("ashish@icici"));
    }
}
