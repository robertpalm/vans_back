package com.example.vans_back.business.city;

import com.example.vans_back.business.city.dto.CityDto;
import com.example.vans_back.domain.van.city.City;
import com.example.vans_back.domain.van.city.CityMapper;
import com.example.vans_back.domain.van.city.CityService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitiesService {

    @Resource
    private CityService cityService;

    @Resource
    private CityMapper cityMapper;

    public List<CityDto> getCities() {
        List<City> cities = cityService.getCities();
        return cityMapper.toCityDtos(cities);
    }
}
