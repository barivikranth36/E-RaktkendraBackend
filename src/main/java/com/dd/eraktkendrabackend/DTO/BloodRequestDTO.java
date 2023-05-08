package com.dd.eraktkendrabackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRequestDTO {

    private long bloodRequestId;

    private long bloodBankId;

    private String bloodType;

    private long userId;

    private long quantity;

    private long totalCost;

    public BloodRequestDTO(long bloodBankId, String bloodType, long userId, long quantity) {
        this.bloodBankId = bloodBankId;
        this.bloodType = bloodType;
        this.userId = userId;
        this.quantity = quantity;
    }
}
