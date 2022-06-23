package com.ghtk.thanhnh157.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "district")
public class DistrictEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;

    public DistrictEntity() {
    }

    public DistrictEntity(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public DistrictEntity(Integer id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
