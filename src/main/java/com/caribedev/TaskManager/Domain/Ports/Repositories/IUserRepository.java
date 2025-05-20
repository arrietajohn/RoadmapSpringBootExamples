package com.caribedev.TaskManager.Domain.Ports.Repositories;

import java.util.List;

import com.caribedev.TaskManager.Domain.Entities.User;
/**
 *
 * @author John Carlos Arrieta Arrieta
 */

public interface IUserRepository {
    void save(User user);
    void deleteByUsername(String username);
    void update(User user);
    User findByUsername(String username);
    List<User> findByRole(String role);
    List<User> findAll();
}
