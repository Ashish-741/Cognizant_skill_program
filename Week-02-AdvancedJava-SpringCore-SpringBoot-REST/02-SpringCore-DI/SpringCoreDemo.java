package week2.springcore;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringCoreDemo {
    public static void main(String[] args) {
        System.out.println("=== Spring Core IoC & Dependency Injection Demo ===");

        // 1. Initialize Spring IoC Container using Java-based Configuration
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 2. Retrieve Bean from Container
        NotificationController controller = context.getBean(NotificationController.class);

        // 3. Execute business logic
        controller.sendAlert("Ashish Kumar", "DNS 5.0 Week 2 Evaluation Scheduled for Tomorrow");

        // 4. Verify Bean Scopes (Singleton vs Prototype)
        System.out.println("\n--- Verifying Bean Scopes ---");
        MessageService email1 = context.getBean("emailService", MessageService.class);
        MessageService email2 = context.getBean("emailService", MessageService.class);
        System.out.println("EmailService is Singleton? " + (email1 == email2)); // Should print true

        MessageService sms1 = context.getBean("smsService", MessageService.class);
        MessageService sms2 = context.getBean("smsService", MessageService.class);
        System.out.println("SMSService is Singleton? " + (sms1 == sms2)); // Should print false (Prototype scope)

        // 5. Close Context
        context.close();
    }
}
