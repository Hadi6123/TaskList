package viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import builders.tasks.TaskDTOData;
import observerTask.ObserverImpl;
import repository.TaskRepository;

public class DeleteViewModel extends AndroidViewModel {

    private TaskRepository taskRepository;


    public DeleteViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application);
    }

    public void deleteTask(int id){
        taskRepository.deleteCurrentTask(id);
    }

    private TaskDTOData getItem(){
        return (TaskDTOData) ObserverImpl.getInstance().update();
    }

    public int getItemId(){
        return getItem().getId();
    }
}
