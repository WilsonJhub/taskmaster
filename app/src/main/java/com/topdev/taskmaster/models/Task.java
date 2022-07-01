package com.topdev.taskmaster.models;




import java.util.Date;


public class Task {


    public Long id;
    String name;
    String description;
    java.util.Date dateCreated;
    TaskCategoryEnum taskCategory;

//    public Task(String name) {
//        this.name = name;
//    }

    public Task(Long id, String name, String description, TaskCategoryEnum taskCategory) {
        this.id = id;
        this.name = name;
        this.description = description;

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

    public TaskCategoryEnum getTaskCategory() {
        return taskCategory;
    }

    public void setTaskCategory(TaskCategoryEnum taskCategory) {
        this.taskCategory = taskCategory;
    }
}

