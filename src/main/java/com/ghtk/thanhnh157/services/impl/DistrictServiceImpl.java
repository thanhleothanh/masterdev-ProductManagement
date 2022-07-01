package com.ghtk.thanhnh157.services.impl;

import com.ghtk.thanhnh157.exceptions.NotFoundException;
import com.ghtk.thanhnh157.models.entities.DistrictEntity;
import com.ghtk.thanhnh157.repositories.DistrictRepository;
import com.ghtk.thanhnh157.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public List<DistrictEntity> get() {
        return districtRepository.findAll();
    }

    @Override
    public DistrictEntity getById(Integer id) {
        return districtRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy district với id này!"));
    }

    @Override
    public DistrictEntity save(DistrictEntity district) {
        return districtRepository.save(district);
    }

    @Override
    public DistrictEntity put(DistrictEntity district) {
        return districtRepository.save(district);
    }

    @Override
    public void deleteById(Integer id) {
        DistrictEntity district = districtRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy district với id này!"));
//        districtRepository.delete(product);
        districtRepository.save(district);
    }
}
