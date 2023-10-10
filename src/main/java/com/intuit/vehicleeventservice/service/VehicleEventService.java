package com.intuit.vehicleeventservice.service;

import java.util.List;

public interface VehicleEventService<T, I> {
    T save(T event);

    T getBy(I id);

    List<T> getListBy(String id);
}
