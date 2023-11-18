package com.microdevs.authservice.repository;

import com.microdevs.baseservice.enums.StatusType;
import com.microdevs.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
    Optional<User> findByPhone(String phone);

    Optional<User> findByPhoneAndStatusNot(String phone, StatusType status);
}
