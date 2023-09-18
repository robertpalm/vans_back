package com.example.vans_back.business.user;

import com.example.vans_back.business.user.dto.UserDto;
import com.example.vans_back.domain.user.User;
import com.example.vans_back.domain.user.UserMapper;
import com.example.vans_back.domain.user.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {
    @Resource
    UserService userService;
    @Resource
    private UserMapper userMapper;

    public List<UserDto> getUsers() {
        List<User> users = userService.getUsers();
        return userMapper.toUserDtos(users);
    }
}