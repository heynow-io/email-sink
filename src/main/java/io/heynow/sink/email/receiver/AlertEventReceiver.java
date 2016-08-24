package io.heynow.sink.email.receiver;

import io.heynow.sink.email.model.AlertEvent;
import io.heynow.sink.email.processor.AlertEventProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@EnableBinding(Sink.class)
public class AlertEventReceiver {

    private final AlertEventProcessor eventProcessor;

    @Autowired
    public AlertEventReceiver(AlertEventProcessor eventProcessor) {
        this.eventProcessor = eventProcessor;
    }


    @StreamListener(Sink.INPUT)
    public void handleAlertEvent(String event) {
        log.info("Event received");
        //TODO: change received event type to common data structure with header and payload
        //TODO: extracting important data to AlertEvent
        AlertEvent alertEvent = new AlertEvent();
        alertEvent.setPayload(event);
        eventProcessor.process(alertEvent);
    }
}
