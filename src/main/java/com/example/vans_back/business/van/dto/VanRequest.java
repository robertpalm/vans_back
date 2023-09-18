package com.example.vans_back.business.van.dto;

import com.example.vans_back.domain.van.Van;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A DTO for the {@link Van} entity
 */
@Data
public class VanRequest implements Serializable {
    private Integer cityId;
    private Integer driverId;
    private String model;
    private String plateNumber;
    private String insuranceProvider;
    private String insurancePhoneNumber;
    private LocalDate nextInspection;
}