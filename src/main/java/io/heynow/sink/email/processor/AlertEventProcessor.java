package io.heynow.sink.email.processor;

import io.heynow.sink.email.model.AlertEvent;

public interface AlertEventProcessor {
    void process(AlertEvent alertEvent);
}
