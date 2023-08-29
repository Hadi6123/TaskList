package builders.tasks.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasklevelinfo")
public class TaskLevelInfo {

    @PrimaryKey
    @ColumnInfo(name = "task_info")
    private int task_info;

    public TaskLevelInfo(){}


    public int getTask_info() {
        return task_info;
    }

    public void setTask_info(int task_info) {
        this.task_info = task_info;
    }
}
