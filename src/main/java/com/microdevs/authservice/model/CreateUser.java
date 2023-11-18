package com.microdevs.authservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateUser {
    @NotNull
    private String first_name;
    @NotNull
    private String last_name;
    @NotNull
    private String phone;
    @NotNull
    private String email;
}
