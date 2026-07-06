package week1.designpatterns.adapter;

// Third-party API with incompatible method signature (Adaptee 2)
public class PayPalGateway {
    public void sendPayPalFunds(double transferAmount) {
        System.out.printf("[PAYPAL API] Transferring funds via PayPal account: ₹%,.2f (Ref ID: PPL-1029)%n", transferAmount);
    }
}
