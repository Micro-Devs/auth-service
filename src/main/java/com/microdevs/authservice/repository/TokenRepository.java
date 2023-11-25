package com.microdevs.authservice.repository;

import com.microdevs.authservice.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {

    Optional<Token> findTokenByTokenAndValidTrue(String token);

    Optional<Token> findTokenByTokenAndValidFalse(String token);
}
