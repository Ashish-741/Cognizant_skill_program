package week1.designpatterns.adapter;

// Target Interface expected by client application
public interface PaymentProcessor {
    void processPayment(double amount);
}
