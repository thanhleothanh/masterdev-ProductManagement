package com.ghtk.thanhnh157.utils.enumConverters;

import com.ghtk.thanhnh157.constants.WarehouseStatus;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class WarehouseStatusConverter implements AttributeConverter<WarehouseStatus, Integer> {

    @Override
    public Integer convertToDatabaseColumn(WarehouseStatus warehouseStatus) {
        if (warehouseStatus == null) return null;
        return warehouseStatus.getStatus();
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
