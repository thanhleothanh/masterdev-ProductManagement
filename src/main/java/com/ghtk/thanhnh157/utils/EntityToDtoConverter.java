package com.ghtk.thanhnh157.utils;

import com.ghtk.thanhnh157.models.dtos.*;
import com.ghtk.thanhnh157.models.entities.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EntityToDtoConverter {
    @Autowired
    private ModelMapper modelMapper;

    public ProductDto convertToDto(ProductEntity productEntity) {
        return modelMapper.map(productEntity, ProductDto.class);
    }

    public List<ProductDto> convertToListProductDto(List<ProductEntity> productEntity) {
        List<ProductDto> listProductDto = new ArrayList<>();
        for (ProductEntity product : productEntity) {
            listProductDto.add(modelMapper.map(product, ProductDto.class));
        }
        return listProductDto;
    }

    public CategoryDto convertToDto(CategoryEntity categoryEntity) {
        return modelMapper.map(categoryEntity, CategoryDto.class);
    }

    public List<CategoryDto> convertToListCategoryDto(List<CategoryEntity> categoryEntity) {
        List<CategoryDto> listCategoryDto = new ArrayList<>();
        for (CategoryEntity category : categoryEntity) {
            listCategoryDto.add(modelMapper.map(category, CategoryDto.class));
        }
        return listCategoryDto;
    }

    public WarehouseDto convertToDto(WarehouseEntity warehouseEntity) {
        return modelMapper.map(warehouseEntity, WarehouseDto.class);
    }

    public List<WarehouseDto> convertToListWarehouseDto(List<WarehouseEntity> warehouseEntity) {
        List<WarehouseDto> listWarehouseDto = new ArrayList<>();
        for (WarehouseEntity warehouse : warehouseEntity) {
            listWarehouseDto.add(modelMapper.map(warehouse, WarehouseDto.class));
        }
        return listWarehouseDto;
    }

    public ProvinceDto convertToDto(ProvinceEntity provinceEntity) {
        return modelMapper.map(provinceEntity, ProvinceDto.class);
    }

    public List<ProvinceDto> convertToListProvinceDto(List<ProvinceEntity> provinceEntity) {
        List<ProvinceDto> listProvinceDto = new ArrayList<>();
        for (ProvinceEntity province : provinceEntity) {
            listProvinceDto.add(modelMapper.map(province, ProvinceDto.class));
        }
        return listProvinceDto;
    }

    public DistrictDto convertToDto(DistrictEntity districtEntity) {
        return modelMapper.map(districtEntity, DistrictDto.class);
    }

    public List<DistrictDto> convertToListDistrictDto(List<DistrictEntity> districtEntity) {
        List<DistrictDto> listDistrictDto = new ArrayList<>();
        for (DistrictEntity district : districtEntity) {
            listDistrictDto.add(modelMapper.map(district, DistrictDto.class));
        }
        return listDistrictDto;
    }
}
