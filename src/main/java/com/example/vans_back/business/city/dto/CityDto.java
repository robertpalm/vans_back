package com.example.vans_back.business.city.dto;

import com.example.vans_back.domain.van.city.City;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link City} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityDto implements Serializable {
    private Integer cityId;
    private String cityName;
}