package com.example.foodcourtlisttask.main.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.foodcourtlisttask.R;

/**
 * Created by Aya on 27/08/2018.
 */

public class RecyclerViewDecorator extends RecyclerView.ItemDecoration {
    private Drawable lineDivider;

    public RecyclerViewDecorator(Context context) {
        lineDivider = context.getResources().getDrawable(R.drawable.horizontal_divider_recyclerview);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if (view == parent) {
            outRect.set(0, 0, 0, lineDivider.getIntrinsicHeight());
        } else {
            outRect.setEmpty();
        }
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int dividerLeft = parent.getPaddingLeft();
        int dividerRight = parent.getWidth() - parent.getPaddingRight();

        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View child = parent.getChildAt(i);

            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + lineDivider.getIntrinsicHeight();
            lineDivider.setBounds(dividerLeft, top, dividerRight, bottom);
            if ((parent.getChildAdapterPosition(child) == parent.getAdapter().getItemCount() - 1) && parent.getBottom() < bottom) { // this prevent a parent to hide the last item's divider
                parent.setPadding(parent.getPaddingLeft(), parent.getPaddingTop(), parent.getPaddingRight(), bottom - parent.getBottom());
            }

            lineDivider.draw(c);
        }
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);

    }
}
