package com.example.taskslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import viewModel.DeleteViewModel;

public class DeleteTask extends AppCompatActivity {

    private DeleteViewModel deleteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_task);

        deleteViewModel = new ViewModelProvider(this).get(DeleteViewModel.class);

        findViewById(R.id.yesExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*deleteViewModel.deleteTask(getIntent().getIntExtra(
                        "idd", 0
                ));*/

                deleteViewModel.deleteTask(deleteViewModel.getItemId());

                finish();
                startActivity(new Intent(DeleteTask.this, MainActivity.class));
            }
        });

        findViewById(R.id.noExit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                startActivity(new Intent(DeleteTask.this, MainActivity.class));
            }
        });
    }
}