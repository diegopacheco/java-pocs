package com.github.diegopacheco.sandboxspring.model;

import jakarta.validation.constraints.NotBlank;

public class TodoItemFormData {
    @NotBlank(message = "Title must not be blank")
    private String title;

    public TodoItemFormData() {}

    public TodoItemFormData(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
