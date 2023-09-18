package com.example.vans_back.domain.van.driver;

import com.example.vans_back.business.driver.dto.DriverAllInfo;
import com.example.vans_back.business.driver.dto.DriverDto;
import com.example.vans_back.business.driver.dto.DriverRequest;
import com.example.vans_back.business.van.dto.VanBasicInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DriverMapper {

    @Mapping(source = "van.id", target = "vanId")
    @Mapping(source = "van.plateNumber", target = "vanPlateNumber")
    @Mapping(source = "van.insurance.provider", target = "insuranceProvider")
    @Mapping(source = "van.insurance.phoneNumber", target = "insurancePhoneNumber")
    VanBasicInfo toVanBasicInfo(Driver driver);

    @Mapping(source = "id", target = "driverId")
    @Mapping(source = "name", target = "driverName")
    @Mapping(source = "phoneNumber", target = "driverPhoneNumber")
    @Mapping(source = "license", target = "driversLicense")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.password", target = "userPassword")
    @Mapping(source = "city.name", target = "cityName")
    DriverAllInfo toDriverAllInfo(Driver driver);

    List<DriverAllInfo> toDriverAllInfos(List<Driver> drivers);

    @Mapping(source = "driverName", target = "name")
    @Mapping(source = "driversLicense", target = "license")
    @Mapping(source = "driversPhoneNumber", target = "phoneNumber")
    @Mapping(constant = "A", target = "status")
    @Mapping(ignore = true, target = "van")
    Driver toDriver(DriverRequest driverRequest);

    @Mapping(source = "id", target = "driverId")
    @Mapping(source = "name", target = "driverName")
    DriverDto toDriverDto(Driver driver);

    List<DriverDto> toDriverDtos(List<Driver> drivers);
}
