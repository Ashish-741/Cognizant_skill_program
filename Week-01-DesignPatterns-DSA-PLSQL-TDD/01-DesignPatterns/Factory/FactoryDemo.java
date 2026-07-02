package factory;

public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("--- Factory Pattern Demo ---");
        NotificationFactory factory = new NotificationFactory();

        Notification email = factory.createNotification("EMAIL");
        email.notifyUser("ashish@example.com", "Welcome to Cognizant DNS 5.0 Program!");

        Notification sms = factory.createNotification("SMS");
        sms.notifyUser("+91-9876543210", "Your OTP is 482910.");
    }
}
