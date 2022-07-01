package com.ghtk.thanhnh157.services;

import com.ghtk.thanhnh157.models.entities.ProvinceEntity;

import java.util.List;

public interface ProvinceService {
    List<ProvinceEntity> get();

    ProvinceEntity getById(Integer id);

    ProvinceEntity save(ProvinceEntity province);

    ProvinceEntity put(ProvinceEntity province);

    void deleteById(Integer id);
}
