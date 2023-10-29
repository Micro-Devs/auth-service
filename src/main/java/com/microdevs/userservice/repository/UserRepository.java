package com.microdevs.userservice.repository;

import com.microdevs.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;


public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
}