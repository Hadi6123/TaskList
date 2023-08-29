package factory;

import android.app.Application;

import repository.TaskRepository;

public interface Factory {

    Object span(int level);
}
