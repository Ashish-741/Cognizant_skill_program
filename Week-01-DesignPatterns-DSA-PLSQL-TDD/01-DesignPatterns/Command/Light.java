package week1.designpatterns.command;

// Receiver class containing actual hardware execution logic
public class Light {
    private final String location;

    public Light(String location) {
        this.location = location;
    }

    public void turnOn() {
        System.out.println("[LIGHT RECEIVER] " + location + " Light is turned ON (Brightness: 100%).");
    }

    public void turnOff() {
        System.out.println("[LIGHT RECEIVER] " + location + " Light is turned OFF (Power Saving Mode).");
    }
}
