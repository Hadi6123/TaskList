package database.tasks;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import builders.tasks.TaskDTOData;
import builders.tasks.model.Task;
import builders.tasks.model.TaskLevelCount;
import builders.tasks.model.TaskLevelInfo;

@Dao
public interface TaskDatabaseDAO {
    @Insert
    public long addTask(TaskDTOData task);

    @Update
    public void updateTask(TaskDTOData task);

    /*
    @Delete
    public void deleteTask(int id);*/

    @Query("DELETE FROM tasks WHERE task_id=:id")
    public void deleteTask(int id);


    @Query("select * from tasks order by task_priority")
    public List<TaskDTOData> getTasks();

    @Query("select count(*) from tasks")
    public int getCount();

    @Query("select task_name, task_priority, task_level, task_description from tasks where task_level < 4 order by task_level")
    public List<Task> getEasyTasks();

    @Query("select count(*) from tasks where task_level < 4 order by task_level")
    public int countEasyTasks();

    @Query("select AVG(task_level) as task_info from tasks where task_level < 4")
    public TaskLevelInfo getEasyLevelInfo();

    @Query("select task_name, task_priority, task_level, task_description from tasks where task_level >= 4 AND task_level <= 7 order by task_level")
    public List<Task> getMediumTasks();

    @Query("select AVG(task_level) as task_info from tasks where task_level >= 4 AND task_level <= 7")
    public TaskLevelInfo getMediumLevelInfo();

    @Query("select count(*) from tasks where task_level >= 4 AND task_level <= 7 order by task_level")
    public int countMediumTasks();

    @Query("select task_name, task_priority, task_level, task_description from tasks where task_level > 7 order by task_level")
    public List<Task> getHardTasks();

    @Query("select AVG(task_level) as task_info from tasks where task_level > 7")
    public TaskLevelInfo getHardLevelInfo();

    @Query("select count(*) from tasks where task_level > 7 order by task_level")
    public int countHardTasks();

    @Query("select task_level, count(*) as task_count from tasks GROUP BY task_level order by task_level")
    public List<TaskLevelCount> getLevelCount();

}
