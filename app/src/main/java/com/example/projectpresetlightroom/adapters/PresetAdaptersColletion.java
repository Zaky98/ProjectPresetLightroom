package com.example.projectpresetlightroom.adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpresetlightroom.R;
import com.example.projectpresetlightroom.activities.Detail;
import com.example.projectpresetlightroom.activities.DetailCollection;
import com.example.projectpresetlightroom.models.PresetModel;
import com.example.projectpresetlightroom.models.PresetModelCollect;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class PresetAdaptersColletion extends RecyclerView.Adapter<PresetAdaptersColletion.MyViewHolder> {

    List<PresetModelCollect> presetList;
    DatabaseReference database;


    public PresetAdaptersColletion(List<PresetModelCollect> presetList) {
        this.presetList = presetList;
    }

    @NonNull
    @Override
    public PresetAdaptersColletion.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //object context diambil dari parent
        Context context = parent.getContext();
        //object context digunakan untuk membuat object layoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //object layoutInflater digunakan untuk membuat object view yang merupakan hasil inflate  layout ( mengubungkan adapter degnan layout)
        View listView = layoutInflater.inflate(R.layout.item_collection,parent,false);
        //object superHeroView digunakan untuk membuat object viewHolder
        MyViewHolder viewHolder = new MyViewHolder(listView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PresetAdaptersColletion.MyViewHolder holder, final int position) {
        //ambil satu item hero

        final PresetModelCollect preset = presetList.get(position);
        //set text heroName berdasarkan data dari model hero
        holder.presetGambarColl.setImageResource(preset.getPresetGambarcoll());
        holder.presetNameColl.setText(preset.getPresetNamecoll());
        holder.presetGambarColl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                String judul = preset.getPresetNamecoll();
                String desc = preset.getDesc();
                int img = preset.getPresetGambarcoll();
                Toast.makeText(view.getContext(), "You choose " + judul, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(view.getContext(), DetailCollection.class);
                intent.putExtra("gbr", img);
                intent.putExtra("title", judul);
                intent.putExtra("desc", desc);
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (presetList != null) ? presetList.size() : 0;
        /*for non shorthand people*/
        /*if(heroList!=null){
          return heroList.size();
        }else{
          return 0;
        }*/
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView presetNameColl;
        public ImageView presetGambarColl;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            presetNameColl = itemView.findViewById(R.id.presetNamecoll);
            presetGambarColl = itemView.findViewById(R.id.presetGambarcoll);
        }
    }
}
