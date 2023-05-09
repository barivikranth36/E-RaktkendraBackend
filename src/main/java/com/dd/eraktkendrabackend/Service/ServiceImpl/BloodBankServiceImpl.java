package com.dd.eraktkendrabackend.Service.ServiceImpl;

import com.dd.eraktkendrabackend.DTO.BloodBankCityAndIdDTO;
import com.dd.eraktkendrabackend.Entity.BloodBank;
import com.dd.eraktkendrabackend.Repository.BloodBankRepository;
import com.dd.eraktkendrabackend.Service.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloodBankServiceImpl implements BloodBankService {

    @Autowired
    private BloodBankRepository bloodBankRepository;

    @Override
    public List<BloodBankCityAndIdDTO> getBloodBankCities() {
        List<BloodBank> bloodBankList = bloodBankRepository.findAll();

        List<BloodBankCityAndIdDTO> cities = new ArrayList<>();

        for(BloodBank bloodBank : bloodBankList) {
            cities.add(new BloodBankCityAndIdDTO(
                    bloodBank.getCity(),
                    bloodBank.getBloodBankId()
            ));
        }
        return cities;
    }
}
