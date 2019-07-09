package com.xxm.myfirstapp.hotRecyclerView;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private Paint mPaint;

    public DividerItemDecoration() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.parseColor("#2B6FD5"));
    }


    // view 是 RecyclerView 中的 item, parent 是 RecyclerView 本身
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getChildAdapterPosition(view) != 0){
            outRect.top = 1;
        }
    }

    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);

        int childCount = parent.getChildCount();

        for (int i = 0; i < childCount; i ++) {
            View view = parent.getChildAt(i);

            int index = parent.getChildAdapterPosition(view);

            if (index == 0 || index > 3) {
                continue;
            }

            float dividerTop = view.getTop() - 1;
            float dividerLeft = parent.getPaddingLeft();
            float dividerBottom = view.getTop();
            float dividerRight = parent.getWidth() - parent.getPaddingRight();

            c.drawRect(dividerLeft,dividerTop,dividerRight,dividerBottom,mPaint);

        }
    }
}
