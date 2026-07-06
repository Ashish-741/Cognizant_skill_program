package week2.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class NotificationController {

    private MessageService primaryService;
    private MessageService fallbackService;

    // 1. Constructor Injection (Recommended by Spring for mandatory dependencies)
    @Autowired
    public NotificationController(@Qualifier("emailService") MessageService primaryService) {
        this.primaryService = primaryService;
        System.out.println("NotificationController initialized with Constructor Injection -> EmailService");
    }

    // 2. Setter Injection (Recommended for optional or swappable dependencies)
    @Autowired
    @Qualifier("smsService")
    public void setFallbackService(MessageService fallbackService) {
        this.fallbackService = fallbackService;
        System.out.println("FallbackService injected via Setter -> SMSService");
    }

    public void sendAlert(String user, String alertMsg) {
        System.out.println("\n--- Executing Notification Alert ---");
        primaryService.sendMessage(alertMsg, user + "@cognizant.com");
        fallbackService.sendMessage(alertMsg, "+91-9876543210");
    }
}
