package com.ghtk.thanhnh157.utils;

import com.ghtk.thanhnh157.models.dtos.CategoryDto;
import com.ghtk.thanhnh157.models.dtos.ProductDto;
import com.ghtk.thanhnh157.models.entities.CategoryEntity;
import com.ghtk.thanhnh157.models.entities.ProductEntity;
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

    public List<CategoryDto> convertToListCategoryDto(List<CategoryDto> categoryEntity) {
        List<CategoryDto> listCategoryDto = new ArrayList<>();
        for (CategoryDto categoryDto : categoryEntity) {
            listCategoryDto.add(modelMapper.map(categoryDto, CategoryDto.class));
        }
        return listCategoryDto;
    }

}
