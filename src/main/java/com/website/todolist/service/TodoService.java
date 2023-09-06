package com.website.todolist.service;

import com.website.todolist.entity.TodoEntity;
import com.website.todolist.entity.UserEntity;
import com.website.todolist.model.TodoModel;
import com.website.todolist.repository.TodoRepo;
import com.website.todolist.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public TodoModel createTodo(TodoEntity todo, Long userId) {
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return TodoModel.toModel(todoRepo.save(todo));
    }

    public TodoModel completeTodo(Long id) {
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.isCompleted());
        return TodoModel.toModel(todoRepo.save(todo));
    }
}
