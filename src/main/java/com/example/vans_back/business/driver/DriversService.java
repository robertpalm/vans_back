package com.example.vans_back.business.driver;

import com.example.vans_back.business.driver.dto.DriverAllInfo;
import com.example.vans_back.business.driver.dto.DriverDto;
import com.example.vans_back.business.driver.dto.DriverRequest;
import com.example.vans_back.domain.user.User;
import com.example.vans_back.domain.user.UserMapper;
import com.example.vans_back.domain.user.UserService;
import com.example.vans_back.domain.user.role.Role;
import com.example.vans_back.domain.user.role.RoleService;
import com.example.vans_back.domain.van.city.City;
import com.example.vans_back.domain.van.city.CityService;
import com.example.vans_back.domain.van.driver.Driver;
import com.example.vans_back.domain.van.driver.DriverMapper;
import com.example.vans_back.domain.van.driver.DriverService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DriversService {

    @Resource
    private DriverService driverService;

    @Resource
    private CityService cityService;

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;

    @Resource
    private DriverMapper driverMapper;

    @Resource
    private UserMapper userMapper;

    public List<DriverAllInfo> getDrivers(Integer cityId, Integer driverId) {
        List<Driver> drivers = driverService.getActiveDriversBy(cityId, driverId);
        return driverMapper.toDriverAllInfos(drivers);
    }

    @Transactional
    public void addDriver(DriverRequest driverRequest) {
        Driver driver = driverMapper.toDriver(driverRequest);
        setCityToDriver(driverRequest.getCityId(), driver);
        User user = createAndAddUser(driverRequest);
        driver.setUser(user);
        driverService.addDriver(driver);
    }

    @Transactional
    public void deleteDriver(Integer userId) {
        Driver driver = driverService.getDriverByUserId(userId);
        driverService.deactivateDriver(driver);
        userService.deactivateUser(driver.getUser());
    }

    public List<DriverDto> findAllDrivers() {
        List<Driver> drivers = driverService.findAllActiveDrivers();
        return driverMapper.toDriverDtos(drivers);
    }

    private void setCityToDriver(Integer cityId, Driver driver) {
        City city = cityService.getCityBy(cityId);
        driver.setCity(city);
    }

    private User createAndAddUser(DriverRequest driverRequest) {
        User user = userMapper.toUser(driverRequest);
        setRoleToUser(driverRequest.getUserRoleId(), user);
        userService.addUser(user);
        return user;
    }

    private void setRoleToUser(Integer userRoleId, User user) {
        Role role = roleService.getRoleBy(userRoleId);
        user.setRole(role);
    }
}
