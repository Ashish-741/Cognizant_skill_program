package factory;

public class NotificationFactory {
    public Notification createNotification(String channel) {
        if (channel == null || channel.trim().isEmpty()) {
            return null;
        }
        if (channel.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (channel.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        } else {
            throw new IllegalArgumentException("Unknown notification channel: " + channel);
        }
    }
}
