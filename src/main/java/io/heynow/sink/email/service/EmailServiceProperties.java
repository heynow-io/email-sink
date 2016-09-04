package io.heynow.sink.email.service;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * Created by Ciffer on 04.09.2016.
 */
@ConfigurationProperties("heynow.sink.email")
public class EmailServiceProperties {
    private EmailSinkProvider provider = EmailSinkProvider.SYSTEM_OUT;

    @NestedConfigurationProperty
    private SmtpEmailServiceProperties smtp;

    @NestedConfigurationProperty
    private SystemOutEmailServiceProperties systemOut;

    public EmailSinkProvider getProvider() {
        return provider;
    }

    public void setProvider(EmailSinkProvider provider) {
        this.provider = provider;
    }

    public SmtpEmailServiceProperties getSmtp() {
        return smtp;
    }

    public void setSmtp(SmtpEmailServiceProperties smtp) {
        this.smtp = smtp;
    }

    public SystemOutEmailServiceProperties getSystemOut() {
        return systemOut;
    }

    public void setSystemOut(SystemOutEmailServiceProperties systemOut) {
        this.systemOut = systemOut;
    }

    private enum EmailSinkProvider {
        SYSTEM_OUT, SMTP
    }
}
