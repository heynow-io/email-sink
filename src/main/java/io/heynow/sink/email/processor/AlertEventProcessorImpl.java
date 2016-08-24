package io.heynow.sink.email.processor;

import io.heynow.sink.email.model.AlertEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlertEventProcessorImpl implements AlertEventProcessor {
    @Override
    public void process(AlertEvent alertEvent) {
        log.info("Processing alert event: {}", alertEvent);
        //TODO: getting metadata from StreamManager/Cache
        //TODO: pass processed data to email sender
    }
}
