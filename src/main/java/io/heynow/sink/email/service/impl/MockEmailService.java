package io.heynow.sink.email;

import java.text.MessageFormat;
import java.util.logging.Logger;

public class MockEmailService implements EmailService {

    public static final Logger log = Logger.getLogger(MockEmailService.class.getName());

    private final String sender;

    public MockEmailService(String sender) {
        this.sender = sender;
    }

    @Override
    public void sendEmail(String recipient, String subject, String payload) {
        log.info(
                MessageFormat.format("Sending a mock email from '{0}' to '{1}' with subject '{2}'", sender, recipient, subject)
        );
    }
}
