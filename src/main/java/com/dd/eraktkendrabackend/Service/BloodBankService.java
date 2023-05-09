package com.dd.eraktkendrabackend.Service;

import com.dd.eraktkendrabackend.DTO.BloodBankCityAndIdDTO;

import java.util.List;

public interface BloodBankService {

    List<BloodBankCityAndIdDTO> getBloodBankCities();
}
