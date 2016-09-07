package io.heynow.sink.email.model.streammanager;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Operator {

    private String name;
    private List<Property> properties;
    private List<Operator> parents;

    public Map<String, String> getPropertyMap() {
        return properties.stream()
                .collect(Collectors.toMap(
                        Property::getName,
                        Property::getValue
                ));
    }
}