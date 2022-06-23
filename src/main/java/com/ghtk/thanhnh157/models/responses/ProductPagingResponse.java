package com.ghtk.thanhnh157.models.responses;

import com.ghtk.thanhnh157.models.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class ProductPagingResponse {
    private Integer count;
    private Integer page;
    private Integer pageSize;
    private Integer pageTotal;
    private List<ProductEntity> products;
}
