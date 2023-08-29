package builders.tasks.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "singleTask")
public class Task {

    @ColumnInfo(name = "task_name")
    @PrimaryKey
    private String name;

    @ColumnInfo(name = "task_level")
    @PrimaryKey
    private int serverity;

    @ColumnInfo(name = "task_description")
    @PrimaryKey
    private String description;

    @ColumnInfo(name = "task_priority")
    @PrimaryKey
    private int priority;

    public Task(){}

    @Ignore
    public Task(String name, int severity, int priority, String description) {
        this.name = name;
        this.serverity = severity;
        this.priority = priority;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getServerity() {
        return serverity;
    }

    public void setServerity(int serverity) {
        this.serverity = serverity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
