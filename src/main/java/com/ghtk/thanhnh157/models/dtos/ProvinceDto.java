package com.ghtk.thanhnh157.models.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class ProvinceDto {
    private Integer id;

    @NotBlank(message = "Code tỉnh không được để trống!")
    private String code;

    @NotBlank(message = "Tên tỉnh không được để trống!")
    @Length(min = 1, max = 255, message = "Tên tỉnh không quá 255 ký tự!")
    private String name;
}
