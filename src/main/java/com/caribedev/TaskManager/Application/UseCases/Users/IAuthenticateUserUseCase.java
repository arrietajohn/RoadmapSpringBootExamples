package com.caribedev.TaskManager.Application.UseCases.Users;

import com.caribedev.TaskManager.Application.Dtos.AuthenticateUserRequest;
import com.caribedev.TaskManager.Application.Dtos.AuthenticateUserResponse;

public interface IAuthenticateUserUseCase {
    AuthenticateUserResponse execute(AuthenticateUserRequest request);
}
