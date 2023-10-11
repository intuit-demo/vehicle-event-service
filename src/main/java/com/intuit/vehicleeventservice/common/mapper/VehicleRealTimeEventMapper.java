package com.intuit.vehicleeventservice.common.mapper;

import com.intuit.vehicleeventservice.dao.entities.VehicleRealTimeEventEntity;
import com.intuit.vehicleeventservice.service.dto.VehicleRealTimeEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleRealTimeEventMapper {
    VehicleRealTimeEventMapper INSTANCE = Mappers.getMapper(VehicleRealTimeEventMapper.class);

    VehicleRealTimeEventEntity vehicleEventToEntity(VehicleRealTimeEvent vehicleRealTimeEvent);

    VehicleRealTimeEvent vehicleEntityToEvent(VehicleRealTimeEventEntity vehicleRealTimeEvent);
}
