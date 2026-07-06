package week1.designpatterns.command;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("[COMMAND] Executing LightOnCommand...");
        light.turnOn();
    }
}
