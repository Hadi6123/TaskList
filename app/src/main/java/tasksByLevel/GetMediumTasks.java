package tasksByLevel;

import java.util.List;

import builders.tasks.model.Task;
import builders.tasks.model.TaskLevelInfo;
import repository.TaskRepository;

public class GetMediumTasks implements OrderByLevel {
    @Override
    public List<Task> getAllTasks(TaskRepository taskRepository) {
        return taskRepository.getMediumTasks();
    }

    @Override
    public int count(TaskRepository taskRepository) {
        return taskRepository.mediumCount();
    }

    @Override
    public int getInfo(TaskRepository taskRepository) {
        return taskRepository.getMediumLevelInfo().getTask_info();
    }
}
