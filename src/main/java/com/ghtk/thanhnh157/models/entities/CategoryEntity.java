package com.ghtk.thanhnh157.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String code;
    private Integer status;
    private String description;

    public CategoryEntity() {
    }

    public CategoryEntity(String name, String code, Integer status, String description) {
        this.name = name;
        this.code = code;
        this.status = status;
        this.description = description;
    }

    public CategoryEntity(Integer id, String name, String code, Integer status, String description) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.status = status;
        this.description = description;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
}

