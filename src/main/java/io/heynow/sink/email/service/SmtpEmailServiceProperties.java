package io.heynow.sink.email.service;

import lombok.Data;

import java.net.URI;

@Data
public class SmtpEmailServiceProperties {
    private URI host;
    private int port;
    private String username;
    private String password;
}
