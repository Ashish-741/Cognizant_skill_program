package week2.springcore;

import org.springframework.stereotype.Component;

@Component("emailService")
public class EmailService implements MessageService {
    @Override
    public void sendMessage(String message, String receiver) {
        System.out.println("[EMAIL-BEAN] Sending Email to " + receiver + " | Message: " + message);
    }
}
