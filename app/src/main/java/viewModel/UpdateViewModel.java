package viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import builders.tasks.TaskDTOData;
import observerTask.ObserverImpl;
import repository.TaskRepository;

public class UpdateViewModel extends AndroidViewModel {

    private TaskRepository taskRepository;


    public UpdateViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application);
    }

    public void updateTask(TaskDTOData taskDTOData){
        taskRepository.updateCurrentTask(taskDTOData);
    }

    private TaskDTOData getItem(){
        return (TaskDTOData) ObserverImpl.getInstance().update();
    }

    public int getItemId(){
        return getItem().getId();
    }

    public String getItemName(){
        return getItem().getName();
    }

    public int getItemSeverity(){
        return getItem().getSeverity();
    }

    public int getItemPriority(){
        return getItem().getPriority();
    }

    public String getItemDescription(){
        return getItem().getDescription();
    }
}
