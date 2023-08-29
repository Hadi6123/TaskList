package tasksByLevel;

import android.app.Application;

import java.util.List;

import builders.tasks.model.Task;
import builders.tasks.model.TaskLevelInfo;
import repository.TaskRepository;

public interface OrderByLevel {

    public List<Task> getAllTasks(TaskRepository taskRepository);

    public int count(TaskRepository taskRepository);

    public int getInfo(TaskRepository taskRepository);
}
