package com.ghtk.thanhnh157.services;


import com.ghtk.thanhnh157.models.entities.ProductEntity;
import com.ghtk.thanhnh157.models.responses.ProductPagingResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductPagingResponse get(Specification<ProductEntity> spec, HttpHeaders headers, Sort sort);

    ProductEntity getById(Integer id);

    ProductEntity save(ProductEntity product);

    ProductEntity put(ProductEntity product);

    void deleteById(Integer id);
}
