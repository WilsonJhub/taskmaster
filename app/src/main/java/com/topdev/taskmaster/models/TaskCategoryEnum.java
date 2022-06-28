package com.topdev.taskmaster.models;

import androidx.annotation.NonNull;

public enum TaskCategoryEnum {
    Array_List("Array List"),
    Linked_List("Linked List"),
    Hashtable ("Hashtable"),
    Insertion_Sort("Insertion Sorting");

    private final String taskText;

    TaskCategoryEnum(String taskText) {
        this.taskText = taskText;
    }

    public String getTaskText() {
        return taskText;
    }

    public static TaskCategoryEnum fromString(String possibleTaskText){
        for(TaskCategoryEnum task : TaskCategoryEnum.values()){
            if(task.taskText.equals(possibleTaskText)){
                return task;
            }
        }
        return null;
    }


    @NonNull
    @Override
    public String toString() {
        if(taskText == null){
            return "";
        }
        return taskText;
    }
}
