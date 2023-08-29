package database.tasks;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import builders.tasks.TaskDTOData;

@Database(entities = {TaskDTOData.class},version = 1)
public abstract class TasksDatabase extends RoomDatabase {

    // Linking the DAO with our Database
    public abstract TaskDatabaseDAO getTaskDAO();
}

