package tasksByLevel;

import android.app.Application;
import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import builders.tasks.model.Task;
import builders.tasks.model.TaskLevelInfo;
import repository.TaskRepository;

public class GetEasyTasks implements OrderByLevel{
    @Override
    public List<Task> getAllTasks(TaskRepository taskRepository) {

        return taskRepository.getEasyTasks();
    }

    @Override
    public int count(TaskRepository taskRepository) {
        return taskRepository.easyCount();
    }

    @Override
    public int getInfo(TaskRepository taskRepository) {
        return taskRepository.getEasyLevelInfo().getTask_info();
    }
}
