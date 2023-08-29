package com.example.taskslist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import adapter.ListAdapter;
import builders.tasks.TaskDTOData;
import viewModel.ViewingViewModel;

public class ViewTasks extends AppCompatActivity {

    private RecyclerView listRV;
    private ViewingViewModel viewingViewModel;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tasks);

        listRV = findViewById(R.id.taskListShow);

        viewingViewModel = new ViewModelProvider(this).get(ViewingViewModel.class);

        LiveData<List<TaskDTOData>> taskList = viewingViewModel.getAllTasks();
        taskList.observe(this, new Observer<List<TaskDTOData>>() {
            @Override
            public void onChanged(List<TaskDTOData> taskDTOData) {
                Toast.makeText(ViewTasks.this, String.valueOf(taskDTOData.size()), Toast.LENGTH_SHORT).show();
                listRV.setAdapter(new ListAdapter(taskDTOData, ViewTasks.this));
                //Toast.makeText(this, Integer.toString(ItemsList.getInstance().getList().size()), Toast.LENGTH_SHORT).show();
            }
        });

        textView = findViewById(R.id.textView3);
        textView.setText("Total Number of Tasks: " + Integer.toString(viewingViewModel.getAllCount()));

    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.view_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent = new Intent(this, ViewTaskByLevel.class);

        int itemID = item.getItemId();

        if (itemID != R.id.numberPerLevels){
            if (itemID == R.id.easy){
                intent.putExtra("level", 3);
                startActivity(intent);
            } else if (itemID == R.id.meidum){
                intent.putExtra("level", 5);
                startActivity(intent);
            } else {
                intent.putExtra("level", 9);
                startActivity(intent);
            }
        } else {
            startActivity(new Intent(this, LevelCount.class));
        }


        return super.onContextItemSelected(item);
    }

}