package io.heynow.sink.email.service.impl;

import io.heynow.sink.email.service.EmailService;
import io.heynow.sink.email.service.SmtpEmailServiceProperties;
import lombok.extern.slf4j.Slf4j;
import org.simplejavamail.email.Email;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.Mailer;
import org.simplejavamail.mailer.config.ServerConfig;
import org.simplejavamail.mailer.config.TransportStrategy;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Ciffer on 04.09.2016.
 */
@Slf4j
public class SmtpEmailService implements EmailService {

    private final SmtpEmailServiceProperties properties;
    private final Mailer mailer;

    @Autowired
    public SmtpEmailService(SmtpEmailServiceProperties properties) {
        this.properties = properties;
        this.mailer = createMailer(properties);
    }

    private Mailer createMailer(SmtpEmailServiceProperties properties) {
        log.info("Creating mailer for host '{}:{}'", properties.getHost(), properties.getPort());

        return new Mailer(
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
        log.info("Sending email from '{}' to '{}' with subject '{}'", properties.getFromName() != null ? properties.getFromName() : properties.getFromAddress(), recipient, subject);

        Email email = new EmailBuilder()
                .from(properties.getFromName() != null ? properties.getFromName() : properties.getFromAddress(), properties.getFromAddress())
                .to(recipient, recipient)
                .subject(subject)
                .textHTML(payload)
                .build();

        mailer.sendMail(email);
    }
}
