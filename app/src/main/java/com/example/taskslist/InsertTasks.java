package com.example.taskslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import builders.tasks.TaskDTO;
import builders.tasks.TaskDTOBuilder;
import builders.tasks.TaskDTOData;
import builders.tasks.TaskDTODataBuilder;
import builders.tasks.model.Task;
import viewModel.InsertionViewModel;

public class InsertTasks extends AppCompatActivity {

    private TextView count;
    private EditText enterName, enterSeverity, enterPriority, enterDescription;
    private InsertionViewModel insertionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_tasks);

        count = findViewById(R.id.totalCount);
        enterName = findViewById(R.id.enterName);
        enterSeverity = findViewById(R.id.enterLevel);
        enterPriority = findViewById(R.id.enterPriority);
        enterDescription = findViewById(R.id.enterDescription);

        insertionViewModel = new ViewModelProvider(this).get(InsertionViewModel.class);

        LiveData<Integer> totalCount = insertionViewModel.countTasks();
        totalCount.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                count.setText("Total Tasks: " + integer);
            }
        });

        findViewById(R.id.insert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(enterName.getText().toString()) && !TextUtils.isEmpty(enterSeverity.getText().toString())
                                    && !TextUtils.isEmpty(enterPriority.getText().toString())){
                    insertInputs();
                } else {
                    Toast.makeText(InsertTasks.this, "Enter all required inputs", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void insertInputs(){
        try{
            int severityInput = Integer.parseInt(enterSeverity.getText().toString()) ;
            int priorityInput = Integer.parseInt(enterPriority.getText().toString());

            Task newTask = new Task(enterName.getText().toString(), severityInput, priorityInput, enterDescription.getText().toString());
            TaskDTOBuilder builder = new TaskDTODataBuilder();
            //Client has to provide director with concrete builder
            TaskDTO dto = builder.withName(newTask.getName())
                    .withSeverity(newTask.getServerity())
                    .withImage(newTask.getServerity())
                    .withPriority(newTask.getPriority())
                    .withDescription(newTask.getDescription())
                    .build();

            insertionViewModel.addNewTask((TaskDTOData) dto);
            insertionViewModel.updateTaskCount();
            //Toast.makeText(this, "hahah  " + Integer.toString(insertionViewModel.getTaskCount()), Toast.LENGTH_SHORT).show();

        } catch (Exception e){
            //e.printStackTrace();
            Toast.makeText(this, "Enter appropiate inputs", Toast.LENGTH_SHORT).show();
        }
    }
}