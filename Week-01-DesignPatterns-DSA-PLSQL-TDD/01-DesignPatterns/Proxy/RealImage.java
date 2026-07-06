package week1.designpatterns.proxy;

public class RealImage implements Image {
    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer(fileName);
    }

    private void loadFromRemoteServer(String fileName) {
        System.out.println("[SERVER] Loading high-res image from remote AWS S3 bucket: " + fileName + " (Simulating 3s network latency...)");
        try {
            Thread.sleep(1000); // Simulated delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void display() {
        System.out.println("[DISPLAY] Rendering Image on screen: " + fileName);
    }
}
