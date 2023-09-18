package com.example.vans_back.business.city;

import com.example.vans_back.business.city.dto.CityDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CitiesController {

    @Resource
    private CitiesService citiesService;

    @GetMapping("/all-cities")
    @Operation(summary = "Leiab süsteemist (city tabelist) kõik linnad",
            description = "Tagastab info koos cityId ja cityName'ga.")
    public List<CityDto> getCities() {
        return citiesService.getCities();
    }
}
