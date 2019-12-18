package com.example.projectpresetlightroom.fragements;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.projectpresetlightroom.R;
import com.example.projectpresetlightroom.adapters.PresetAdapters;
import com.example.projectpresetlightroom.models.PresetModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class Presets extends Fragment {

    //instansiasi Recyclerview
    RecyclerView rvSuperHero;
    //instansiasi list superhero
    List<PresetModel> listSuperHero = new ArrayList<>();

    public Presets() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_presets, container, false);

        rvSuperHero = view.findViewById(R.id.rvSuperHero);

        //Membuat object hero
        PresetModel hero = new PresetModel("Summer", R.drawable.summer);
        //menambahkan hero ke listSuperHero
        listSuperHero.add(hero);
        //membuat object hero baru
        hero = new PresetModel("Selfie", R.drawable.selfie);
        ;

        //menambahkan hero baru ke listSuperhero
        listSuperHero.add(hero);

        hero = new PresetModel("Fall", R.drawable.fall);
        listSuperHero.add(hero);
        hero = new PresetModel("Jungle", R.drawable.jungle);
        listSuperHero.add(hero);
        hero = new PresetModel("Sunset", R.drawable.sunset);
        listSuperHero.add(hero);
        //Instansiasi Adapter
        PresetAdapters superHeroAdapter = new PresetAdapters(listSuperHero);
        //set adapter dan layoutmanager
        rvSuperHero.setAdapter(superHeroAdapter);
        rvSuperHero.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

}
