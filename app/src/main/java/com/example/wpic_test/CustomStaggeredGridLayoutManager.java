package com.example.wpic_test;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class CustomStaggeredGridLayoutManager extends StaggeredGridLayoutManager {
    public CustomStaggeredGridLayoutManager(int spanCount, int orientation) {
        super(spanCount, orientation);
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec, int heightSpec) {
        super.onMeasure(recycler, state, widthSpec, heightSpec);

        if (state.getItemCount() > 0) {
            View lastChild = recycler.getViewForPosition(state.getItemCount() - 1);
            measureChild(lastChild, widthSpec, heightSpec);

            int width = View.MeasureSpec.getSize(widthSpec);
            int height = lastChild.getMeasuredHeight();
            int availableWidth = width - getPaddingLeft() - getPaddingRight();

            int columnWidth = availableWidth / getSpanCount();


            int[] layoutParams = new int[]{((LayoutParams) lastChild.getLayoutParams()).getSpanIndex()};
            boolean isLastItemInRow = layoutParams[0] == getSpanCount() - 1;

            if (isLastItemInRow) {
                int lastItemWidth = columnWidth * 2;
                lastChild.measure(View.MeasureSpec.makeMeasureSpec(lastItemWidth, View.MeasureSpec.EXACTLY), heightSpec);
            }
        }
    }
}
