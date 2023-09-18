package com.example.vans_back.domain.van;

import com.example.vans_back.business.van.dto.VanAllInfo;
import com.example.vans_back.business.van.dto.VanDto;
import com.example.vans_back.business.van.dto.VanRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface VanMapper {

    @Mapping(source = "id", target = "vanId")
    @Mapping(source = "plateNumber", target = "plateNumber")
    @Mapping(source = "model", target = "model")
    @Mapping(source = "nextInspection", target = "nextInspection")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "city.name", target = "cityName")
    @Mapping(source = "insurance.provider", target = "insuranceProvider")
    @Mapping(source = "insurance.phoneNumber", target = "insurancePhoneNumber")
    VanAllInfo toVanAllInfo(Van van);

    List<VanAllInfo> toVanAllInfos(List<Van> vans);

    @Mapping(source = "plateNumber", target = "plateNumber")
    @Mapping(constant = "A", target = "status")
    @Mapping(source = "nextInspection", target = "nextInspection")
    @Mapping(source = "model", target = "model")
    Van toVan(VanRequest vanRequest);

    @Mapping(source = "id", target = "vanId")
    @Mapping(source = "model", target = "vanModel")
    @Mapping(source = "plateNumber", target = "vanPlateNumber")
    VanDto toVanDto(Van van);

    List<VanDto> toVanDtos(List<Van> vans);
}