package viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import builders.tasks.TaskDTOData;
import repository.TaskRepository;

public class ViewingViewModel extends AndroidViewModel {

    private TaskRepository taskRepository;

    public ViewingViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application);
    }

    public MutableLiveData<List<TaskDTOData>> getAllTasks(){
        return taskRepository.getMutableLiveData();
    }

    public int getAllCount(){
        return taskRepository.count();
    }
}
