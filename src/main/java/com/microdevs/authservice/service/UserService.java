package com.microdevs.authservice.service;

import com.microdevs.authservice.dto.UserDto;
import com.microdevs.authservice.entity.User;
import com.microdevs.authservice.mapper.UserMapper;
import com.microdevs.authservice.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public List<UserDto> getUsers() {
        return repository.findAll().stream().map(mapper::toDto).toList();
    }

    public Optional<User> getById(Long id) {
        return repository.findById(id);
    }

    public User getByUsername(String username) {
        var user = repository.findByUsernameAndIsEnabledTrue(username);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("user not found!");
        }
        return user.get();
    }

    public UserDto getDtoByUsername(String username) {
        var user = repository.findByUsername(username);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("user not found!");
        }
        return mapper.toDto(user.get());
    }

    public UserDto getDtoByEmail(String email) {
        var user = repository.findByEmail(email);
        if (user.isEmpty()) {
            throw new EntityNotFoundException("user not found!");
        }
        return mapper.toDto(user.get());
    }

    public UserDto createUser(UserDto dto) {
        if (repository.existsByUsername(dto.getUsername())
                || repository.existsByEmail(dto.getEmail())) {
            throw new RuntimeException("user is already exists!");
        }

        if (Objects.nonNull(dto.getPassword())) {
            dto.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    public UserDto updateUser(UserDto dto) {
        var existing = getById(dto.getId());
        if (existing.isEmpty()) {
            throw new EntityNotFoundException();
        }
        mapper.updatePartial(existing.get(), dto);
        return mapper.toDto(repository.save(existing.get()));
    }
}
