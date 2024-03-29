package com.dd.eraktkendrabackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// ------------ This entity is used to store all the blood donation request generated by user -------
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BloodDonationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long donationRequestId;

    // One to One mapping of user
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @Column(name = "blood_type", nullable = false)
    private String bloodType;

    @Column(name = "bankId", nullable = false)
    private long bankId;

    public BloodDonationRequest(User user, String bloodType, Long bankId) {
        this.user = user;
        this.bloodType = bloodType;
        this.bankId = bankId;
    }
}
