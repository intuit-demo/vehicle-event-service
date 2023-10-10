package com.intuit.vehicleeventservice.dao.repositories;

import com.intuit.vehicleeventservice.dao.entities.VehicleRealTimeEventEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRealTimeEventRepository extends MongoRepository<VehicleRealTimeEventEntity, String> {
}
