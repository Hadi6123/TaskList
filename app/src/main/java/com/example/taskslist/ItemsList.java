package com.example.taskslist;

import java.util.ArrayList;
import java.util.List;

import builders.tasks.TaskDTO;

public class ItemsList {

    private static ItemsList instance;
    private List<TaskDTO> list;

    private ItemsList(){
        list = new ArrayList<>();
    }

    public static ItemsList getInstance(){
        synchronized (ItemsList.class){
            if (instance == null){
                instance = new ItemsList();
            }

            return instance;
        }
    }

    public List<TaskDTO> getList(){
        return list;
    }

    public void addItem(TaskDTO taskDTO){
        list.add(taskDTO);
    }


}
