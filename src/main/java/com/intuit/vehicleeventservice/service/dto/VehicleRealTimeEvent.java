package com.intuit.vehicleeventservice.service.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehicleRealTimeEvent implements Serializable {

    private String id;
    private String uuid;
    private String registrationNumber;
    private Double latitude;
    private Double longitude;
    private String status;
    private Double speed;
    private Double fuel;
    private String timestamp;
    private LastKnowGeoLocation lastKnowGeoLocation;

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LastKnowGeoLocation {
        private Double latitude;
        private Double longitude;
    }

}
