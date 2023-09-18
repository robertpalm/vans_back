package com.example.vans_back.business.login;

import com.example.vans_back.domain.user.User;
import com.example.vans_back.domain.user.UserMapper;
import com.example.vans_back.domain.user.UserService;
import com.example.vans_back.domain.van.driver.Driver;
import com.example.vans_back.domain.van.driver.DriverService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Resource
    private UserService userService;

    @Resource
    private DriverService driverService;

    @Resource
    private UserMapper userMapper;

    public LoginResponse login(String username, String password) {
        User user = userService.findActiveUserBy(username, password);
        LoginResponse loginResponse = userMapper.toLoginResponse(user);
        if (loginResponse.getRoleName().equals("driver")) {
            Driver driver = driverService.getDriverByUserId(user.getId());
            loginResponse.setDriverId(driver.getId());
        }
        return loginResponse;
    }
}
