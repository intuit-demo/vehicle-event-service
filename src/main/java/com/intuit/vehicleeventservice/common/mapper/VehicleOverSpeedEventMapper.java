package com.intuit.vehicleeventservice.common.mapper;

import com.intuit.vehicleeventservice.dao.entities.VehicleOverSpeedEventEntity;
import com.intuit.vehicleeventservice.service.dto.VehicleOverSpeedEvent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface VehicleOverSpeedEventMapper {
    VehicleOverSpeedEventMapper INSTANCE = Mappers.getMapper(VehicleOverSpeedEventMapper.class);

    VehicleOverSpeedEventEntity vehicleEventToEntity(VehicleOverSpeedEvent vehicleOverSpeedEvent);

    VehicleOverSpeedEvent vehicleEntityToEvent(VehicleOverSpeedEventEntity vehicleRealTimeEvent);
}
