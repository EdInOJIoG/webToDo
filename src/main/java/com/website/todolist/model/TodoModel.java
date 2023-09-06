package com.website.todolist.model;

import com.website.todolist.entity.TodoEntity;

public class TodoModel {
    private Long id;
    private String title;
    private boolean completed;

    public static TodoModel toModel(TodoEntity entity) {
        TodoModel model = new TodoModel();
        model.setId(entity.getId());
        model.setTitle(entity.getTitle());
        model.setCompleted(entity.isCompleted());
        return model;
    }

    public TodoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
