package com.example.projectpresetlightroom.fragements;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectpresetlightroom.R;
import com.example.projectpresetlightroom.activities.Detail;
import com.example.projectpresetlightroom.activities.HowItWorks;

import java.util.ArrayList;
import java.util.HashMap;

public class Presets extends Fragment {

    protected ListView lv;
    protected ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] Pil;
    String[] Gbr;
    String[] pilgbr;


    public Presets() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_presets, container, false);

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

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    int pos = (int) adapterView.getPositionForView(view);
                    String poss = Integer.toString(pos);
                    if(i == 0) {
                        Toast.makeText(getActivity(), "You choose Summer", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), Detail.class);
                        intent.putExtra("title", "Summer");
                        intent.putExtra("desc", "Luke Hobbs (Dwayne Johnson) membentuk aliansi yang tidak mungkin");
                        startActivity(intent);
                    } else if(i == 1){
                        Toast.makeText(getActivity(), "You choose Selfie", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), Detail.class);
                        intent.putExtra("title", "Summer");
                        intent.putExtra("desc", "Luke Hobbs (Dwayne Johnson) membentuk aliansi yang tidak mungkin");
                        startActivity(intent);
                    }   else if(i == 2) {
                        Toast.makeText(getActivity(), "You choose Fall", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), Detail.class);
                        intent.putExtra("title", "Summer");
                        intent.putExtra("desc", "Luke Hobbs (Dwayne Johnson) membentuk aliansi yang tidak mungkin");
                        startActivity(intent);
                    }    else if(i == 3) {
                        Toast.makeText(getActivity(), "You choose Jungle", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), Detail.class);
                        intent.putExtra("title", "Summer");
                        intent.putExtra("desc", "Luke Hobbs (Dwayne Johnson) membentuk aliansi yang tidak mungkin");
                        startActivity(intent);
                    } else if(i == 4) {
                        Toast.makeText(getActivity(), "You choose Sunset", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), Detail.class);
                        intent.putExtra("title", "Summer");
                        intent.putExtra("desc", "Luke Hobbs (Dwayne Johnson) membentuk aliansi yang tidak mungkin");
                        startActivity(intent);
                    }
                }
        });

        return rootView;
    }
}
