package com.topdev.taskmaster.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.topdev.taskmaster.dao.TaskDao;
import com.topdev.taskmaster.models.Task;

@Database(entities = {Task.class}, version = 1) // If you update the version, it will delete the db!
@TypeConverters({TaskMasterDatabaseConverters.class})
public abstract class TaskMasterDatabase extends RoomDatabase {
    public abstract TaskDao taskDao();


}
