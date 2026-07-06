package week2.assignments;

import java.util.*;
import java.util.stream.Collectors;

class Order {
    private String orderId;
    private String customerName;
    private double amount;
    private String status; // "PENDING", "DELIVERED", "CANCELLED"

    public Order(String orderId, String customerName, double amount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.amount = amount;
        this.status = status;
    }

    public String getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public double getAmount() { return amount; }
    public String getStatus() { return status; }

    @Override
    public String toString() {
        return String.format("Order [%s] by %s | Amount: ₹%,.2f | Status: %s", orderId, customerName, amount, status);
    }
}

public class OrderProcessingStream {
    public static void main(String[] args) {
        System.out.println("=== Assignment 1: E-Commerce Order Processing via Stream API ===");

        List<Order> orders = Arrays.asList(
            new Order("ORD-001", "Ashish Kumar", "DELIVERED", 4500.00),
            new Order("ORD-002", "Priya Verma", "PENDING", 12500.00),
            new Order("ORD-003", "Rahul Sharma", "DELIVERED", 8900.00),
            new Order("ORD-004", "Sneha Nair", "CANCELLED", 2300.00),
            new Order("ORD-005", "Amit Patel", "DELIVERED", 15400.00)
        );

        // 1. Filter only DELIVERED orders
        System.out.println("\n1. Delivered Orders:");
        List<Order> deliveredOrders = orders.stream()
                .filter(o -> o.getStatus().equalsIgnoreCase("DELIVERED"))
                .collect(Collectors.toList());
        deliveredOrders.forEach(System.out::println);

        // 2. Calculate Total Delivered Revenue
        double totalRevenue = deliveredOrders.stream()
                .mapToDouble(Order::getAmount)
                .sum();
        System.out.printf("\n2. Total Revenue from Delivered Orders: ₹%,.2f\n", totalRevenue);

        // 3. Find Order with Maximum Amount using Optional
        Optional<Order> maxOrder = orders.stream()
                .max(Comparator.comparingDouble(Order::getAmount));
        
        maxOrder.ifPresent(o -> System.out.println("\n3. Highest Value Order:\n   -> " + o));
    }
}
