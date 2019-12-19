package com.example.projectpresetlightroom.fragements;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.projectpresetlightroom.R;

import java.util.ArrayList;
import java.util.HashMap;

public class Dummy extends Fragment {

    protected ListView lv;
    protected ListAdapter adapter;
    SimpleAdapter Adapter;
    HashMap<String, String> map;
    ArrayList<HashMap<String, String>> mylist;
    String[] Pil;
    String[] Gbr;
    String[] pilgbr;
    private int buttonState = 1;
    Button location;


    public Dummy() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_dummy, container, false);

//        lv = (ListView) rootView.findViewById(R.id.lv);
//
//        Pil = new String[] {"Summer", "selfie", "Fall", "Jungle", "Sunset"};
//        Gbr = new String[] {Integer.toString(R.drawable.summer),
//                Integer.toString(R.drawable.selfie),
//                Integer.toString(R.drawable.fall),
//                Integer.toString(R.drawable.jungle),
//                Integer.toString(R.drawable.sunset) };
//
//        mylist = new ArrayList<HashMap<String,String>>();
//
//        for (int i = 0; i < Pil.length; i++){
//            map = new HashMap<String, String>();
//            map.put("list", Pil[i]);
//            map.put("gbr", Gbr[i]);
//            mylist.add(map);
//        }
//
//        Adapter = new SimpleAdapter(getContext(), mylist, R.layout.list_dummy,
//                new String[] {"list", "gbr"}, new int[] {R.id.tv_nama, R.id.imV});
//        lv.setAdapter(Adapter);
//
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                @Override
//                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                    int pos = (int) adapterView.getPositionForView(view);
//                    String poss = Integer.toString(pos);
//                    if(i == 0) {
//                        Toast.makeText(getActivity(), "You choose Summer", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getActivity(), Detail.class);
//                        intent.putExtra("title", "Summer");
//                        intent.putExtra("desc", "Beach, jungle, sea, desert, grass, sunset");
//                        startActivity(intent);
//                    } else if(i == 1){
//                        Toast.makeText(getActivity(), "You choose selfie", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getActivity(), Detail.class);
//                        intent.putExtra("title", "selfie");
//                        intent.putExtra("desc", "selfie, potrait, perfect skin, bloggers, wedding, family");
//                        startActivity(intent);
//                    }   else if(i == 2) {
//                        Toast.makeText(getActivity(), "You choose Fall", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getActivity(), Detail.class);
//                        intent.putExtra("title", "Fall");
//                        intent.putExtra("desc", "Fall, forest, foliage, potrait, landscapes");
//                        startActivity(intent);
//                    }    else if(i == 3) {
//                        Toast.makeText(getActivity(), "You choose Jungle", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getActivity(), Detail.class);
//                        intent.putExtra("title", "Jungle");
//                        intent.putExtra("desc", "Jungle, green color, waterfall");
//                        startActivity(intent);
//                    } else if(i == 4) {
//                        Toast.makeText(getActivity(), "You choose Sunset", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getActivity(), Detail.class);
//                        intent.putExtra("title", "Sunset");
//                        intent.putExtra("desc", "Sunset, sunrises, dark colors");
//                        startActivity(intent);
//                    }
//                }
//        });

        return rootView;
    }

}
