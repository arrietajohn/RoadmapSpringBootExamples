package com.caribedev.TaskManager.Application.UseCases.Users;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.caribedev.TaskManager.Application.Dtos.AuthenticateUserRequest;
import com.caribedev.TaskManager.Application.Dtos.AuthenticateUserResponse;
import com.caribedev.TaskManager.Domain.Exceptions.AuthenticateUserException;
import com.caribedev.TaskManager.Domain.Ports.Repositories.IUserRepository;
import com.caribedev.TaskManager.Infrastructure.Security.JwtTokenProvider;

@Service
public class AutheticateUserUseCaseImp implements IAuthenticateUserUseCase {

    private final IUserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final PasswordEncoder passwordEncoder;

    public AutheticateUserUseCaseImp(IUserRepository repo, JwtTokenProvider tokenProvider, PasswordEncoder passwordEncoder) {
        this.userRepository = repo;
        this.jwtTokenProvider = tokenProvider;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthenticateUserResponse execute(AuthenticateUserRequest request) {
        var user = userRepository.findByUsername(request.getUsername());
        if (!passwordEncoder.matches(request.getPassword(),user.getPassword())) {
            throw new AuthenticateUserException();
        }

        String token = jwtTokenProvider.generateToken(
                user.getUsername(),
                user.getUsername(),
                user.getRole());

        return new AuthenticateUserResponse(user.getUsername(), token);
    }
}
