package com.ghtk.thanhnh157.utils.enumConverters;

import com.ghtk.thanhnh157.constants.ProductStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class ProductStatusConverter implements AttributeConverter<ProductStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(ProductStatus productStatus) {
        if (productStatus == null) return null;
        return productStatus.getStatus();
    }

    @Override
    public ProductStatus convertToEntityAttribute(Integer status) {
        if (status == null) {
            return null;
        }

        return Stream.of(ProductStatus.values())
                .filter(value -> value.getStatus() == status)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
