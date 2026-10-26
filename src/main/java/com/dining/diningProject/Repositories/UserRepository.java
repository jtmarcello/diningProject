package com.dining.diningProject.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.dining.diningProject.Entities.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long>{
    public Optional<User> findByUsername(String username);
}