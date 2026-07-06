package observer;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {
    private List<Investor> investors = new ArrayList<>();
    private String stockSymbol;
    private double price;

    public StockMarket(String stockSymbol, double price) {
        this.stockSymbol = stockSymbol;
        this.price = price;
    }

    @Override
    public void registerObserver(Investor investor) {
        investors.add(investor);
    }

    @Override
    public void deregisterObserver(Investor investor) {
        investors.remove(investor);
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        for (Investor investor : investors) {
            investor.update(stockSymbol, price);
        }
    }
}
