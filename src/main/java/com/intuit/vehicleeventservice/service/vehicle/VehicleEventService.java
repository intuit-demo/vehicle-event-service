package com.intuit.vehicleeventservice.service.vehicle;

import com.intuit.vehicleeventservice.common.mapper.VehicleEventMapper;
import com.intuit.vehicleeventservice.dao.entities.VehicleEntity;
import com.intuit.vehicleeventservice.dao.repositories.VehicleRepository;
import com.intuit.vehicleeventservice.service.dto.VehicleEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Qualifier("vehicleEventService")
public class VehicleEventService implements com.intuit.vehicleeventservice.service.VehicleEventService<VehicleEvent, VehicleEntity.VehicleEntityId> {

    private final VehicleRepository vehicleRepository;

    public VehicleEventService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public VehicleEvent save(VehicleEvent event) {

        VehicleEntity vehicleEntity = new VehicleEntity();
        VehicleEntity.VehicleEntityId vehicleEntityId = new VehicleEntity.VehicleEntityId();
        String[] s = event.getRegistrationNumber().split("-");
        if(s.length > 1) {
            vehicleEntityId.setDistrict(s[0]);
            vehicleEntityId.setRegistrationNumber(s[1]);
        } else {
            vehicleEntityId.setDistrict("0");
            vehicleEntityId.setRegistrationNumber(event.getRegistrationNumber());
        }
        vehicleEntity.setVehicleEntityId(vehicleEntityId);

        var en = vehicleRepository.save(vehicleEntity);

        log.info("saving VehicleEntity :: {}", en);

        return event;
    }

    @Override
    public VehicleEvent getBy(VehicleEntity.VehicleEntityId id) {
        return null;
    }

    @Override
    public List<VehicleEvent> getListBy(String id) {

        VehicleEntity vehicleEntity = new VehicleEntity();

        VehicleEntity.VehicleEntityId exampleUser = new VehicleEntity.VehicleEntityId();
        exampleUser.setDistrict(id);
        vehicleEntity.setVehicleEntityId(exampleUser);

        Example<VehicleEntity> example = Example.of(vehicleEntity);

        var e = vehicleRepository.findAll(example);

        return VehicleEventMapper.INSTANCE.vehicleEntityToEvents(e);
    }
}
