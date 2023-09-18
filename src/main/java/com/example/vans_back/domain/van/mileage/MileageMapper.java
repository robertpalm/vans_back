package com.example.vans_back.domain.van.mileage;

import com.example.vans_back.business.mileage.dto.MileageDto;
import com.example.vans_back.business.mileage.dto.MileageRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MileageMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "date", target = "date")
    @Mapping(source = "van.id", target = "vanId")
    @Mapping(source = "km", target = "km")
    MileageDto toMileageDto(Mileage mileage);

    List<MileageDto> toMileageDtos(List<Mileage> mileages);

    @Mapping(source = "vanId", target = "van.id")
    @Mapping(source = "km", target = "km")
    @Mapping(source = "date", target = "date")
    Mileage toMileage(MileageRequest mileageRequest);
}