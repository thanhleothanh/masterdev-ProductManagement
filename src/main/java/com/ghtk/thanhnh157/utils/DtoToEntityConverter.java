package com.ghtk.thanhnh157.utils;

import com.ghtk.thanhnh157.models.dtos.CategoryDto;
import com.ghtk.thanhnh157.models.dtos.ProductDto;
import com.ghtk.thanhnh157.models.entities.CategoryEntity;
import com.ghtk.thanhnh157.models.entities.ProductEntity;
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


}
