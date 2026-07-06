package week1.designpatterns.decorator;

public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("=== Exercise 5: Testing Decorator Pattern with Notification System ===");

        // 1. Basic Email Notification
        System.out.println("\n--- Case 1: Standard Email Only ---");
        Notifier simpleEmail = new EmailNotifier();
        simpleEmail.send("System Maintenance Scheduled for Midnight.");

        // 2. Email decorated with SMS
        System.out.println("\n--- Case 2: Email + SMS ---");
        Notifier emailAndSms = new SMSNotifierDecorator(new EmailNotifier());
        emailAndSms.send("Database CPU Utilization Exceeded 85%.");

        // 3. Email decorated with SMS AND Slack (Multi-level wrapping)
        System.out.println("\n--- Case 3: Email + SMS + Slack (Full Broadcast) ---");
        Notifier allChannels = new SlackNotifierDecorator(
                                   new SMSNotifierDecorator(
                                       new EmailNotifier()
                                   )
                               );
        allChannels.send("CRITICAL: Production Server Cluster Reboot Required Immediately!");
    }
}
