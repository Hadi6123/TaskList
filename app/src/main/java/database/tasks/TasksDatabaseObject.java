package database.tasks;

import android.app.Application;

import androidx.room.Room;

public class TasksDatabaseObject {

    private static TasksDatabaseObject instance = null;
    private TasksDatabase tasksDatabase;

    private TasksDatabaseObject(Application application){
        tasksDatabase =  Room.databaseBuilder(
                        application.getApplicationContext(),
                        TasksDatabase.class,
                        "ContactDB").
                allowMainThreadQueries().build();
    }

    public static TasksDatabaseObject getInstance(Application application){
        synchronized (TasksDatabaseObject.class){
            if (instance == null){
                instance = new TasksDatabaseObject(application);
            }

            return instance;
        }
    }

    public TasksDatabase getTasksDatabase(){
        return tasksDatabase;
    }
}
