package io.heynow.sink.email.processor;

import io.heynow.sink.email.client.StreamManagerClient;
import io.heynow.sink.email.model.AlertEvent;
import io.heynow.sink.email.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
public class AlertEventProcessorImpl implements AlertEventProcessor {

    private final EmailService emailService;
    private final StreamManagerClient streamManagerClient;

    @Autowired
    public AlertEventProcessorImpl(EmailService emailService, StreamManagerClient streamManagerClient) {
        this.emailService = emailService;
        this.streamManagerClient = streamManagerClient;
    }

    @Override
    public void process(AlertEvent alertEvent) {
        log.info("Processing alert event: {}", alertEvent);
        Map<String, String> properties = streamManagerClient.getOperatorDefinition("DUMMY").getPropertyMap(); //TODO: cache
        emailService.sendEmail(
                properties.get("recipient"),
                properties.get("subject"),
                alertEvent.getPayload()
        );
    }
}
