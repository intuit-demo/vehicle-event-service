package com.intuit.vehicleeventservice.service.vehicle;

import com.intuit.vehicleeventservice.common.mapper.VehicleRealTimeEventMapper;
import com.intuit.vehicleeventservice.dao.repositories.VehicleRealTimeEventRepository;
import com.intuit.vehicleeventservice.service.VehicleEventService;
import com.intuit.vehicleeventservice.service.dto.VehicleRealTimeEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@Qualifier("vehicleRealTimeEventService")
public class VehicleRealTimeEventService implements VehicleEventService<VehicleRealTimeEvent, String> {

    private final VehicleRealTimeEventRepository vehicleRealTimeEventRepository;

    public VehicleRealTimeEventService(VehicleRealTimeEventRepository vehicleRealTimeEventRepository) {
        this.vehicleRealTimeEventRepository = vehicleRealTimeEventRepository;
    }

    @Override
    public VehicleRealTimeEvent save(VehicleRealTimeEvent event) {

        var en = vehicleRealTimeEventRepository.save(VehicleRealTimeEventMapper
                .INSTANCE.vehicleEventToEntity(event));

        log.info("saving VehicleRealTimeEvent :: {}", en);

        return VehicleRealTimeEventMapper.INSTANCE.vehicleEntityToEvent(en);
    }

    @Override
    public VehicleRealTimeEvent getBy(String id) {
        return null;
    }

    @Override
    public List<VehicleRealTimeEvent> getListBy(String id) {
        return null;
    }

}
