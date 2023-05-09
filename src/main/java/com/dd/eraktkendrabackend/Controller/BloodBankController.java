package com.dd.eraktkendrabackend.Controller;

import com.dd.eraktkendrabackend.DTO.BloodBankCityAndIdDTO;
import com.dd.eraktkendrabackend.Service.BloodBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bloodBank")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BloodBankController {

    @Autowired
    private BloodBankService bloodBankService;


    // ----------------------------- Method to get list of all cities available -------------------------------
    @GetMapping("/getCitiesAndBankId")
    List<BloodBankCityAndIdDTO> getBloodBankCities() {
        return bloodBankService.getBloodBankCities();
    }
}
