package viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import java.util.ArrayList;

import builders.tasks.model.TaskLevelCount;
import repository.TaskRepository;

public class LevelCountViewModel extends AndroidViewModel {

    private TaskRepository taskRepository;

    public LevelCountViewModel(@NonNull Application application) {
        super(application);
        taskRepository = new TaskRepository(application);
    }

    public ArrayList<String> getResults(){

        TaskLevelCount temp = new TaskLevelCount();

        return temp.getCountStringList(taskRepository.getLevelCounts());
    }

}
