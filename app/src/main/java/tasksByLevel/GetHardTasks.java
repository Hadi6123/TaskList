package tasksByLevel;

import java.util.List;

import builders.tasks.model.Task;
import builders.tasks.model.TaskLevelInfo;
import repository.TaskRepository;

public class GetHardTasks implements OrderByLevel{
    @Override
    public List<Task> getAllTasks(TaskRepository taskRepository) {
        return taskRepository.getHardTasks();
    }

    @Override
    public int count(TaskRepository taskRepository) {
        return taskRepository.hardCount();
    }

    @Override
    public int getInfo(TaskRepository taskRepository) {
        return taskRepository.getHardLevelInfo().getTask_info();
    }
}
