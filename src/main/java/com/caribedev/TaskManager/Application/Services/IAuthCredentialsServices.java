package com.caribedev.TaskManager.Application.Services;

import com.caribedev.TaskManager.Application.Dtos.AuthUserCredentials;

public interface IAuthCredentialsServices {
    AuthUserCredentials getCredentials(String credentialsBase64);
}
