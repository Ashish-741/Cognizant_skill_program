package week1.designpatterns.command;

// Invoker class triggering the command without knowing receiver details
public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        if (command == null) {
            System.out.println("[REMOTE ERROR] No command assigned to button!");
            return;
        }
        System.out.println("[REMOTE INVOKER] Button pressed!");
        command.execute();
    }
}
