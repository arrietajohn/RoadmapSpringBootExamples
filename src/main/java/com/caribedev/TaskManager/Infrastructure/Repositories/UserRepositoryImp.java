package com.caribedev.TaskManager.Infrastructure.Repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.caribedev.TaskManager.Domain.Entities.User;
import com.caribedev.TaskManager.Domain.Exceptions.EntityNotFoundException;
import com.caribedev.TaskManager.Domain.Exceptions.PreexistingEntityException;
import com.caribedev.TaskManager.Domain.Ports.Repositories.IUserRepository;
import com.caribedev.TaskManager.Infrastructure.Persistence.Entities.UserEntity;

@Repository
public class UserRepositoryImp implements IUserRepository {

    private final IJpaUserRepository jpaUserRepository;

    public UserRepositoryImp(IJpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public void save(User user) {
        if (jpaUserRepository.existsById(user.getUsername())) {
            throw new PreexistingEntityException("User Id: " + user.getUsername() 
            + " already exists");
        }
       
        jpaUserRepository.save(
                new UserEntity(
                        user.getUsername(),
                        user.getPassword(),
                        user.getName(),
                        user.getRole())
        );
    }

    @Override
    public void deleteByUsername(String username) {
        if (jpaUserRepository.existsById(username)) {
            throw new EntityNotFoundException("User Id: " + username 
            + " already exists");
        }

        jpaUserRepository.deleteById(username);
    }

    @Override
    public void update(User user) {
         if (jpaUserRepository.existsById(user.getUsername())) {
            throw new EntityNotFoundException("User Id: " + user.getUsername() 
            + " already exists");
        }

        jpaUserRepository.save(
                new UserEntity(
                        user.getUsername(),
                        user.getPassword(),
                        user.getName(),
                        user.getRole()
                )
        );
    }

    @Override
    public User findByUsername(String username) {
        
        var userEntity = jpaUserRepository
        .findById(username)
        .orElseThrow(() -> new EntityNotFoundException("User Id: " + username 
        + " not found"));
        var user = new User();
        if (userEntity != null) {
            user.setUsername(userEntity.getUsername());
            user.setPassword(userEntity.getPassword());
            user.setName(userEntity.getName());
            user.setRole(userEntity.getRole());
        }
        return user;
    }

    @Override
    public List<User> findByRole(String role) {
        return jpaUserRepository.findByRole(role)
        .stream().map(userEntity -> {
            var user = new User();
            user.setUsername(userEntity.getUsername());
            user.setPassword(userEntity.getPassword());
            user.setName(userEntity.getName());
            user.setRole(userEntity.getRole());
            return user;
        }).toList();
    }

    @Override
    public List<User> findAll() {
        return jpaUserRepository.findAll()
        .stream().map(entity -> {
            var user = new User();
            user.setUsername(entity.getUsername());
            user.setPassword(entity.getPassword());
            user.setName(entity.getName());
            user.setRole(entity.getRole());
            return user;
        }).toList();
    }

}
