package com.topdev.taskmaster.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.topdev.taskmaster.models.Task;

import java.util.List;

@Dao // Think of this like a Spring JPA repository, but we have to implement more stuff ourselves.
public interface TaskDao {
    // CREATE
    @Insert
    public void insertATask(Task task);

    // find all tasks
    @Query("SELECT * FROM Task")
    public List<Task> findAll();

   @Query("SELECT * FROM Task ORDER BY name ASC")
   public List<Task> findALLSortedByName();

    @Query("SELECT * FROM Task WHERE id = :id")
    Task findById(Long id);
}
