package com.example.wpic_test;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    ArrayList<Frame> frames = new ArrayList<Frame>();
    private RecyclerView.LayoutManager layoutManager;
    private TextView timeTextView;
    private Handler handler = new Handler(Looper.getMainLooper());
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());

    private Runnable updateTimeTask = new Runnable() {
        @Override
        public void run() {
            String currentTime = timeFormat.format(new Date());
            timeTextView.setText(currentTime);
            handler.postDelayed(this, 60000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.frame);
        layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        FrameAdapter adapter = new FrameAdapter(this, frames);
        recyclerView.setAdapter(adapter);



        timeTextView = findViewById(R.id.tv_time);
        handler.post(updateTimeTask);


        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }



    }

    private void setInitialData(){

        frames.add(new Frame (R.drawable.ic_single_frames,"Single Frames"));
        frames.add(new Frame (R.drawable.ic_double_frames,"Double Frames"));
        frames.add(new Frame (R.drawable.ic_triple_frames,"Triple Frames"));
        frames.add(new Frame (R.drawable.ic_collage,"Collage"));
        frames.add(new Frame (R.drawable.ic_photo_edit,"Photo Edit"));
        frames.add(new Frame (R.drawable.ic_add_text,"Add Text"));

    }




}