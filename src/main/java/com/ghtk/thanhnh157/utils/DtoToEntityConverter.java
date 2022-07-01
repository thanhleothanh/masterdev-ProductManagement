package com.ghtk.thanhnh157.utils;

import com.ghtk.thanhnh157.models.dtos.*;
import com.ghtk.thanhnh157.models.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

@Component
public class DtoToEntityConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ProductEntity convertToEntity(ProductDto productDto) throws ParseException {
        return modelMapper.map(productDto, ProductEntity.class);
    }

    public CategoryEntity convertToEntity(CategoryDto categoryDto) throws ParseException {
        return modelMapper.map(categoryDto, CategoryEntity.class);
    }

    public WarehouseEntity convertToEntity(WarehouseDto warehouseDto) throws ParseException {
        return modelMapper.map(warehouseDto, WarehouseEntity.class);
    }

    public ProvinceEntity convertToEntity(ProvinceDto provinceDto) throws ParseException {
        return modelMapper.map(provinceDto, ProvinceEntity.class);
    }

    public DistrictEntity convertToEntity(DistrictDto districtDto) throws ParseException {
        return modelMapper.map(districtDto, DistrictEntity.class);
    }

}
