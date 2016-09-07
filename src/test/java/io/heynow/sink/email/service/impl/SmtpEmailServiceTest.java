package io.heynow.sink.email.service.impl;

import com.dumbster.smtp.SimpleSmtpServer;
import com.dumbster.smtp.SmtpMessage;
import io.heynow.sink.email.service.EmailService;
import io.heynow.sink.email.service.SmtpEmailServiceProperties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.text.MessageFormat;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Ciffer on 04.09.2016.
 */
public class SmtpEmailServiceTest {

    public static final int SMTP_PORT = 2763;
    private SimpleSmtpServer smtpServer;
    private EmailService service;

    public SmtpEmailServiceTest() {
        service = new SmtpEmailService(getProperties());
    }

    @Before
    public void prepareSmtpServer() {
        smtpServer = SimpleSmtpServer.start(SMTP_PORT);
    }

    @After
    public void stopSmtpServer() {
        smtpServer.stop();
    }

    @Test
    public void sendEmail_shouldSendToPassedRecipient() {
        //given
        String recipient = "recipient@test.com";
        String expectedToHeader = MessageFormat.format("\"{0}\" <{0}>", recipient);

        //when
        service.sendEmail(recipient, "TEST SUBJECT", "TEST CONTENT");

        //then
        assertThat(smtpServer.getReceivedEmailSize()).isEqualTo(1);
        SmtpMessage email = (SmtpMessage) smtpServer.getReceivedEmail().next();
        assertThat(email.getHeaderValue("To")).isEqualTo(expectedToHeader);
    }

    @Test
    public void sendEmail_shouldSendWithPassedSubject() {
        //given
        String subject = "EXPECTED";

        //when
        service.sendEmail("TEST@test.com", subject, "TEST CONTENT");

        //then
        assertThat(smtpServer.getReceivedEmailSize()).isEqualTo(1);
        SmtpMessage email = (SmtpMessage) smtpServer.getReceivedEmail().next();
        assertThat(email.getHeaderValue("Subject")).isEqualTo(subject);
    }

    @Test
    public void sendEmail_shouldSendWithPassedPayload() {
        //given
        String payload = "Payload";

        //when
        service.sendEmail("TEST@test.com", "TEST SUBJECT", payload);

        //then
        assertThat(smtpServer.getReceivedEmailSize()).isEqualTo(1);
        SmtpMessage email = (SmtpMessage) smtpServer.getReceivedEmail().next();
        assertThat(stripMultipartData(email.getBody())).isEqualTo(payload);
    }


    private SmtpEmailServiceProperties getProperties() {
        SmtpEmailServiceProperties properties = new SmtpEmailServiceProperties();
        properties.setHost(URI.create("localhost"));
        properties.setPort(SMTP_PORT);
        properties.setUsername("TESTUSER");
        properties.setPassword("TESTPASS");
        return properties;
    }

    private String stripMultipartData(String source) {
        return source.replaceAll("------=.*\\n?", "");
    }

}