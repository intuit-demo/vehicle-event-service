package com.intuit.vehicleeventservice.dao.repositories;

import com.intuit.vehicleeventservice.dao.entities.VehicleEntity;
import com.intuit.vehicleeventservice.dao.entities.VehicleRealTimeEventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<VehicleEntity, VehicleEntity.VehicleEntityId> {
}
