package com.intuit.vehicleeventservice.service.kafka.listener;

import com.intuit.vehicleeventservice.service.dto.VehicleOverSpeedEvent;
import com.intuit.vehicleeventservice.service.vehicle.VehicleOverSpeedEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VehicleOverSpeedEventListener {

    private final VehicleOverSpeedEventService vehicleOverSpeedEventService;

    public VehicleOverSpeedEventListener(VehicleOverSpeedEventService vehicleOverSpeedEventService) {
        this.vehicleOverSpeedEventService = vehicleOverSpeedEventService;
    }

    @KafkaListener(topics = "${spring.kafka.consumer-vehicle-overspeed-events.topic}",
            containerFactory = "vehicleOverSpeedNotificationEventListenerContainerFactory",
            groupId = "${spring.kafka.consumer-vehicle-overspeed-events.group-id}")
    public void consumeMessage(VehicleOverSpeedEvent vehicleEvent) {

        log.info("Received VehicleOverSpeedEvent message: {}", vehicleEvent);

        vehicleOverSpeedEventService.save(vehicleEvent);
    }
}
