package com.ghtk.thanhnh157.services.impl;

import com.ghtk.thanhnh157.constants.WarehouseStatus;
import com.ghtk.thanhnh157.exceptions.NotFoundException;
import com.ghtk.thanhnh157.models.entities.WarehouseEntity;
import com.ghtk.thanhnh157.repositories.WarehouseRepository;
import com.ghtk.thanhnh157.services.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseRepository warehouseRepository;

    @Override
    public List<WarehouseEntity> get() {
        return warehouseRepository.findAll();
    }

    @Override
    public WarehouseEntity getById(Integer id) {
        return warehouseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy warehouse với id này!"));
    }

    @Override
    public WarehouseEntity save(WarehouseEntity warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public WarehouseEntity put(WarehouseEntity warehouse) {
        return warehouseRepository.save(warehouse);
    }

    @Override
    public void deleteById(Integer id) {
        WarehouseEntity warehouse = warehouseRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy warehouse với id này!"));
//        warehouseRepository.delete(product);
        warehouse.setStatus(WarehouseStatus.INACTIVE);
        warehouseRepository.save(warehouse);
    }
}
