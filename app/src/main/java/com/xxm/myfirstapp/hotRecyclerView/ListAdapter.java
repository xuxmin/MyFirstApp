package com.xxm.myfirstapp.hotRecyclerView;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter {

    private List<HotData> mDataList = new ArrayList<>();


    // Create ViewHolder
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // create layout
        return ListViewHolder.create(parent.getContext(), parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // bind data
        ((ListViewHolder) holder).bind(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public void setDataList(List<HotData> list) {
        if (!checkListNonNull(list)) {
            return;
        }
        mDataList = list;
    }

    private boolean checkListNonNull(List<HotData> list) {
        return list != null && list.size() != 0;
    }

    public void insert(HotData data, int index) {
        if (data == null || index < 0 || index > mDataList.size())
            return;
        mDataList.add(index, data);
        for (int i = index + 1; i < mDataList.size(); i++) {
            mDataList.get(i).moveBack();
        }
    }

    public void delete(int index){
        if (index < 0 || index >= mDataList.size()) return;
        mDataList.remove(index);
        for (int i = index; i < mDataList.size(); i++){
            mDataList.get(i).moveForward();
        }
    }


}
