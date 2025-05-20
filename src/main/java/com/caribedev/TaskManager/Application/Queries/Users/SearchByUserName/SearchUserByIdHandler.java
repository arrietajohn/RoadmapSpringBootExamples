package com.caribedev.TaskManager.Application.Queries.Users.SearchByUserName;

import org.springframework.stereotype.Service;

import com.caribedev.TaskManager.Application.Dtos.UserResponse;
import com.caribedev.TaskManager.Domain.Ports.Repositories.IUserRepository;

@Service
public class SearchUserByIdHandler implements ISearchUserById {

    private final IUserRepository repository;

    public SearchUserByIdHandler(IUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserResponse handle(SearchUserByIdQuery query) {

        var user = repository.findByUsername(query.getUserId());
        return new UserResponse(
                user.getUsername(),
                user.getUsername(),
                user.getName(),
                user.getRole()
        );
    }

}
