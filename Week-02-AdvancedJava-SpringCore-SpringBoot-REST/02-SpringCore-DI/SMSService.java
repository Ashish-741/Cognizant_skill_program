package week2.springcore;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("smsService")
@Scope("prototype") // Prototype scope creates a new instance every time requested from container
public class SMSService implements MessageService {
    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println("[SMS-BEAN] Sending SMS to " + receiver + " | Message: " + message);
    }
}
