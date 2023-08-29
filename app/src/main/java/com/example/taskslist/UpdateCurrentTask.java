package com.example.taskslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import builders.tasks.TaskDTO;
import builders.tasks.TaskDTOBuilder;
import builders.tasks.TaskDTOData;
import builders.tasks.TaskDTODataBuilder;
import builders.tasks.model.Task;
import viewModel.InsertionViewModel;
import viewModel.UpdateViewModel;

public class UpdateCurrentTask extends AppCompatActivity {

    private EditText enterName, enterSeverity, enterPriority, enterDescription;
    private UpdateViewModel updateViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_current_task);

        updateViewModel = new ViewModelProvider(this).get(UpdateViewModel.class);

        enterName = findViewById(R.id.updateName);
        enterName.setText(updateViewModel.getItemName());

        enterSeverity = findViewById(R.id.updateLevel);
        enterSeverity.setText(Integer.toString(updateViewModel.getItemSeverity()));

        enterPriority = findViewById(R.id.updatePriority);
        enterPriority.setText(Integer.toString(updateViewModel.getItemPriority()));

        enterDescription = findViewById(R.id.updateDescription);
        enterDescription.setText(updateViewModel.getItemDescription());

        findViewById(R.id.updateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(enterName.getText().toString()) && !TextUtils.isEmpty(enterSeverity.getText().toString())
                        && !TextUtils.isEmpty(enterPriority.getText().toString())){
                    update();
                    startActivity(new Intent(UpdateCurrentTask.this, MainActivity.class));
                }
            }
        });
    }

    private void update() {
        try{
            int severityInput = Integer.parseInt(enterSeverity.getText().toString()) ;
            int priorityInput = Integer.parseInt(enterPriority.getText().toString());

            Task newTask = new Task(enterName.getText().toString(), severityInput, priorityInput, enterDescription.getText().toString() );


            TaskDTOBuilder builder = new TaskDTODataBuilder();
            //Client has to provide director with concrete builder
            TaskDTO dto = builder.withName(newTask.getName())
                    .withSeverity(newTask.getServerity())
                    .withImage(newTask.getServerity())
                    .withPriority(newTask.getPriority())
                    .withDescription(newTask.getDescription())
                    .build();

            TaskDTOData data = (TaskDTOData) dto;

            //data.setId(getIntent().getIntExtra("idd", 0));
            data.setId(updateViewModel.getItemId());

            updateViewModel.updateTask((TaskDTOData) dto);

        } catch (Exception e){
            e.printStackTrace();
            //Toast.makeText(InsertTasks.this, "Enter appropaiet inputs", Toast.LENGTH_SHORT).show();
        }
    }
}