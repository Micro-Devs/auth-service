package com.microdevs.authservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordForgetRequest {
  private String email;
}
