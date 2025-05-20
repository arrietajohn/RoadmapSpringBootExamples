package com.caribedev.TaskManager.Application.Queries.Users.SearchByUserName;

import com.caribedev.TaskManager.Application.Dtos.UserResponse;

public interface ISearchUserById {
    UserResponse handle(SearchUserByIdQuery query);
}
