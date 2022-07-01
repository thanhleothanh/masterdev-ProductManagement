package com.ghtk.thanhnh157.services.impl;

import com.ghtk.thanhnh157.exceptions.NotFoundException;
import com.ghtk.thanhnh157.models.entities.ProvinceEntity;
import com.ghtk.thanhnh157.repositories.ProvinceRepository;
import com.ghtk.thanhnh157.services.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public List<ProvinceEntity> get() {
        return provinceRepository.findAll();
    }

    @Override
    public ProvinceEntity getById(Integer id) {
        return provinceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy province với id này!"));
    }

    @Override
    public ProvinceEntity save(ProvinceEntity province) {
        return provinceRepository.save(province);
    }

    @Override
    public ProvinceEntity put(ProvinceEntity province) {
        return provinceRepository.save(province);
    }

    @Override
    public void deleteById(Integer id) {
        ProvinceEntity province = provinceRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy province với id này!"));
//        provinceRepository.delete(product);
        provinceRepository.save(province);
    }
}
