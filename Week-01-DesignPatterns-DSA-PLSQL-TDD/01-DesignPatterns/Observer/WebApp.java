package observer;

public class WebApp implements Investor {
    private final String dashboardId;

    public WebApp(String dashboardId) {
        this.dashboardId = dashboardId;
    }

    @Override
    public void update(String stockSymbol, double newPrice) {
        System.out.printf("[WEB DASHBOARD %s] Live Chart Updated: Symbol %s trading at ₹%,.2f%n", dashboardId, stockSymbol, newPrice);
    }
}
