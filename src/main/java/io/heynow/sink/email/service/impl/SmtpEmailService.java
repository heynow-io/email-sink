package io.heynow.sink.email.service.impl;

import io.heynow.sink.email.service.EmailService;
import io.heynow.sink.email.service.SmtpEmailServiceProperties;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.ServerConfig;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ciffer on 04.09.2016.
 */
public class SmtpEmailService implements EmailService {

    private final SmtpEmailServiceProperties properties;
    private final Mailer mailer;

    @Autowired
    public SmtpEmailService(SmtpEmailServiceProperties properties) {
        this.properties = properties;
        this.mailer = new Mailer(
                new ServerConfig(
                        properties.getHost().toString(),
                        properties.getPort(),
                        properties.getUsername(),
                        properties.getPassword()
                ),
                properties.getTransport()
        );
    }

    @Override
    public void sendEmail(String recipient, String subject, String payload) {
        Email email = new EmailBuilder()
                .from(properties.getFromName() != null ? properties.getFromName() : properties.getFromAddress(), properties.getFromAddress())
                .to(recipient, recipient)
                .subject(subject)
                .textHTML(payload)
                .build();

        mailer.sendMail(email);
    }
}
