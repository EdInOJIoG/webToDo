package com.website.todolist.service;

import com.website.todolist.entity.UserEntity;
import com.website.todolist.exception.UserAlreadyExistException;
import com.website.todolist.exception.UserNotFoundException;
import com.website.todolist.model.UserModel;
import com.website.todolist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException {
        if(userRepo.findByUsername(user.getUsername()) != null)
            throw new UserAlreadyExistException("Пользователь с таким именем уже существует.");
        return userRepo.save(user);
    }

    public UserModel getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();

        if(user == null) {
            throw new UserNotFoundException("Пользователь не найден.");
        }

        return UserModel.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
