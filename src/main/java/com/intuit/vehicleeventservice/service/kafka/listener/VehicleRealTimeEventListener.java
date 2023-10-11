package com.intuit.vehicleeventservice.service.kafka.listener;

import com.intuit.vehicleeventservice.service.dto.VehicleEvent;
import com.intuit.vehicleeventservice.service.dto.VehicleRealTimeEvent;
import com.intuit.vehicleeventservice.service.vehicle.VehicleEventService;
import com.intuit.vehicleeventservice.service.vehicle.VehicleRealTimeEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VehicleRealTimeEventListener {

    private final VehicleRealTimeEventService vehicleRealTimeEventService;
    private final VehicleEventService vehicleEventService;

    public VehicleRealTimeEventListener(VehicleRealTimeEventService vehicleRealTimeEventService, VehicleEventService vehicleEventService) {
        this.vehicleRealTimeEventService = vehicleRealTimeEventService;
        this.vehicleEventService = vehicleEventService;
    }

    @KafkaListener(topics = "${spring.kafka.consumer-vehicle-events.topic}",
            containerFactory = "vehicleRealTimeEventListenerContainerFactory",
            groupId = "${spring.kafka.consumer-vehicle-events.group-id}")
    public void consumeMessage(VehicleRealTimeEvent vehicleEvent) {

        log.info("Received message: {}", vehicleEvent);

        vehicleRealTimeEventService.save(vehicleEvent);
        VehicleEvent event = new VehicleEvent();
        event.setRegistrationNumber(vehicleEvent.getRegistrationNumber());
        vehicleEventService.save(event);
    }
}
