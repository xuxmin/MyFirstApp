package com.xxm.myfirstapp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HotActivity extends AppCompatActivity {

    private RecyclerView mListView;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot);
        // Initialize recycleView inside the activity
        mListView = findViewById(R.id.rl_hot);
        // Specify the layoutManager type
        mListView.setLayoutManager(new LinearLayoutManager(this));
        // Create adapter
        mAdapter = new ListAdapter();
        // Set Adapter
        mListView.setAdapter(mAdapter);
        // Set the data of the dapter
        mAdapter.setDataList(HotDataFactory.getHotData());

        mAdapter.notifyDataSetChanged();
    }
}
