package week1.designpatterns.decorator;

public class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("[EMAIL] Sending basic email notification | Content: " + message);
    }
}
