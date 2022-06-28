package com.ghtk.thanhnh157.controllers;

import com.ghtk.thanhnh157.models.dtos.ProductDto;
import com.ghtk.thanhnh157.models.entities.CategoryEntity;
import com.ghtk.thanhnh157.models.entities.ProductEntity;
import com.ghtk.thanhnh157.models.responses.CommonResponse;
import com.ghtk.thanhnh157.models.responses.ProductPagingResponse;
import com.ghtk.thanhnh157.services.CategoryServiceImpl;
import com.ghtk.thanhnh157.services.ProductServiceImpl;
import com.ghtk.thanhnh157.utils.DtoToEntityConverter;
import com.ghtk.thanhnh157.utils.EntityToDtoConverter;
import com.ghtk.thanhnh157.utils.HttpHeadersUtils;
import lombok.extern.log4j.Log4j2;
import net.kaczmarzyk.spring.data.jpa.domain.Equal;
import net.kaczmarzyk.spring.data.jpa.domain.GreaterThan;
import net.kaczmarzyk.spring.data.jpa.domain.LessThan;
import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping(path = "api/v1/products")
public class ProductController {
    @Autowired
    private ProductServiceImpl productService;
    @Autowired
    private CategoryServiceImpl categoryService;
    @Autowired
    private DtoToEntityConverter dtoToEntityConverter;
    @Autowired
    private EntityToDtoConverter entityToDtoConverter;

    @GetMapping("")
    public ResponseEntity<CommonResponse> get(
            @And({
                    @Spec(path = "name", params = "name", spec = Like.class),
                    @Spec(path = "status", params = "status", spec = Equal.class),
                    @Spec(path = "description", params = "description", spec = Like.class),
                    @Spec(path = "categoryId", params = "categoryId", spec = Equal.class),
                    @Spec(path = "sku", params = "sku", spec = Like.class),
                    @Spec(path = "price", params = "price", spec = Equal.class),
                    @Spec(path = "price", params = "priceLt", spec = LessThan.class),
                    @Spec(path = "price", params = "priceGt", spec = GreaterThan.class),
            }) Specification<ProductEntity> spec,
            Sort sort,
            @RequestHeader HttpHeaders headers) {
        ProductPagingResponse pagingResponse = productService.get(spec, headers, sort);
        List<ProductDto> listProductDto = entityToDtoConverter.convertToListProductDto(pagingResponse.getProducts());
        CommonResponse response = new CommonResponse("Sucess", listProductDto);
        return new ResponseEntity<>(response, HttpHeadersUtils.returnHttpHeaders(pagingResponse), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getById(@PathVariable(value = "id") int id) {
        CommonResponse response = new CommonResponse("Sucess", entityToDtoConverter.convertToDto(productService.getById(id)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CommonResponse> create(@Validated @RequestBody ProductDto productDto) {
        CategoryEntity categoryEntity = categoryService.getById(productDto.getCategory().getId());

        ProductEntity productEntity = dtoToEntityConverter.convertToEntity(productDto);
        productEntity.setCategory(categoryEntity);
        CommonResponse response = new CommonResponse("Sucess", entityToDtoConverter.convertToDto(productService.save(productEntity)));
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<CommonResponse> put(@Validated @RequestBody ProductDto productDto) {
        CategoryEntity categoryEntity = categoryService.getById(productDto.getCategory().getId());
        ProductEntity productEntity = productService.getById(productDto.getId());

        productEntity = dtoToEntityConverter.convertToEntity(productDto);
        productEntity.setId(productDto.getId());
        productEntity.setCategory(categoryEntity);
        CommonResponse response = new CommonResponse("Sucess", entityToDtoConverter.convertToDto(productService.put(productEntity)));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> delete(@PathVariable Integer id) {
        productService.deleteById(id);
        CommonResponse response = new CommonResponse("Deleted resource", null);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
