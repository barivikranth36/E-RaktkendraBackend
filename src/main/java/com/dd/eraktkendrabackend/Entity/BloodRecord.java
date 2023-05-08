package com.dd.eraktkendrabackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bloodRecordId;

    @Column(name = "blood_type",nullable = false)
    private String bloodType;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    @Column(name = "cost_per_unit", nullable = false)
    private long costPerUnit;

    // Many to One Mapping of bloodBank
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bankId", referencedColumnName = "bloodBankId")
    private BloodBank bloodBank;
}
