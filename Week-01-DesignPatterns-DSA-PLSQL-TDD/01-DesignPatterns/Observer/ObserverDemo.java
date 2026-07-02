package observer;

public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("--- Observer Pattern Demo ---");
        
        StockMarket tcsStock = new StockMarket("TCS", 3850.00);

        Investor investor1 = new RetailInvestor("Ashish");
        Investor investor2 = new RetailInvestor("Rahul");

        tcsStock.registerInvestor(investor1);
        tcsStock.registerInvestor(investor2);

        System.out.println("Updating TCS stock price to ₹3910.50...");
        tcsStock.setPrice(3910.50);

        System.out.println("\nRahul unsubscribes from notifications...");
        tcsStock.removeInvestor(investor2);

        System.out.println("Updating TCS stock price to ₹3950.00...");
        tcsStock.setPrice(3950.00);
    }
}
