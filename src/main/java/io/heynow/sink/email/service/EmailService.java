package io.heynow.sink.email.service;

public interface EmailService {
    void sendEmail(String recipient, String subject, String payload);
}
