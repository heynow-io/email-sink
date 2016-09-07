package io.heynow.sink.email.configuration;

import io.heynow.sink.email.service.EmailService;
import io.heynow.sink.email.service.EmailServiceProperties;
import io.heynow.sink.email.service.impl.SmtpEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
        value = "provider",
        prefix = "heynow.sink.email",
        havingValue = "SMTP"
)
public class SmtpEmailServiceConfiguration {

    @Autowired
    private EmailServiceProperties properties;

    @Bean
    public EmailService smtpEmailService() {
        return new SmtpEmailService(properties.getSmtp());
    }
}
