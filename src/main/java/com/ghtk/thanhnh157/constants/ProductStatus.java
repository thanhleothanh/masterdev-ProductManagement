package com.ghtk.thanhnh157.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductStatus {
    INACTIVE(0),
    ACTIVE(1);
    private final int status;
}
