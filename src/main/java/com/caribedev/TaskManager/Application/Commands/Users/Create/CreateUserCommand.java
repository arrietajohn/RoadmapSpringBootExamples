package com.caribedev.TaskManager.Application.Commands.Users.Create;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CreateUserCommand {
    @NotBlank(message = "Username cannot be blank")
    @NotNull(message = "Username cannot be null")
    @Size(min= 2, message = "Username must be at least 2 characters long")
    private final String username;
    @NotBlank(message = "Password cannot be blank")
    @NotNull(message = "Password cannot be null")
    private final String password;
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")
    private final String name;
    @NotBlank(message = "Role cannot be blank")
    @NotNull(message = "Role cannot be null")
    @Pattern(regexp = "^(Admin|User)$", message = "Role must be either 'admin' or 'user'")
    private final String role;

    public CreateUserCommand(String username, String password, String name, String role) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

}
