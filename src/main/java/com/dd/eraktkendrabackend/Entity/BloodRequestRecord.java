package com.dd.eraktkendrabackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// ----------------- This entity is to keep the record of all the completed blood request records -------------
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequestRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long requestRecordId;

    //Many to One mapping of user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @Column(name = "blood_type", nullable = false)
    private String bloodType;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    @Column(name = "total_cost", nullable = false)
    private long totalCost;

    @Column(name = "bankId", nullable = false)
    private long bankId;

    public BloodRequestRecord(User user, String bloodType, long quantity, long totalCost, long bankId) {
        this.user = user;
        this.bloodType = bloodType;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.bankId = bankId;
    }
}
