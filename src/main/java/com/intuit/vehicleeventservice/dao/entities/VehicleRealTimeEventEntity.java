package com.intuit.vehicleeventservice.dao.entities;

import com.intuit.vehicleeventservice.service.dto.VehicleRealTimeEvent;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "vehicle.events.topic")
public class VehicleRealTimeEventEntity {

    @Id
    private String id;
    private String uuid;
    private String registrationNumber;
    private Double latitude;
    private Double longitude;
    private String status;
    private Double speed;
    private Double fuel;
    private String timestamp;
    private VehicleRealTimeEvent.LastKnowGeoLocation lastKnowGeoLocation;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LastKnowGeoLocation {
        private Double latitude;
        private Double longitude;
    }
}
