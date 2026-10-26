package com.dining.diningProject.Repositories;

import org.springframework.data.repository.CrudRepository;

import com.dining.diningProject.Entities.User;

public interface UserRepository extends CrudRepository<User, Long>{
    
}
