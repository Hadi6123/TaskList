package com.example.taskslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import adapter.ListAdapter;

public class MainActivity extends AppCompatActivity {

    //private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.viewTasks).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ViewTasks.class));
            }
        });

        findViewById(R.id.insertTask).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InsertTasks.class));
            }
        });

        //recyclerView = findViewById(R.id.taskListShow);

        //recyclerView.setAdapter(new ListAdapter(itemsArrayList.getItemsArrayList().subList(0, itemsArrayList.getItemsArrayList().size()-1), this));

    }
}