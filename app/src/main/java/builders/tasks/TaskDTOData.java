package builders.tasks;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "tasks")
public class TaskDTOData implements TaskDTO{

    @ColumnInfo(name = "task_id")
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "task_name")
    private String name;

    @ColumnInfo(name = "task_level")
    private int severity;

    @ColumnInfo(name = "task_image")
    private String image;

    @ColumnInfo(name = "task_priority")
    private int priority;

    @ColumnInfo(name = "task_description")
    private String description;


    @Ignore
    public TaskDTOData(){}

    public TaskDTOData(String name, int severity, String image, int priority, String description) {
        this.name = name;
        this.severity = severity;
        this.image = image;
        this.priority = priority;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    @Override
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
