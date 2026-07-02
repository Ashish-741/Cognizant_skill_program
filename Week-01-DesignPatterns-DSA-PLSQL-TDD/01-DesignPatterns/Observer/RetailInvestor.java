package observer;

public class RetailInvestor implements Investor {
    private String name;

    public RetailInvestor(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockSymbol, double price) {
        System.out.println("Notification for " + name + ": Stock " + stockSymbol + " is now trading at ₹" + price);
    }
}
