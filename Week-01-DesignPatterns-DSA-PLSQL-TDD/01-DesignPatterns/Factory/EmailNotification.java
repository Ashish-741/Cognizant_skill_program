package factory;

public class EmailNotification implements Notification {
    @Override
    public void notifyUser(String recipient, String message) {
        System.out.println("[EMAIL] Sending email to " + recipient + " | Message: " + message);
    }
}
