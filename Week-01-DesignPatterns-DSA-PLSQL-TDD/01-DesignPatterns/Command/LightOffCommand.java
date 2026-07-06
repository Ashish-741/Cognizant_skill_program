package week1.designpatterns.command;

public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("[COMMAND] Executing LightOffCommand...");
        light.turnOff();
    }
}
