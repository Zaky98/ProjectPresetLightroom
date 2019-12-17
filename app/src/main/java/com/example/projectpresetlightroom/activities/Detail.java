package com.example.projectpresetlightroom.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.projectpresetlightroom.R;

public class Detail extends AppCompatActivity {

    public TextView title;
    public TextView descs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        title = findViewById(R.id.judulpreset);
        descs = findViewById(R.id.Penjelasan);
        title.setText(getIntent().getExtras().getString("title"));
        descs.setText(getIntent().getExtras().getString("desc"));
    }

}
