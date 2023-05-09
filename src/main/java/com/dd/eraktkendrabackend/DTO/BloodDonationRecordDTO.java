package com.dd.eraktkendrabackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodDonationRecordDTO {

    private long donationRecordId;

    private long userId;

    private String bloodType;

    private long bloodBankId;

    @Temporal(TemporalType.DATE)
    private Date dateOfDonation;
}
