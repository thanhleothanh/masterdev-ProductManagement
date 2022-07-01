package com.ghtk.thanhnh157.models.dtos;

import com.ghtk.thanhnh157.constants.WarehouseStatus;
import com.ghtk.thanhnh157.models.entities.ProvinceEntity;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class WarehouseDto {
    private Integer id;

    @NotBlank(message = "Tên kho không được để trống!")
    @Length(min = 1, max = 255, message = "Tên kho không quá 255 ký tự!")
    private String name;

    @NotBlank(message = "Địa chỉ không được để trống!")
    private String address;

    private WarehouseStatus status;

    @NotNull(message = "Thiếu thông tin tỉnh!")
    private ProvinceEntity province;

    @NotNull(message = "Thiếu thông tin quận huyện!")
    private DistrictDto district;
}
