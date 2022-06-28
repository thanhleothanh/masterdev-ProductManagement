package com.ghtk.thanhnh157.models.entities;

import com.ghtk.thanhnh157.constants.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "product")
public class ProductEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "sku")
    private String sku;

    @Column(name = "status")
    private ProductStatus status;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @PrePersist
    public void prePersist() {
        this.sku = this.category.getCode() + ".sku." + LocalDateTime.now().truncatedTo(ChronoUnit.MILLIS);
        this.status = ProductStatus.valueOf("ACTIVE");
    }
}
