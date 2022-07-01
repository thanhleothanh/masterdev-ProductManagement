package com.ghtk.thanhnh157.models.entities;

import com.ghtk.thanhnh157.constants.WarehouseStatus;
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
@Table(name = "warehouse")
public class WarehouseEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "status")
    private WarehouseStatus status;

    @ManyToOne
    @JoinColumn(name = "province_id", nullable = false)
    private ProvinceEntity province;

    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private DistrictEntity district;

    @PrePersist
    public void prePersist() {
        this.address = this.address +
                ", " +
                this.district.getName() +
                ", " +
                this.province.getName();
        this.status = WarehouseStatus.valueOf("ACTIVE");
    }
}
