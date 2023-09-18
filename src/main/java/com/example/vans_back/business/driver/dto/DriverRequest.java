package com.example.vans_back.business.driver.dto;

import com.example.vans_back.domain.van.driver.Driver;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Driver} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DriverRequest implements Serializable {
    private Integer cityId;
    private String username;
    private String password;
    private Integer userRoleId;
    private String driverName;
    private String driversLicense;
    private String driversPhoneNumber;
}