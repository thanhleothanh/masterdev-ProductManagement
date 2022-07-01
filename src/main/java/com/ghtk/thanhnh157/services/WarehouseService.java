package com.ghtk.thanhnh157.services;

import com.ghtk.thanhnh157.models.entities.WarehouseEntity;

import java.util.List;

public interface WarehouseService {
    List<WarehouseEntity> get();

    WarehouseEntity getById(Integer id);

    WarehouseEntity save(WarehouseEntity warehouse);

    WarehouseEntity put(WarehouseEntity warehouse);

    void deleteById(Integer id);
}
