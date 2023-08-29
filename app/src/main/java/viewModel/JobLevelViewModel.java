package viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import repository.TaskRepository;

public class JobLevelViewModel extends AndroidViewModel {

    private TaskRepository taskRepository;

    public JobLevelViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application);
    }

    public TaskRepository getTaskRepository(){
        return taskRepository;
    }
}
