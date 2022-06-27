package com.ghtk.thanhnh157.models.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "warehouse_product")
public class WarehouseProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "inventory")
    private Integer inventory;

    @Column(name = "total_import")
    private Integer total_import;

    @Column(name = "total_export")
    private Integer total_export;

    @Column(name = "start_date")
    private String start_date;

    @Column(name = "expired_date")
    private String expired_date;

    @ManyToOne
    @JoinColumn(name = "warehouse", nullable = false)
    private WarehouseEntity warehouse;

    @ManyToOne
    @JoinColumn(name = "product", nullable = false)
    private ProductEntity product;

}
