package tdd.mockito;

public interface PaymentGateway {
    boolean processPayment(String orderId, double amount);
    String getPaymentStatus(String orderId);
}
