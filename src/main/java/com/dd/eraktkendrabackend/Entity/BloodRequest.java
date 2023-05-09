package com.dd.eraktkendrabackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// ------------ This entity is ussed to keep the track of all pending blood requests ----------------
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bloodRequestId;

    //One to One Mapping of user
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @Column(name = "blood_type", nullable = false)
    private String bloodType;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    @Column(name = "total_cost", nullable = false)
    private long totalCost;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bankId", referencedColumnName = "bloodBankId")
    private BloodBank bloodBank;

    // -------------------------------- Constructor -------------------------------------------


    public BloodRequest(User user, String bloodType, long quantity, long totalCost, BloodBank bloodBank) {
        this.user = user;
        this.bloodType = bloodType;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.bloodBank = bloodBank;
    }
}
