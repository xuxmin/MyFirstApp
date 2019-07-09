package com.xxm.myfirstapp.hotRecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xxm.myfirstapp.R;

public class HotActivity extends AppCompatActivity {

    private RecyclerView mListView;
    private ListAdapter mAdapter;
    private EditText mEditText;
    private Button mInsertButton, mDeleteButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot);
        // Initialize recycleView inside the activity
        mListView = findViewById(R.id.rl_hot);
        // Specify the layoutManager type
        mListView.setLayoutManager(new LinearLayoutManager(this));
        // Set itemDecoration
        mListView.addItemDecoration(new DividerItemDecoration());

        // Create adapter
        mAdapter = new ListAdapter();
        // Set Adapter
        mListView.setAdapter(mAdapter);
        // Set the data of the dapter
        mAdapter.setDataList(HotDataFactory.getHotData());

        mAdapter.notifyDataSetChanged();

        mEditText = findViewById(R.id.et_index);

        mInsertButton = findViewById(R.id.bt_insert);
        mInsertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditText.getText().toString().equals("")){
                    return;
                }
                int index = Integer.parseInt(mEditText.getText().toString());

                HotData data = new HotData(index+1, "add", 10000);
                insert(data, index);
            }
        });

        mDeleteButton = findViewById(R.id.bt_delete);
        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mEditText.getText().toString().equals("")){
                    return;
                }
                int index = Integer.parseInt(mEditText.getText().toString());
                delete(index);
            }
        });
    }

    public void insert(HotData data, int index) {
        mAdapter.insert(data, index);
        mAdapter.notifyDataSetChanged();
        // 列表 index 位置添加一条数据时可以调用，伴有动画效果
        mAdapter.notifyItemInserted(index);

    }

    public void delete(int index) {
        mAdapter.delete(index);
        // 列表 index 位置移除一条数据时调用，伴有动画效果
        mAdapter.notifyItemRemoved(index);
        mAdapter.notifyDataSetChanged();
    }
}
