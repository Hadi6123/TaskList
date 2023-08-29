package com.example.taskslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ViewSpecificTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_specific_task);

        findViewById(R.id.doUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewSpecificTask.this, UpdateCurrentTask.class));
                /*startActivity(new Intent(ViewSpecificTask.this, UpdateCurrentTask.class).putExtra("idd",
                        getIntent().getIntExtra("id", 0)
                ) );*/
            }
        });

        findViewById(R.id.doDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewSpecificTask.this, DeleteTask.class));
                /*startActivity(new Intent(ViewSpecificTask.this, DeleteTask.class).putExtra("idd",
                        getIntent().getIntExtra("id", 0)
                )); */
            }
        });
    }
}