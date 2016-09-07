package io.heynow.sink.email.configuration;

import io.heynow.sink.email.service.EmailService;
import io.heynow.sink.email.service.EmailServiceProperties;
import io.heynow.sink.email.service.impl.SystemOutEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(
        value = "provider",
        prefix = "heynow.sink.email",
        havingValue = "SYSTEM_OUT",
        matchIfMissing = true
)
public class SystemOutEmailServiceConfiguration {

    @Autowired
    private EmailServiceProperties properties;

    @Bean
    public EmailService mockEmailService() {
        return new SystemOutEmailService(properties.getSystemOut());
    }
}
