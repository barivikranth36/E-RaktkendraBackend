package com.dd.eraktkendrabackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodBankCityAndIdDTO {
    private String city;
    private long bankId;
}
