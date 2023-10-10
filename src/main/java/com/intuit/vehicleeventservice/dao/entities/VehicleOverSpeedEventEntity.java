package com.intuit.vehicleeventservice.dao.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "intuit.overspeed.vehicleevents")
public class VehicleOverSpeedEventEntity {

    @Id
    private String id;
    private String uuid;
    private String registrationNumber;
    private Double latitude;
    private Double longitude;
    private String status;
    private Double speed;
    private Double fuel;
    private Double distance;
    private String timestamp;
}
