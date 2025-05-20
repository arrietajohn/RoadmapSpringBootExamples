package com.caribedev.TaskManager.Infrastructure.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caribedev.TaskManager.Infrastructure.Persistence.Entities.UserEntity;

public interface IJpaUserRepository extends JpaRepository<UserEntity, String>{
    public UserEntity findByNameContaining(String name);
    public List<UserEntity> findByRole(String role);
    public UserEntity findByUsername(String username);
}
