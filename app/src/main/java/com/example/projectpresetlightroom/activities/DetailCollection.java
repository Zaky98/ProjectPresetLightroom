package com.example.projectpresetlightroom.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectpresetlightroom.R;
import com.example.projectpresetlightroom.adapters.PresetAdaptersColletion;
import com.example.projectpresetlightroom.models.PresetModelCollect;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DetailCollection extends AppCompatActivity {

    public DatabaseReference database;
    public TextView titlecol;
    public TextView descscol;
    public ImageView gbrcol;
    List<PresetModelCollect> listCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_collection);
        gbrcol = findViewById(R.id.imageViewCol);
        titlecol = findViewById(R.id.judulpresetcol);
        descscol = findViewById(R.id.Penjelasancol);
        titlecol.setText(getIntent().getExtras().getString("title"));
        descscol.setText(getIntent().getExtras().getString("desc"));
        gbrcol.setImageResource(getIntent().getExtras().getInt("gbr"));

    }

    public void how(View view) {
        Intent intent = new Intent(this, HowItWorks .class);
        startActivity(intent) ;
    }

    public void Delete(final View view) {

        String judul = getIntent().getExtras().getString("title");
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        Query applesQuery = ref.child("DataPreset").orderByChild("presetNamecoll").equalTo(judul);

        applesQuery.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot appleSnapshot : dataSnapshot.getChildren()) {
                    appleSnapshot.getRef().removeValue();
                    Toast.makeText(view.getContext(),"Delete from My Collection",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println(databaseError.getDetails() + " " + databaseError.getMessage());
            }
        });

    }
}



