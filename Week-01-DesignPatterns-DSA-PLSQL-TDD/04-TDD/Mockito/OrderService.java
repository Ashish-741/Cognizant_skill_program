package tdd.mockito;

public class OrderService {
    private PaymentGateway paymentGateway;

    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public String placeOrder(String orderId, double amount) {
        if (amount <= 0) {
            return "FAILED: Invalid Order Amount";
        }
        boolean isPaid = paymentGateway.processPayment(orderId, amount);
        if (isPaid) {
            return "SUCCESS: Order Placed";
        } else {
            return "FAILED: Payment Declined";
        }
    }
}
