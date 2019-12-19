package com.example.projectpresetlightroom.fragements;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.projectpresetlightroom.R;
import com.example.projectpresetlightroom.adapters.PresetAdapters;
import com.example.projectpresetlightroom.adapters.PresetAdaptersColletion;
import com.example.projectpresetlightroom.models.PresetModel;
import com.example.projectpresetlightroom.models.PresetModelCollect;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MyCollection extends Fragment {

    DatabaseReference database;
    RecyclerView rvCollection;
    List<PresetModelCollect> listCollection;
    ProgressDialog loading;

    public MyCollection() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_collection, container, false);

        rvCollection = view.findViewById(R.id.rvCollection);
        RecyclerView.LayoutManager mLayOutManager = new LinearLayoutManager(getActivity());
        rvCollection.setLayoutManager(mLayOutManager);
        rvCollection.setItemAnimator(new DefaultItemAnimator());

        database = FirebaseDatabase.getInstance().getReference();
        database.child("DataPreset").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                listCollection = new ArrayList<>();
                for (DataSnapshot noteDataSnapshot : dataSnapshot.getChildren()){
                    PresetModelCollect pm = noteDataSnapshot.getValue(PresetModelCollect.class);
                    pm.setKey(noteDataSnapshot.getKey());
                    listCollection.add(pm);
                }

                PresetAdaptersColletion pm = new PresetAdaptersColletion(listCollection);
                rvCollection.setAdapter(pm);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println(databaseError.getDetails()+" "+databaseError.getMessage());
            }
        });

//        //Membuat object hero
//        PresetModelCollect collect = new PresetModelCollect("Summer", R.drawable.summer);
//        //menambahkan hero ke listSuperHero
//        listCollection.add(collect);
//        //membuat object hero baru
//        collect = new PresetModelCollect("Selfie", R.drawable.selfie);
//
//        //menambahkan hero baru ke listSuperhero
//        listCollection.add(collect);
//
//        collect = new PresetModelCollect("Fall", R.drawable.fall);
//        listCollection.add(collect);
//        collect = new PresetModelCollect("Jungle", R.drawable.jungle);
//        listCollection.add(collect);
//        collect = new PresetModelCollect("Sunset", R.drawable.sunset);
//        listCollection.add(collect);
//        //Instansiasi Adapter
//        PresetAdaptersColletion superHeroAdapter = new PresetAdaptersColletion(listCollection);
//        //set adapter dan layoutmanager
//        rvCollection.setAdapter(superHeroAdapter);
//        rvCollection.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
