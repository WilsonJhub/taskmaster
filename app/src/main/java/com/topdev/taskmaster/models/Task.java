package com.topdev.taskmaster.models;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

// TODO: Step 2-1: Make a data a class
@Entity
public class Task {

    @PrimaryKey(autoGenerate = true)
    public Long id;
    String name;
    String description;
    java.util.Date dateCreated;
    TaskCategoryEnum taskCategory;

//    public Task(String name) {
//        this.name = name;
//    }

    public Task(Long id, String name, String description, Date dateCreated, TaskCategoryEnum taskCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.taskCategory = taskCategory;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public TaskCategoryEnum getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(TaskCategoryEnum taskCategory) {
        this.taskCategory = taskCategory;
    }
}

