package com.microdevs.authservice.service;

import com.microdevs.authservice.model.CreateUser;
import com.microdevs.authservice.model.UpdateUser;
import com.microdevs.authservice.model.UserFilter;
import com.microdevs.authservice.model.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    UserDto createUser(CreateUser createUser);

    Page<UserDto> getUser(UserFilter userFilter, Pageable pageable);

    UserDto updateUser(String phone, UpdateUser updateUser);

    void terminateUser(String phone);

    void passiveUser(String phone);

    List<UserDto> getAllUsers();
}
