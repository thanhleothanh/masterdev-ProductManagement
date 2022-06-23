package com.ghtk.thanhnh157.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String sku;
    private Integer status;
    private String description;
    private Integer category_id;

    public ProductEntity() {
    }

    public ProductEntity(String name, Double price, String sku, Integer status, String description, Integer category_id) {
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.status = status;
        this.description = description;
        this.category_id = category_id;
    }

    public ProductEntity(Integer id, String name, Double price, String sku, Integer status, String description, Integer category_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sku = sku;
        this.status = status;
        this.description = description;
        this.category_id = category_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Integer category_id) {
        this.category_id = category_id;
    }
}
