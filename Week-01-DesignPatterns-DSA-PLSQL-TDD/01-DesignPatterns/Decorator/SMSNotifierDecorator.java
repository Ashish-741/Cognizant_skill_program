package week1.designpatterns.decorator;

public class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier wrappedNotifier) {
        super(wrappedNotifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMS(message);
    }

    private void sendSMS(String message) {
        System.out.println("[SMS DECORATOR] Also broadcasting SMS alert to mobile (+91-9876543210) | Content: " + message);
    }
}
