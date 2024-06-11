package com.example.wpic_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PopularFrameAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final LayoutInflater inflater;
    private final List<PopularFrame> popularFrames;

    private static final int TYPE_IMAGE = 0;
    private static final int TYPE_FULL_WIDTH_IMAGE = 1;

    public PopularFrameAdapter(Context context, List<PopularFrame> popularFrames) {
        this.popularFrames = popularFrames;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getItemViewType(int position) {
        if (position == popularFrames.size()) {
            return TYPE_FULL_WIDTH_IMAGE;
        }
        return TYPE_IMAGE;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_FULL_WIDTH_IMAGE) {
            View view = inflater.inflate(R.layout.item_full_width_image, parent, false);
            return new FullWidthImageViewHolder(view);
        } else {
            View view = inflater.inflate(R.layout.item_popular_frame, parent, false);
            return new ImageViewHolder(view);
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == TYPE_FULL_WIDTH_IMAGE) {
            FullWidthImageViewHolder fullWidthViewHolder = (FullWidthImageViewHolder) holder;
            fullWidthViewHolder.imageView.setImageResource(R.drawable.image_full);
        } else {
            ImageViewHolder imageViewHolder = (ImageViewHolder) holder;
            PopularFrame popularFrame = popularFrames.get(position);
            imageViewHolder.popularFrameView.setImageResource(popularFrame.getImageId());
        }
    }

    @Override
    public int getItemCount() {
        return popularFrames.size()+1;
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {
        final ImageView popularFrameView;

        ImageViewHolder(View view) {
            super(view);
            popularFrameView = view.findViewById(R.id.popularFrameView);
        }
    }

    static class FullWidthImageViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;

        FullWidthImageViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.image_full);
        }
    }
}