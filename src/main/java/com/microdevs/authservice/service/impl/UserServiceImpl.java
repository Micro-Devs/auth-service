package com.microdevs.authservice.service.impl;

import com.microdevs.authservice.model.CreateUser;
import com.microdevs.authservice.model.UpdateUser;
import com.microdevs.authservice.model.UserFilter;
import com.microdevs.authservice.model.dto.UserDto;
import com.microdevs.authservice.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDbService userDbService;

    public UserServiceImpl(UserDbService userDbService) {
        this.userDbService = userDbService;
    }


    @Override
    public UserDto createUser(CreateUser createUser) {
        return userDbService.create(createUser);
    }

    @Override
    public Page<UserDto> getUser(UserFilter userFilter, Pageable pageable) {
        return userDbService.get(userFilter, pageable);
    }

    @Override
    public UserDto updateUser(String phone, UpdateUser updateUser) {
        return userDbService.update(phone, updateUser);
    }

    @Override
    public void terminateUser(String phone) {
        userDbService.checkStatusAndTerminate(phone);
    }

    @Override
    public void passiveUser(String phone) {
        userDbService.checkStatusAndSuspend(phone);
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDbService.getAll();
    }
}
