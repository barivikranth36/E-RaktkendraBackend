package com.dd.eraktkendrabackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodRecordDTO {

    private String bloodType;

    private long quantity;

    private long costPerUnit;

    private long bloodBankId;
}
