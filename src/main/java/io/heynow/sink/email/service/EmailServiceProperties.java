package io.heynow.sink.email.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

@Data
@ConfigurationProperties("heynow.sink.email")
public class EmailServiceProperties {
    private EmailSinkProvider provider = EmailSinkProvider.SYSTEM_OUT;

    @NestedConfigurationProperty
    private SmtpEmailServiceProperties smtp;

    @NestedConfigurationProperty
    private SystemOutEmailServiceProperties systemOut;

    private enum EmailSinkProvider {
        SYSTEM_OUT, SMTP
    }
}
