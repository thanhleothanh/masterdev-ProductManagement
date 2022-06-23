package com.ghtk.thanhnh157.models.entities;


import javax.persistence.*;

@Entity
@Table(name = "warehouse_product")
public class WarehouseProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer warehouse_id;
    private Integer product_id;
    private Integer inventory;
    private Integer total_import;
    private Integer total_export;
    private String start_date;
    private String expired_date;

    public WarehouseProductEntity() {
    }

    public WarehouseProductEntity(Integer warehouse_id, Integer product_id, Integer inventory, Integer total_import, Integer total_export, String start_date, String expired_date) {
        this.warehouse_id = warehouse_id;
        this.product_id = product_id;
        this.inventory = inventory;
        this.total_import = total_import;
        this.total_export = total_export;
        this.start_date = start_date;
        this.expired_date = expired_date;
    }

    public WarehouseProductEntity(Integer id, Integer warehouse_id, Integer product_id, Integer inventory, Integer total_import, Integer total_export, String start_date, String expired_date) {
        this.id = id;
        this.warehouse_id = warehouse_id;
        this.product_id = product_id;
        this.inventory = inventory;
        this.total_import = total_import;
        this.total_export = total_export;
        this.start_date = start_date;
        this.expired_date = expired_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getWarehouse_id() {
        return warehouse_id;
    }

    public void setWarehouse_id(Integer warehouse_id) {
        this.warehouse_id = warehouse_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public Integer getInventory() {
        return inventory;
    }

    public void setInventory(Integer inventory) {
        this.inventory = inventory;
    }

    public Integer getTotal_import() {
        return total_import;
    }

    public void setTotal_import(Integer total_import) {
        this.total_import = total_import;
    }

    public Integer getTotal_export() {
        return total_export;
    }

    public void setTotal_export(Integer total_export) {
        this.total_export = total_export;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getExpired_date() {
        return expired_date;
    }

    public void setExpired_date(String expired_date) {
        this.expired_date = expired_date;
    }
}
