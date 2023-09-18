package com.example.vans_back.domain.van.insurance;

import com.example.vans_back.business.van.dto.VanRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface InsuranceMapper {

    @Mapping(source = "insurancePhoneNumber", target = "phoneNumber")
    @Mapping(source = "insuranceProvider", target = "provider")
    Insurance toInsurance(VanRequest vanRequest);
}