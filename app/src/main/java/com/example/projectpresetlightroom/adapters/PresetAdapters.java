package com.example.projectpresetlightroom.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpresetlightroom.R;
import com.example.projectpresetlightroom.activities.Detail;
import com.example.projectpresetlightroom.models.PresetModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class PresetAdapters extends RecyclerView.Adapter<PresetAdapters.MyViewHolder> {

    List<PresetModel> presetList;
    Context c;

    public PresetAdapters(List<PresetModel> presetList) {
        this.presetList = presetList;
    }

    @NonNull
    @Override
    public PresetAdapters.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //object context diambil dari parent
        Context context = parent.getContext();
        //object context digunakan untuk membuat object layoutInflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        //object layoutInflater digunakan untuk membuat object view yang merupakan hasil inflate  layout ( mengubungkan adapter degnan layout)
        View listView = layoutInflater.inflate(R.layout.item_preset,parent,false);
        //object superHeroView digunakan untuk membuat object viewHolder
        MyViewHolder viewHolder = new MyViewHolder(listView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PresetAdapters.MyViewHolder holder, final int position) {
        //ambil satu item hero

        final PresetModel preset = presetList.get(position);
        //set text heroName berdasarkan data dari model hero
        holder.presetName.setText(preset.getPresetName());
        holder.presetGambar.setImageResource(preset.getPresetGambar());
        holder.presetGambar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (position == 0){
                    Toast.makeText(view.getContext(), "You choose Summer", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    intent.putExtra("title", "Summer");
                    intent.putExtra("desc", "Beach, jungle, sea, desert, grass, sunset");
                    view.getContext().startActivity(intent);
                } else if(position == 1){
                    Toast.makeText(view.getContext(), "You choose Selfie", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    intent.putExtra("title", "Selfie");
                    intent.putExtra("desc", "Selfie, potrait, perfect skin, bloggers, wedding, family");
                    view.getContext().startActivity(intent);
                }   else if(position == 2) {
                    Toast.makeText(view.getContext(), "You choose Fall", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    intent.putExtra("title", "Fall");
                    intent.putExtra("desc", "Fall, forest, foliage, potrait, landscapes");
                    view.getContext().startActivity(intent);
                }   else if(position == 3) {
                    Toast.makeText(view.getContext(), "You choose Jungle", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    intent.putExtra("title", "Jungle");
                    intent.putExtra("desc", "Jungle, green color, waterfall");
                    view.getContext().startActivity(intent);
                } else if(position == 4) {
                    Toast.makeText(view.getContext(), "You choose Sunset", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), Detail.class);
                    intent.putExtra("title", "Sunset");
                    intent.putExtra("desc", "Sunset, sunrises, dark colors");
                    view.getContext().startActivity(intent);
                }
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
        public TextView presetName;
        public ImageView presetGambar;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            presetName = itemView.findViewById(R.id.presetName);
            presetGambar = itemView.findViewById(R.id.presetGambar);
        }
    }
}
