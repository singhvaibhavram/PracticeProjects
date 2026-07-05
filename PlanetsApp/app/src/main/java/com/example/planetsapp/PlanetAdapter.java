package com.example.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class PlanetAdapter extends ArrayAdapter<Planet> {
    // Variables
    Context context;

    public PlanetAdapter(ArrayList<Planet> planetArrayList, Context context) {
        super(context, R.layout.item_list_layout, planetArrayList);
        this.context = context;
    }

    // View Holder CLass
    private static class PlanetViewHolder{
        ImageView planetImage;
        TextView planetName;
        TextView moonCount;
    }

    // getView()

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Get the planet object for the current position
        Planet planet = getItem(position);

        // Inflate the Layout
        PlanetViewHolder planetViewHolder;

        if (convertView == null){
            planetViewHolder = new PlanetViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );

            //Finding Views
            planetViewHolder.planetImage = (ImageView) convertView.findViewById(R.id.planet_image);
            planetViewHolder.planetName = (TextView) convertView.findViewById(R.id.planet_name);
            planetViewHolder.moonCount = (TextView) convertView.findViewById(R.id.moon_number);

            convertView.setTag(planetViewHolder);

        }else {
            // If View is recycled
            planetViewHolder = (PlanetViewHolder) convertView.getTag();
        }
        planetViewHolder.planetName.setText(planet.getPlanetName());
        planetViewHolder.moonCount.setText(planet.getMoonCount());
        planetViewHolder.planetImage.setImageResource(planet.getPlanetImage());

        return convertView;
    }
}
