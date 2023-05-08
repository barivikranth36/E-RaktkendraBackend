package com.dd.eraktkendrabackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// ---------------- This DTO is to transfer donation request details ---------------------------------
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodDonationRequestDTO {
    private long bloodDonationRequestId;

    private long bankId;

    private String bloodType;

    private long userId;

    public BloodDonationRequestDTO(long bankId, String bloodType, long userId) {
        this.bankId = bankId;
        this.bloodType = bloodType;
        this.userId = userId;
    }
}
