package com.example.taskslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import adapter.ListAdapter;
import adapter.TaskLevelAdapter;
import builders.tasks.model.Task;
import factory.TaskLevelFactory;
import tasksByLevel.OrderByLevel;
import viewModel.JobLevelViewModel;
import viewModel.ViewingViewModel;

public class ViewTaskByLevel extends AppCompatActivity {

    private TextView count, avgLevel;
    private RecyclerView recyclerView;
    private JobLevelViewModel jobLevelViewModel;

    private OrderByLevel orderByLevelMethod;

    private int level;
    private TaskLevelFactory taskLevelFactory;

    public ViewTaskByLevel(){
        taskLevelFactory = new TaskLevelFactory();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_task_by_level);

        level = getIntent().getIntExtra("level", 3);

        setMethod((OrderByLevel) taskLevelFactory.span(level));

        recyclerView = findViewById(R.id.jobShow);
        jobLevelViewModel = new ViewModelProvider(this).get(JobLevelViewModel.class);

        recyclerView.setAdapter(new TaskLevelAdapter(getAllTasks()));

        count = findViewById(R.id.numberByLevel);
        avgLevel = findViewById(R.id.avgLevel);

        count.setText("Total Count: "+ ((OrderByLevel) taskLevelFactory.span(level)).count(jobLevelViewModel.getTaskRepository()));
        avgLevel.setText("Average Level: " + ((OrderByLevel) taskLevelFactory.span(level)).getInfo(jobLevelViewModel.getTaskRepository()));


    }

    private void setMethod(OrderByLevel orderByLevel){
        orderByLevelMethod = orderByLevel;
    }

    private List<Task> getAllTasks(){
        return orderByLevelMethod.getAllTasks(jobLevelViewModel.getTaskRepository());
    }
}