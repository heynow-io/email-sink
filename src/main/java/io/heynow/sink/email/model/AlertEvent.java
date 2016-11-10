package io.heynow.sink.email.model;

import lombok.Data;

import java.util.Map;

@Data
public class AlertEvent {
    private long operatorId;
    private Map<String, Object> payload;
}
