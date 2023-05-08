package com.dd.eraktkendrabackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

// ------------ This entity is used to keep the record of all the completed blood donations ----------
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodDonationRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long donationRecordId;

    //Many to one mapping of user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

    @Column(name = "blood_type", nullable = false)
    private String bloodType;

    @Column(name = "bloodBankId",nullable = false)
    private long bloodBankId;

    @Column(name = "dateOfDonation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfDonation;

    // ---------------------------- Constructor ---------------------------------------

    public BloodDonationRecord(User user, String bloodType, long bloodBankId, Date dateOfDonation) {
        this.user = user;
        this.bloodType = bloodType;
        this.bloodBankId = bloodBankId;
        this.dateOfDonation = dateOfDonation;
    }
}
