package factory;

public class SMSNotification implements Notification {
    @Override
    public void notifyUser(String recipient, String message) {
        System.out.println("[SMS] Sending SMS to " + recipient + " | Message: " + message);
    }
}
