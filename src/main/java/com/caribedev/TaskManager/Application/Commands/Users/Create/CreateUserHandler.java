package com.caribedev.TaskManager.Application.Commands.Users.Create;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.caribedev.TaskManager.Domain.Entities.User;
import com.caribedev.TaskManager.Domain.Ports.Repositories.IUserRepository;

@Service
public class CreateUserHandler implements  ICreateUser {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public CreateUserHandler(IUserRepository userRepository, PasswordEncoder passwordEncoder ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @Override
    public void handle(CreateUserCommand command) {
        var user = new User(
            command.getUsername(),
              passwordEncoder.encode(command.getPassword()),
              command.getName(), 
              command.getRole()
              );
        userRepository.save(user);
    }

}
