package io.heynow.sink.email.receiver;

import io.heynow.sink.email.model.AlertEvent;
import io.heynow.sink.email.processor.AlertEventProcessor;
import io.heynow.stream.manager.client.facade.StreamManagerClient;
import io.heynow.stream.manager.client.model.Note;
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
    public void handleAlertEvent(Note note) {
        log.info("Event received");
        AlertEvent alertEvent = new AlertEvent();
        alertEvent.setOperatorId(note.getProcessingModel().getCurrent().getId());
        alertEvent.setPayload(note.getPayload());
        eventProcessor.process(alertEvent);
    }
}
