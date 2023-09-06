package com.website.todolist.repository;

import com.website.todolist.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {

    UserEntity findByUsername(String userName);

}
