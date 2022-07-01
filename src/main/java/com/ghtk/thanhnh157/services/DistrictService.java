package com.ghtk.thanhnh157.services;

import com.ghtk.thanhnh157.models.entities.DistrictEntity;

import java.util.List;

public interface DistrictService {
    List<DistrictEntity> get();

    DistrictEntity getById(Integer id);

    DistrictEntity save(DistrictEntity district);

    DistrictEntity put(DistrictEntity district);

    void deleteById(Integer id);
}
