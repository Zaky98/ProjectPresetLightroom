package com.example.projectpresetlightroom.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    public void how(View view) {
        Intent intent = new Intent(this, HowItWorks .class);
        startActivity(intent) ;
    }

    public void favorit(View view) {
        Toast.makeText(this, "Add to My Collection", Toast.LENGTH_SHORT).show();
//        Button but = findViewById(R.id.button);
//        int color = ((ColorDrawable)but.getBackground()).getColor();
//        int greylight = getResources().getColor(R.color.greylight);
//        if(color == greylight){
//            but.setBackgroundColor(Color.RED);
//            Toast.makeText(this, "Add to My Collection", Toast.LENGTH_SHORT).show();
//        } else {
//            but.setBackgroundColor(greylight);
//            Toast.makeText(this, "Delete from My Collection", Toast.LENGTH_SHORT).show();
//        }
    }

}
