package com.caribedev.TaskManager.Application.Dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AuthenticateUserRequest {

    @NotBlank(message = "Username cannot be blank")
    @NotNull(message = "Username cannot be null")
    private final String username;
    @NotBlank(message = "Username cannot be blank")
    @NotNull(message = "Username cannot be null")
    private final String password;

    public AuthenticateUserRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

}
