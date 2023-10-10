package com.intuit.vehicleeventservice.service.vehicle;

import com.intuit.vehicleeventservice.common.mapper.VehicleOverSpeedEventMapper;
import com.intuit.vehicleeventservice.dao.repositories.VehicleOverSpeedEventRepository;
import com.intuit.vehicleeventservice.service.VehicleEventService;
import com.intuit.vehicleeventservice.service.dto.VehicleOverSpeedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Qualifier("vehicleOverSpeedEventService")
public class VehicleOverSpeedEventService implements VehicleEventService<VehicleOverSpeedEvent, String> {

    private final VehicleOverSpeedEventRepository vehicleOverSpeedEventRepository;

    public VehicleOverSpeedEventService(VehicleOverSpeedEventRepository vehicleOverSpeedEventRepository) {
        this.vehicleOverSpeedEventRepository = vehicleOverSpeedEventRepository;
    }

    @Override
    public VehicleOverSpeedEvent save(VehicleOverSpeedEvent event) {
        var en = vehicleOverSpeedEventRepository.save(VehicleOverSpeedEventMapper.INSTANCE.vehicleEventToEntity(event));
        log.info("saving VehicleOverSpeedEvent :: {}", en);

        return VehicleOverSpeedEventMapper.INSTANCE.vehicleEntityToEvent(en);
    }

    @Override
    public VehicleOverSpeedEvent getBy(String id) {
        return null;
    }

    @Override
    public List<VehicleOverSpeedEvent> getListBy(String id) {
        return null;
    }
}
