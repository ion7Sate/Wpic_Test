package com.example.wpic_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;



public class FrameAdapter  extends RecyclerView.Adapter<FrameAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<Frame> frames;


    FrameAdapter(Context context, List<Frame> frames) {
       this.frames = frames;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public FrameAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_frame, parent, false);
        return new ViewHolder(view);

    }


    @Override
    public void onBindViewHolder(FrameAdapter.ViewHolder holder, int position) {
        Frame frame= frames.get(position);
        holder.buttonView.setImageResource(frame.getImageId());
        holder.titleView.setText(frame.getTitle());
    }

    @Override
    public int getItemCount() {
        return frames.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView buttonView;
        final TextView titleView;
        ViewHolder(View view){
            super(view);
            buttonView = view.findViewById(R.id.buttonView);
            titleView = view.findViewById(R.id.titleView);

        }
    }

}
