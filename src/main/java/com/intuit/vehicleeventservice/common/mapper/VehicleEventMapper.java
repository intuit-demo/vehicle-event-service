package com.intuit.vehicleeventservice.common.mapper;

import com.intuit.vehicleeventservice.dao.entities.VehicleEntity;
import com.intuit.vehicleeventservice.service.dto.VehicleEvent;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VehicleEventMapper {
    VehicleEventMapper INSTANCE = Mappers.getMapper(VehicleEventMapper.class);

    @Mapping(target = "vehicleEntityId.registrationNumber", source = "registrationNumber")
    @Mapping(target = "vehicleEntityId.district", source = "district")
    VehicleEntity vehicleEventToEntity(VehicleEvent vehicleEvent);

    @Mapping(source = "vehicleEntityId.registrationNumber", target = "registrationNumber")
    @Mapping(source = "vehicleEntityId.district", target = "district")
    VehicleEvent vehicleEntityToEvent(VehicleEntity vehicleRealTimeEvent);

    List<VehicleEvent> vehicleEntityToEvents(List<VehicleEntity> vehicleRealTimeEvent);
}
