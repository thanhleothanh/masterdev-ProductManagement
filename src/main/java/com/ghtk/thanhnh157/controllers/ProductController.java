package com.ghtk.thanhnh157.controllers;

import com.ghtk.thanhnh157.constants.PagingHeaders;
import com.ghtk.thanhnh157.models.entities.ProductEntity;
import com.ghtk.thanhnh157.models.responses.ProductPagingResponse;
import com.ghtk.thanhnh157.services.ProductServiceImpl;
import net.kaczmarzyk.spring.data.jpa.domain.*;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductEntity>> get(
            @And({
                    @Spec(path = "name", params = "name", spec = Like.class),
                    @Spec(path = "status", params = "status", spec = Equal.class),
                    @Spec(path = "description", params = "description", spec = Like.class),
                    @Spec(path = "category_id", params = "category_id", spec = Equal.class),
                    @Spec(path = "sku", params = "sku", spec = Like.class),
                    @Spec(path = "price", params = "price", spec = Equal.class),
                    @Spec(path = "price", params = "priceLt", spec = LessThan.class),
                    @Spec(path = "price", params = "priceGt", spec = GreaterThan.class),
            }) Specification<ProductEntity> spec,
            Sort sort,
            @RequestHeader HttpHeaders headers) {
        final ProductPagingResponse response = productService.get(spec, headers, sort);
        return new ResponseEntity<>(response.getProducts(), returnHttpHeaders(response), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductEntity getById(@PathVariable(value = "id") int id) {
        return productService.getById(id);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity create(@RequestBody ProductEntity productEntity) {
        return productService.save(productEntity);
    }

    @PutMapping("")
    @ResponseStatus(HttpStatus.OK)
    public ProductEntity put(@RequestBody ProductEntity productEntity) {
        return productService.put(productEntity);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {
        productService.deleteById(id);
    }


    /**
     * util methods
     */

    public HttpHeaders returnHttpHeaders(ProductPagingResponse response) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(PagingHeaders.COUNT.getName(), String.valueOf(response.getCount()));
        headers.set(PagingHeaders.PAGE.getName(), String.valueOf(response.getPage()));
        headers.set(PagingHeaders.PAGE_SIZE.getName(), String.valueOf(response.getPageSize()));
        headers.set(PagingHeaders.PAGE_TOTAL.getName(), String.valueOf(response.getPageTotal()));
        return headers;
    }

}
