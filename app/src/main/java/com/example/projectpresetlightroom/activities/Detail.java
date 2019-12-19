package com.example.projectpresetlightroom.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectpresetlightroom.R;
import com.example.projectpresetlightroom.models.PresetModel;
import com.example.projectpresetlightroom.models.PresetModelCollect;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Detail extends AppCompatActivity {

    public TextView title;
    public TextView descs;
    public ImageView gbr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        gbr = findViewById(R.id.imageView);
        title = findViewById(R.id.judulpreset);
        descs = findViewById(R.id.Penjelasan);
        title.setText(getIntent().getExtras().getString("title"));
        descs.setText(getIntent().getExtras().getString("desc"));
        gbr.setImageResource(getIntent().getExtras().getInt("gbr"));
    }

    public void how(View view) {
        Intent intent = new Intent(this, HowItWorks .class);
        startActivity(intent) ;
    }

    public void favorit(final View view) {


        Intent i = getIntent();
        final int gambar = i.getIntExtra("gbr", 0);
        final String jdl = i.getStringExtra("title");
        final String desc = i.getStringExtra("desc");


        final DatabaseReference database = FirebaseDatabase.getInstance().getReference();

        final PresetModelCollect pm = new PresetModelCollect();
        pm.setPresetGambarcoll(gambar);
        pm.setPresetNamecoll(jdl);
        pm.setDesc(desc);

        Query query = database.child("DataPreset").orderByChild("presetNamecoll").equalTo(jdl);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    Toast.makeText(view.getContext(), "Preset already in My Collection", Toast.LENGTH_SHORT).show();
                } else {
                    database.child("DataPreset").push().setValue(pm).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(view.getContext(), "Add to My Collection", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
