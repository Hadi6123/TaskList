package repository;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import androidx.lifecycle.MutableLiveData;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import builders.tasks.TaskDTOData;
import builders.tasks.model.Task;
import builders.tasks.model.TaskLevelCount;
import builders.tasks.model.TaskLevelInfo;
import database.tasks.TasksDatabase;
import database.tasks.TasksDatabaseObject;

public class TaskRepository {
    private List<TaskDTOData> tasks = new ArrayList<>();
    private MutableLiveData<List<TaskDTOData>> mutableLiveData = new MutableLiveData<>();
    private Application application;

    private TasksDatabaseObject tasksDatabaseObject;

    private List<Task> levelTasks = new ArrayList<>();

    public TaskRepository(Application application) {
        this.application = application;

        tasksDatabaseObject = TasksDatabaseObject.getInstance(application);

        /*
        tasksDatabase = Room.databaseBuilder(
                        application.getApplicationContext(),
                        TasksDatabase.class,
                        "ContactDB").
                allowMainThreadQueries().build();*/

    }


    public MutableLiveData<List<TaskDTOData>> getMutableLiveData(){
        //getAllTasks();
        tasks = (tasksDatabaseObject.getTasksDatabase().getTaskDAO().getTasks());
        mutableLiveData.postValue(tasks);
        return mutableLiveData;
    }

    public List<Task> getEasyTasks(){
        return tasksDatabaseObject.getTasksDatabase().getTaskDAO().getEasyTasks();
    }

    public List<Task> getMediumTasks(){
        return tasksDatabaseObject.getTasksDatabase().getTaskDAO().getMediumTasks();
    }

    public List<Task> getHardTasks(){
        return tasksDatabaseObject.getTasksDatabase().getTaskDAO().getHardTasks();
    }

    public int count(){
        return tasksDatabaseObject.getTasksDatabase().getTaskDAO().getCount();
    }

    public int easyCount(){
        return tasksDatabaseObject.getTasksDatabase().getTaskDAO().countEasyTasks();
    }

    public int mediumCount(){
        return tasksDatabaseObject.getTasksDatabase().getTaskDAO().countMediumTasks();
    }

    public int hardCount(){
        return tasksDatabaseObject.getTasksDatabase().getTaskDAO().countHardTasks();
    }

    public void addTask(TaskDTOData taskDTOData){
        long id = tasksDatabaseObject.getTasksDatabase().getTaskDAO()
                .addTask(taskDTOData);
    }

    private void getAllTasks(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(new Runnable() {
            @Override
            public void run() {

                // Background Work
                tasks = (tasksDatabaseObject.getTasksDatabase().getTaskDAO().getTasks());



                // Executed after the background work had finished
                /*handler.post(new Runnable() {
                    @Override
                    public void run() {
                        contactsAdapter.notifyDataSetChanged();
                    }
                }); */


            }
        });

    }

    public void updateCurrentTask(TaskDTOData taskDTOData){
        tasksDatabaseObject.getTasksDatabase().getTaskDAO().updateTask(taskDTOData); ;
    }

    public void deleteCurrentTask(int id){
        tasksDatabaseObject.getTasksDatabase().getTaskDAO().deleteTask(id);
    }

    public ArrayList<TaskLevelCount> getLevelCounts(){
        return (ArrayList<TaskLevelCount>) tasksDatabaseObject.getTasksDatabase().getTaskDAO().getLevelCount();
    }

    public TaskLevelInfo getEasyLevelInfo(){
        return tasksDatabaseObject.getTasksDatabase().getTaskDAO().getEasyLevelInfo();
    }

    public TaskLevelInfo getMediumLevelInfo(){
        return tasksDatabaseObject.getTasksDatabase().getTaskDAO().getMediumLevelInfo();
    }

    public TaskLevelInfo getHardLevelInfo(){
        return tasksDatabaseObject.getTasksDatabase().getTaskDAO().getHardLevelInfo();
    }

}

