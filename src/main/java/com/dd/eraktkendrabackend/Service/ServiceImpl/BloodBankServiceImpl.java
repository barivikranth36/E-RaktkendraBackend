package com.dd.eraktkendrabackend.Service.ServiceImpl;

import com.dd.eraktkendrabackend.DTO.BloodBankCityAndIdDTO;
import com.dd.eraktkendrabackend.Entity.BloodBank;
import com.dd.eraktkendrabackend.Repository.BloodBankRepository;
import com.dd.eraktkendrabackend.Service.BloodBankService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BloodBankServiceImpl implements BloodBankService {

    private static final Logger logger = LoggerFactory.getLogger(BloodBankServiceImpl.class);

    @Autowired
    private BloodBankRepository bloodBankRepository;

    @Override
    public List<BloodBankCityAndIdDTO> getBloodBankCities() {
        logger.info("Fetching the list of all the cities...");
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
