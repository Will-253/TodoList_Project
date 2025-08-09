package com.project.todotask;

import jakarta.persistence.*;

@Entity
@Table(name = "Tasks")
public class TaskModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private boolean completed;

    public TaskModel(long id, String description, boolean completed) {
        this.id = id;
        this.description = description;
        this.completed = completed;
    }
    public TaskModel(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
