package com.intuit.vehicleeventservice.controller;

import com.intuit.vehicleeventservice.service.VehicleEventService;
import com.intuit.vehicleeventservice.service.dto.VehicleEvent;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/intuit/")
public class VehicleEventController {

    private final VehicleEventService vehicleEventService;

    public VehicleEventController(@Qualifier("vehicleEventService") VehicleEventService vehicleEventService) {
        this.vehicleEventService = vehicleEventService;
    }

    @GetMapping(value = "vehicle/{district}")
    public List<VehicleEvent> getByDistrict(@PathVariable String district) {
        return vehicleEventService.getListBy(district);
    }
}
