package io.heynow.sink.email.service;

import lombok.Data;
import org.simplejavamail.mailer.config.TransportStrategy;

import java.net.URI;

@Data
public class SmtpEmailServiceProperties {
    private URI host;
    private int port;
    private String username;
    private String password;
    private String fromName;
    private String fromAddress;
    private TransportStrategy transport = TransportStrategy.SMTP_PLAIN;
}
