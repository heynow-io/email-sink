package io.heynow.sink.email.service.impl;

import io.heynow.sink.email.service.EmailService;
import io.heynow.sink.email.service.SystemOutEmailServiceProperties;

import java.text.MessageFormat;
import java.util.logging.Logger;

public class SystemOutEmailService implements EmailService {

    private static final Logger log = Logger.getLogger(SystemOutEmailService.class.getName());
    private final String sender;

    public SystemOutEmailService(SystemOutEmailServiceProperties properties) {
        this.sender = properties.getSender();
    }

    @Override
    public void sendEmail(String recipient, String subject, String payload) {
        log.info(
                MessageFormat.format("Sending a mock email from ''{0}'' to ''{1}'' with subject ''{2}''", sender, recipient, subject)
        );
    }
}
