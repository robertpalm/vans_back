package com.example.vans_back.business.van.dto;

import com.example.vans_back.domain.van.Van;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link Van} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VanDto implements Serializable {
    private Integer vanId;
    private String vanModel;
    private String vanPlateNumber;
}