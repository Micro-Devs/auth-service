package com.microdevs.authservice.web.controller;

import com.microdevs.authservice.model.CreateUser;
import com.microdevs.authservice.model.UpdateUser;
import com.microdevs.authservice.model.UserFilter;
import com.microdevs.authservice.model.dto.UserDto;
import com.microdevs.authservice.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody CreateUser createUser) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(createUser));
    }

    @GetMapping
    public Page<UserDto> getUser(UserFilter userFilter, Pageable pageable) {
        return userService.getUser(userFilter, pageable);
    }

    @PutMapping("/{phone}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String phone, @RequestBody UpdateUser updateUser) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(phone, updateUser));
    }

    @PutMapping("terminate/{phone}")
    public ResponseEntity<?> terminateUser(@PathVariable @NotNull String phone) {
        userService.terminateUser(phone);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping("suspend/{phone}")
    public ResponseEntity<?> suspendUser(@PathVariable @NotNull String phone) {
        userService.passiveUser(phone);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/getAllUsers")
    public List<UserDto> getAllUsers(){
       return userService.getAllUsers();
    }

}