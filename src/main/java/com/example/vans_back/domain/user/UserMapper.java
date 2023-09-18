package com.example.vans_back.domain.user;

import com.example.vans_back.business.driver.dto.DriverRequest;
import com.example.vans_back.business.login.LoginResponse;
import com.example.vans_back.business.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "role.name", target = "roleName")
    LoginResponse toLoginResponse(User user);

    @Mapping(constant = "A", target = "status")
    User toUser(DriverRequest driverRequest);

    @Mapping(source = "id", target = "userId")
    @Mapping(source = "username", target = "username")
    UserDto toDto(User user);

    List<UserDto> toUserDtos(List<User> users);
}