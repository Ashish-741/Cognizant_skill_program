package observer;

public class MobileApp implements Investor {
    private final String username;

    public MobileApp(String username) {
        this.username = username;
    }

    @Override
    public void update(String stockSymbol, double newPrice) {
        System.out.printf("[MOBILE APP] Push Notification to %s: Stock %s is now ₹%,.2f%n", username, stockSymbol, newPrice);
    }
}
