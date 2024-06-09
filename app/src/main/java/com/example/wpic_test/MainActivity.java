package com.example.wpic_test;

import static com.example.wpic_test.R.*;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private TextView textMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ImageButton buttonAdd = findViewById(R.id.button_add);
        ImageButton buttonSettings = findViewById(R.id.button_settings);
        textMessage = findViewById(R.id.text_message);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onAddButtonClick();
            }
        });

        buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSettingsButtonClick();
            }
        });
    }

    private void onAddButtonClick() {
        textMessage.setVisibility(View.VISIBLE);
        textMessage.setText("Add Button is pressed");
    }

    private void onSettingsButtonClick() {
        textMessage.setVisibility(View.VISIBLE);
        textMessage.setText("Settings Button is pressed");
    }

}