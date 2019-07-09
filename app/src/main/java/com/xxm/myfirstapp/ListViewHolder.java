package com.xxm.myfirstapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class ListViewHolder extends RecyclerView.ViewHolder {

    private TextView mNoTextView;
    private TextView mTitleTextView;
    private TextView mHotValueTextView;

    public ListViewHolder(@NonNull View itemView) {
        super(itemView);
        // 给 layout 中的 view 实例化
        mNoTextView = itemView.findViewById(R.id.no);
        mTitleTextView = itemView.findViewById(R.id.title);
        mHotValueTextView = itemView.findViewById(R.id.hotValue);
    }

    public static ListViewHolder create(Context context, ViewGroup root) {
        // 新建一个 layout
        View v = LayoutInflater.from(context).inflate(R.layout.layout_item_list, root, false);
        return new ListViewHolder(v);
    }

    // 将数据绑定到 layout 的 textView 中
    public void bind(HotData data) {
        if (null == data) return;

        mNoTextView.setText(data.getNo() + "");
        if (data.getNo() <= 3){
            mNoTextView.setTextColor(Color.parseColor("#e6face15"));
        }
        mTitleTextView.setText(data.getTitle() + "");
        mHotValueTextView.setText(data.getHotValue() + "");
    }
}
