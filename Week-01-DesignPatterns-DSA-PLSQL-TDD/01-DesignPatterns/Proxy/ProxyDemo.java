package week1.designpatterns.proxy;

public class ProxyDemo {
    public static void main(String[] args) {
        System.out.println("=== Exercise 6: Testing Proxy Pattern with Image Viewer Application ===");

        // Initialize proxy image (instantaneous, no network download)
        Image image1 = new ProxyImage("cognizant_dns_architecture_diagram.png");

        // 1. First display call will trigger network download & caching
        System.out.println("\n--- First Call to display() ---");
        image1.display();

        // 2. Second display call will use cached in-memory image immediately
        System.out.println("\n--- Second Call to display() ---");
        image1.display();
    }
}
