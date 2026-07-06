package week1.designpatterns.proxy;

public class ProxyImage implements Image {
    private RealImage realImage;
    private final String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
        System.out.println("[PROXY] ProxyImage created for: " + fileName + " (RealImage NOT loaded into RAM yet - Lazy Init)");
    }

    @Override
    public void display() {
        // Lazy initialization and caching
        if (realImage == null) {
            System.out.println("[PROXY] Cache miss! Initializing RealImage for first time...");
            realImage = new RealImage(fileName);
        } else {
            System.out.println("[PROXY] Cache hit! Using cached in-memory RealImage instance without downloading again.");
        }
        realImage.display();
    }
}
