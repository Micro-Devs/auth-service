package com.microdevs.authservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SetNewPasswordRequest {
  private String password;
  private String username;
  private String code;
}
