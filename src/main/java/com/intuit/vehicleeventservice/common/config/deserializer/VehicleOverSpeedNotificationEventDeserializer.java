package com.intuit.vehicleeventservice.common.config.deserializer;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intuit.vehicleeventservice.service.dto.VehicleOverSpeedEvent;
import lombok.SneakyThrows;
import org.apache.kafka.common.serialization.Deserializer;

public class VehicleOverSpeedNotificationEventDeserializer implements Deserializer<VehicleOverSpeedEvent> {

    private ObjectMapper objectMapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @SneakyThrows
    @Override
    public VehicleOverSpeedEvent deserialize(String s, byte[] bytes) {
        return objectMapper.readValue(bytes, VehicleOverSpeedEvent.class);
    }
}
