package com.ghtk.thanhnh157.models.dtos;

import com.ghtk.thanhnh157.constants.CategoryStatus;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class CategoryDto {
    private Integer id;

    @NotBlank(message = "Tên loại không được để trống!")
    @Length(min = 1, max = 200, message = "Tên loại không quá 200 ký tự!")
    private String name;

    @NotBlank(message = "Tên loại không được để trống!")
    private String code;

    private CategoryStatus status;
    private String description;
}
