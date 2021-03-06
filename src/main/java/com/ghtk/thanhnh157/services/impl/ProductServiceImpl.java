package com.ghtk.thanhnh157.services.impl;

import com.ghtk.thanhnh157.constants.ProductStatus;
import com.ghtk.thanhnh157.exceptions.NotFoundException;
import com.ghtk.thanhnh157.models.entities.ProductEntity;
import com.ghtk.thanhnh157.models.responses.ProductPagingResponse;
import com.ghtk.thanhnh157.repositories.CategoryRepository;
import com.ghtk.thanhnh157.repositories.ProductRepository;
import com.ghtk.thanhnh157.services.ProductService;
import com.ghtk.thanhnh157.utils.PaginationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public ProductPagingResponse get(Specification<ProductEntity> spec, HttpHeaders headers, Sort sort) {
        if (PaginationUtils.isPaginationRequested(headers)) {
            return helperGet(spec, PaginationUtils.buildPageRequest(headers, sort));
        } else {
            List<ProductEntity> productEntities = helperGet(spec, sort);
            return new ProductPagingResponse(productEntities.size(), 0, 0, 0, productEntities);
        }
    }

    @Override
    public ProductEntity getById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy product với id này!"));
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public ProductEntity put(ProductEntity product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteById(Integer id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Không tìm thấy product với id này!"));
//        productRepository.delete(product);
        product.setStatus(ProductStatus.INACTIVE);
        productRepository.save(product);
    }

    /**
     * helper methods
     */
    public List<ProductEntity> helperGet(Specification<ProductEntity> spec, Sort sort) {
        return productRepository.findAll(spec, sort);
    }

    public ProductPagingResponse helperGet(Specification<ProductEntity> spec, Pageable pageable) {
        Page<ProductEntity> page = productRepository.findAll(spec, pageable);
        List<ProductEntity> productEntities = page.getContent();
        return new ProductPagingResponse((int) page.getTotalElements(), page.getNumber(), page.getNumberOfElements(), page.getTotalPages(), productEntities);
    }
}
