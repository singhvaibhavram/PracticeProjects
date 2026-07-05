package com.example.planetsapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Planet> planetsArrayList;
    private static PlanetAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // AdapterView: a ListView
        listView = findViewById(R.id.planet_listview);

        // Data Source
        planetsArrayList = new ArrayList<>();

        Planet planet1 = new Planet("Mercury", "Moons: 0", R.drawable.mercury);
        Planet planet2 = new Planet("Venus", "Moons: 0", R.drawable.venus);
        Planet planet3 = new Planet("Earth", "Moons: 1", R.drawable.earth);
        Planet planet4 = new Planet("Mars", "Moons: 2", R.drawable.mars);
        Planet planet5 = new Planet("Jupiter", "Moons: 95", R.drawable.jupiter);
        Planet planet6 = new Planet("Saturn", "Moons: 274", R.drawable.saturn);
        Planet planet7 = new Planet("Uranus", "Moons: 28", R.drawable.uranus);
        Planet planet8 = new Planet("Neptune", "Moons: 16", R.drawable.neptune);
        Planet planet9 = new Planet("Pluto", "Moons: 5", R.drawable.pluto);

        planetsArrayList.add(planet1);
        planetsArrayList.add(planet2);
        planetsArrayList.add(planet3);
        planetsArrayList.add(planet4);
        planetsArrayList.add(planet5);
        planetsArrayList.add(planet6);
        planetsArrayList.add(planet7);
        planetsArrayList.add(planet8);
        planetsArrayList.add(planet9);

        // Adapter
        adapter = new PlanetAdapter(planetsArrayList, MainActivity.this);
        listView.setAdapter(adapter);
    }

}