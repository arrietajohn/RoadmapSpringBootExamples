package com.caribedev.TaskManager.Application.Queries.Users.SearchByUserName;

public class SearchUserByIdQuery {
    private final String userId;

    public SearchUserByIdQuery(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        if (userId.length() < 2) {
            throw new IllegalArgumentException("User ID must be at least 2 characters long");
        }
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
