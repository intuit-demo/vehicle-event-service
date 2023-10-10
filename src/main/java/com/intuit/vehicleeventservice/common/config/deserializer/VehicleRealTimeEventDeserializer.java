package com.intuit.vehicleeventservice.common.config.deserializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.vehicleeventservice.service.dto.VehicleRealTimeEvent;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.UUID;

public class VehicleRealTimeEventDeserializer implements Deserializer<VehicleRealTimeEvent> {

    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @SneakyThrows
    @Override
    public VehicleRealTimeEvent deserialize(String s, byte[] bytes) {
        var e = objectMapper.readValue(bytes, VehicleRealTimeEvent.class);
        e.setId(UUID.randomUUID().toString());
        return e;
    }
}
