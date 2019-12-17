package com.example.projectpresetlightroom.fragements;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.projectpresetlightroom.R;
import com.example.projectpresetlightroom.activities.Detail;
//import com.example.projectpresetlightroom.adapters.PresetAdapters;
//import com.example.projectpresetlightroom.models.PresetModels;

import java.util.ArrayList;
import java.util.HashMap;

public class Presets extends Fragment {

//    RecyclerView rvPreset;
//    List<PresetModels> listPreset = new ArrayList<>();

    protected ListView lv;
    protected ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] Pil;
    String[] Ltn;
    String[] Gbr;

    public Presets() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_presets, container, false);
        View rootView = inflater.inflate(R.layout.fragment_presets, container, false);

//        //menyambungkan rvSuperHero ke layout
//        rvPreset = rootView.findViewById(R.id.rvSuperHero);
//        PresetModels hero = new PresetModels("Petruk", Integer.toString(R.drawable.brush));
//        //menambahkan hero ke listSuperHero
//        listPreset.add(hero);
//        //membuat object hero baru
//        hero = new PresetModels("Gareng", Integer.toString(R.drawable.brush));
//        //menambahkan hero baru ke listSuperhero
//        listPreset.add(hero);
//        //Instansiasi Adapter
//        PresetAdapters superHeroAdapter = new PresetAdapters(listPreset);
//        //set adapter dan layoutmanager
//        rvPreset.setAdapter(superHeroAdapter);
//        rvPreset.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        lv = (ListView) rootView.findViewById(R.id.lv);

        Pil = new String[] {"Summer", "Selfie", "Fall", "Jungle", "Sunset"};
        Gbr = new String[] {Integer.toString(R.drawable.summer),
                Integer.toString(R.drawable.selfie),
                Integer.toString(R.drawable.fall),
                Integer.toString(R.drawable.jungle),
                Integer.toString(R.drawable.sunset) };

        mylist = new ArrayList<HashMap<String,String>>();

        for (int i = 0; i < Pil.length; i++){
            map = new HashMap<String, String>();
            map.put("list", Pil[i]);
            map.put("gbr", Gbr[i]);
            mylist.add(map);
        }

        Adapter = new SimpleAdapter(getContext(), mylist, R.layout.list_preset,
                new String[] {"list", "gbr"}, new int[] {R.id.tv_nama, R.id.imV});
        lv.setAdapter(Adapter);

        View imageview = rootView.findViewById(R.id.imV);
        View textview  = rootView.findViewById(R.id.tv_nama);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), Detail.class);
                if (Integer.toString(R.id.tv_nama) == "summer") {
                    i.putExtra("title", "The Fate of the Furious (2017)");
                    i.putExtra("desc", "Luke Hobbs (Dwayne Johnson) membentuk aliansi yang tidak mungkin " +
                            "dengan Deckard Shaw (Jason Statham). Keduanya terpaksa bersatu membantu Hattie Shaw " +
                            "(Vanessa Kirby) untuk memburu Brixton (Idris Elba). Brixton adalah penjahat jenis baru " +
                            "yang berhasil mengubah dirinya menjadi " +
                            "manusia super. Keberadaanya menjadi ancaman bagi umat manusia.");
                    startActivity(i);
                }
            }
        });

        return rootView;
    }

}
