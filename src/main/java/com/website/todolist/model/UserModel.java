package com.website.todolist.model;

import com.website.todolist.entity.UserEntity;

import java.util.List;
import java.util.stream.Collectors;

public class UserModel {

    private Long id;
    private String username;

    private List<TodoModel> todos;



    public static UserModel toModel(UserEntity entity) {
        UserModel model = new UserModel();
        model.setId(entity.getId());
        model.setUsername(entity.getUsername());
        model.setTodos(entity.getTodos().stream().map(TodoModel::toModel).collect(Collectors.toList()));
        return model;
    }


    public UserModel() {
    }

    public List<TodoModel> getTodos() {
        return todos;
    }

    public void setTodos(List<TodoModel> todos) {
        this.todos = todos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
