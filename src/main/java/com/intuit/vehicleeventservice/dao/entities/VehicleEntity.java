package com.intuit.vehicleeventservice.dao.entities;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "vehicles")
public class VehicleEntity {

    @Id
    private VehicleEntityId vehicleEntityId;

    @Data
    @ToString
    public static class VehicleEntityId {

        private String registrationNumber;

        private String district;

    }
}
