package observer;

public interface Stock {
    void registerObserver(Investor observer);
    void deregisterObserver(Investor observer);
    void notifyObservers();
}
