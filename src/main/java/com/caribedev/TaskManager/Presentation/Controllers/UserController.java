package com.caribedev.TaskManager.Presentation.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caribedev.TaskManager.Application.Commands.Users.Create.CreateUserCommand;
import com.caribedev.TaskManager.Application.Commands.Users.Create.ICreateUser;
import com.caribedev.TaskManager.Application.Dtos.AuthenticateUserRequest;
import com.caribedev.TaskManager.Application.Dtos.AuthenticateUserResponse;
import com.caribedev.TaskManager.Application.Dtos.UserResponse;
import com.caribedev.TaskManager.Application.Queries.Users.SearchByUserName.ISearchUserById;
import com.caribedev.TaskManager.Application.Queries.Users.SearchByUserName.SearchUserByIdQuery;
import com.caribedev.TaskManager.Application.UseCases.Users.IAuthenticateUserUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final ICreateUser createUserCommand;
    private final ISearchUserById searchUserByIdQuery;
    private final IAuthenticateUserUseCase authenticateUserUseCase;


    public UserController(IAuthenticateUserUseCase authenticateUserUseCase,
            ICreateUser createUserCommand,
            ISearchUserById searchUserByIdQuery) {
        this.authenticateUserUseCase = authenticateUserUseCase;
        this.createUserCommand = createUserCommand;
        this.searchUserByIdQuery = searchUserByIdQuery;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticateUserResponse> authenticateUser(@Valid @RequestBody AuthenticateUserRequest request,
            HttpServletRequest httpServletRequest) {
        var user = authenticateUserUseCase.execute(request);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Valid @RequestBody CreateUserCommand request) {
        createUserCommand.handle(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) {
        var user = searchUserByIdQuery.handle(new SearchUserByIdQuery(username));
        return ResponseEntity.ok(user);
    }

}
