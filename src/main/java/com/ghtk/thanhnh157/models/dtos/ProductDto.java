package com.ghtk.thanhnh157.models.dtos;

import com.ghtk.thanhnh157.constants.ProductStatus;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Data
public class ProductDto {
    private Integer id;

    @NotBlank(message = "Tên sán phẩm không được để trống!")
    @Length(min = 1, max = 100, message = "Tên sản phẩm không quá 100 ký tự!")
    private String name;

    @Positive(message = "Giá sản phẩm không được nhỏ hơn hoặc bằng 0!")
    private Double price;

    private String sku;
    private ProductStatus status;
    private String description;
    private CategoryDto category;
}
