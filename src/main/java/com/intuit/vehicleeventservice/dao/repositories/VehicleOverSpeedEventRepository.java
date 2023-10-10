package com.intuit.vehicleeventservice.dao.repositories;

import com.intuit.vehicleeventservice.dao.entities.VehicleOverSpeedEventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleOverSpeedEventRepository extends MongoRepository<VehicleOverSpeedEventEntity, String> {
}
