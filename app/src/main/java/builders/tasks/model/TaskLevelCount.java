package builders.tasks.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "tasklevelcount")
public class TaskLevelCount {
    @PrimaryKey
    @ColumnInfo(name = "task_level")
    private int task_level;

    @ColumnInfo(name = "task_count")
    private int task_count;

    public TaskLevelCount(){}

    public int getTask_level() {
        return task_level;
    }

    public void setTask_level(int task_level) {
        this.task_level = task_level;
    }

    public int getTask_count() {
        return task_count;
    }

    public void setTask_count(int task_count) {
        this.task_count = task_count;
    }

    public ArrayList<String> getCountStringList(ArrayList<TaskLevelCount> taskLevelCounts){

        ArrayList<String> result = new ArrayList<>();

        for (TaskLevelCount taskLevelCount: taskLevelCounts){
            result.add("Severity Level: " + taskLevelCount.getTask_level() + "              Count: " + taskLevelCount.getTask_count());
        }

        return result;

    }
}
