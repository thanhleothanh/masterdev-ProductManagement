package com.ghtk.thanhnh157.models.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Data
public class DistrictDto {
    private Integer id;

    @NotBlank(message = "Code quận huyện không được để trống!")
    private String code;

    @NotBlank(message = "Tên quận huyện không được để trống!")
    @Length(min = 1, max = 255, message = "Tên quận huyện không quá 255 ký tự!")
    private String name;
}
