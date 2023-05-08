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
    private User userId;

    @Column(name = "blood_type", nullable = false)
    private String bloodType;

    @Column(name = "quantity", nullable = false)
    private long quantity;

    @Column(name = "total_cost", nullable = false)
    private long totalCost;
}