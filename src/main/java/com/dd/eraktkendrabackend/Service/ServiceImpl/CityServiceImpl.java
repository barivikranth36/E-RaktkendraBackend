package com.dd.eraktkendrabackend.Service.ServiceImpl;

import com.dd.eraktkendrabackend.Entity.City;
import com.dd.eraktkendrabackend.Repository.CityRepository;
import com.dd.eraktkendrabackend.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public List<String> getAllCities() {
        List<City> cityList = cityRepository.findAll();

        List<String> cityNames = new ArrayList<>();
        for(City city: cityList) {
            cityNames.add(city.getCityName());
        }
        return cityNames;
    }
}
