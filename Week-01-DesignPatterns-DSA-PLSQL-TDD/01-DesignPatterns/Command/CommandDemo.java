package week1.designpatterns.command;

public class CommandDemo {
    public static void main(String[] args) {
        System.out.println("=== Exercise 9: Testing Command Pattern with Home Automation Remote Control ===");

        // Initialize hardware receiver
        Light livingRoomLight = new Light("Living Room");

        // Initialize concrete commands encapsulating the receiver
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Initialize Invoker (Remote Control)
        RemoteControl remote = new RemoteControl();

        // 1. Issue Turn ON Command
        System.out.println("\n--- Assigning and Pressing Turn ON Button ---");
        remote.setCommand(lightOn);
        remote.pressButton();

        // 2. Issue Turn OFF Command
        System.out.println("\n--- Assigning and Pressing Turn OFF Button ---");
        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
