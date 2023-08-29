package com.example.taskslist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import viewModel.LevelCountViewModel;

public class LevelCount extends AppCompatActivity {

    //public static Observer instance = this;
    private ListView listView;
    private ArrayAdapter adapter;
    private ArrayList<String> counts;
    private LevelCountViewModel levelCountViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_count);

        levelCountViewModel = new ViewModelProvider(this).get(LevelCountViewModel.class);

         counts = levelCountViewModel.getResults();

        adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, counts);


        listView = (ListView) findViewById(R.id.listOfCounts);
        listView.setAdapter(adapter);
    }
}