package io.heynow.sink.email;

import com.sendgrid.*;

import java.io.IOException;

public class SendGridService implements EmailService {

    private final SendGrid sendGrid;
    private final Email sender;

    public SendGridService(SendGrid sendGrid, String sender) {
        this.sendGrid = sendGrid;
        this.sender = new Email(sender);
    }

    @Override
    public void sendEmail(String recipient, String subject, String payload) {
        Email to = new Email(recipient);
        Content content = new Content("text/plain", payload);
        Mail message = new Mail(sender, subject, to, content);

        Request request = new Request();
        try {
            request.method = Method.POST;
            request.endpoint = "mail/send";
            request.body = message.build();
            Response response = sendGrid.api(request);
            System.out.println(response.statusCode);
            System.out.println(response.body);
            System.out.println(response.headers);
        } catch (IOException ex) {
            throw new RuntimeException("HEHE", ex);
        }
    }
}
