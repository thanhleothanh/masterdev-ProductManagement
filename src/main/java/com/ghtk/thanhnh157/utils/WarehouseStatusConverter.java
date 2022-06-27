package com.ghtk.thanhnh157.utils;

import com.ghtk.thanhnh157.constants.WarehouseStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class WarehouseStatusConverter implements AttributeConverter<WarehouseStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(WarehouseStatus productStatus) {
        if (productStatus == null) return null;
        return productStatus.getStatus();
    }

    @Override
    public WarehouseStatus convertToEntityAttribute(Integer status) {
        if (status == null) {
            return null;
        }

        return Stream.of(WarehouseStatus.values())
                .filter(value -> value.getStatus() == status)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
