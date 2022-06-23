package com.ghtk.thanhnh157.services;

import com.ghtk.thanhnh157.constants.PagingHeaders;
import com.ghtk.thanhnh157.models.entities.CategoryEntity;
import com.ghtk.thanhnh157.models.entities.ProductEntity;
import com.ghtk.thanhnh157.models.responses.ProductPagingResponse;
import com.ghtk.thanhnh157.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public ProductPagingResponse get(Specification<ProductEntity> spec, HttpHeaders headers, Sort sort) {
        if (isPaginationRequested(headers)) {
            return helperGet(spec, buildPageRequest(headers, sort));
        } else {
            List<ProductEntity> productEntities = helperGet(spec, sort);
            return new ProductPagingResponse(productEntities.size(), 0, 0, 0, productEntities);
        }
    }

    @Override
    public ProductEntity getById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(("Không tìm thấy product với id này!")));
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
                .orElseThrow(() -> new EntityNotFoundException(("Không tìm thấy product với id này!")));
        productRepository.delete(product);
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

    /**
     * util methods
     */
    private boolean isPaginationRequested(HttpHeaders headers) {
        return headers.containsKey(PagingHeaders.PAGE.getName()) && headers.containsKey(PagingHeaders.PAGE_SIZE.getName());
    }

    private Pageable buildPageRequest(HttpHeaders headers, Sort sort) {
        int page = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE.getName())).get(0));
        int size = Integer.parseInt(Objects.requireNonNull(headers.get(PagingHeaders.PAGE_SIZE.getName())).get(0));
        return PageRequest.of(page, size, sort);
    }
}
