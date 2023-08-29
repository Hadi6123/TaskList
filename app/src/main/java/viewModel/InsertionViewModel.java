package viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import builders.tasks.TaskDTOData;
import repository.TaskRepository;

public class InsertionViewModel extends AndroidViewModel {

    private int count;

    private MutableLiveData<Integer> taskCount = new MutableLiveData<>();

    private TaskRepository taskRepository;

    public InsertionViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application);

    }

    public MutableLiveData<Integer> countTasks() {

        count = getTaskCount();

        taskCount.postValue(count);
        return taskCount;
    }

    public void updateTaskCount() {
        count = getTaskCount();
        taskCount.postValue(count);
    }

    public void addNewTask(TaskDTOData taskDTOData){
        taskRepository.addTask(taskDTOData);
    }

    private int getTaskCount(){
        return taskRepository.count();
    }
}
