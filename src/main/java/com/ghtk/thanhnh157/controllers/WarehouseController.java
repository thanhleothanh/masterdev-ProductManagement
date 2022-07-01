package com.ghtk.thanhnh157.controllers;

import com.ghtk.thanhnh157.models.dtos.WarehouseDto;
import com.ghtk.thanhnh157.models.entities.DistrictEntity;
import com.ghtk.thanhnh157.models.entities.ProvinceEntity;
import com.ghtk.thanhnh157.models.entities.WarehouseEntity;
import com.ghtk.thanhnh157.models.responses.CommonResponse;
import com.ghtk.thanhnh157.services.impl.DistrictServiceImpl;
import com.ghtk.thanhnh157.services.impl.ProvinceServiceImpl;
import com.ghtk.thanhnh157.services.impl.WarehouseServiceImpl;
import com.ghtk.thanhnh157.utils.DtoToEntityConverter;
import com.ghtk.thanhnh157.utils.EntityToDtoConverter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Log4j2
@RequestMapping(path = "api/v1/warehouses")
public class WarehouseController {
    @Autowired
    private WarehouseServiceImpl warehouseService;
    @Autowired
    private DistrictServiceImpl districtService;
    @Autowired
    private ProvinceServiceImpl provinceService;
    @Autowired
    private DtoToEntityConverter dtoToEntityConverter;
    @Autowired
    private EntityToDtoConverter entityToDtoConverter;

    @GetMapping("")
    public ResponseEntity<CommonResponse> get() {
        List<WarehouseDto> warehouseDtoResponse = entityToDtoConverter.convertToListWarehouseDto(warehouseService.get());
        CommonResponse response = new CommonResponse(true, "Sucess", warehouseDtoResponse, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommonResponse> getById(@PathVariable(value = "id") int id) {
        WarehouseDto warehouseDtoResponse = entityToDtoConverter.convertToDto(warehouseService.getById(id));
        CommonResponse response = new CommonResponse(true, "Sucess", warehouseDtoResponse, null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<CommonResponse> save(@Validated @RequestBody WarehouseDto warehouseDto) {
        DistrictEntity districEntity = districtService.getById(warehouseDto.getDistrict().getId());
        ProvinceEntity provinceEntity = provinceService.getById(warehouseDto.getProvince().getId());
        WarehouseEntity warehouseEntity = dtoToEntityConverter.convertToEntity(warehouseDto);
        warehouseEntity.setDistrict(districEntity);
        warehouseEntity.setProvince(provinceEntity);

        WarehouseDto warehouseDtoResponse = entityToDtoConverter.convertToDto(warehouseService.save(warehouseEntity));
        CommonResponse response = new CommonResponse(true, "Success", warehouseDtoResponse, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("")
    public ResponseEntity<CommonResponse> put(@Validated @RequestBody WarehouseDto warehouseDto) {
        DistrictEntity districEntity = districtService.getById(warehouseDto.getDistrict().getId());
        ProvinceEntity provinceEntity = provinceService.getById(warehouseDto.getProvince().getId());
        //gọi getById Warehouse để check xem có warehouse với id trong body không nếu không thì throw not found
        WarehouseEntity warehouseEntity = warehouseService.getById(warehouseDto.getId() != null ? warehouseDto.getId() : 0);
        warehouseEntity = dtoToEntityConverter.convertToEntity(warehouseDto);
        warehouseEntity.setDistrict(districEntity);
        warehouseEntity.setProvince(provinceEntity);

        WarehouseDto warehouseDtoResponse = entityToDtoConverter.convertToDto(warehouseService.put(warehouseEntity));
        CommonResponse response = new CommonResponse(true, "Success", warehouseDtoResponse, null);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CommonResponse> delete(@PathVariable Integer id) {
        warehouseService.deleteById(id);

        CommonResponse response = new CommonResponse(true, "Warehouse set to INACTIVE!", null, null);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }
}
