package com.intuit.vehicleeventservice.service.dto;

import lombok.*;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VehicleEvent implements Serializable {

    private String registrationNumber;
    private String district;
}
