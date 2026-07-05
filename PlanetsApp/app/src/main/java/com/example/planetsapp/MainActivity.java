package com.example.planetsapp;

import android.content.Intent;
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

        Planet mercury = new Planet(
                "Mercury",
                "0 Moons",
                R.drawable.mercury,
                "Mercury is the closest planet to the Sun and the smallest planet in the Solar System. It has a rocky, cratered surface and almost no atmosphere.",
                "Terrestrial",
                "4,879 km",
                "3.7 m/s²",
                "57.9 million km",
                "58.6 Earth days",
                "167 °C"
        );

        Planet venus = new Planet(
                "Venus",
                "0 Moons",
                R.drawable.venus,
                "Venus is the second planet from the Sun. Its thick carbon dioxide atmosphere traps heat, making it the hottest planet in the Solar System.",
                "Terrestrial",
                "12,104 km",
                "8.87 m/s²",
                "108.2 million km",
                "243 Earth days",
                "464 °C"
        );

        Planet earth = new Planet(
                "Earth",
                "1 Moon",
                R.drawable.earth,
                "Earth is the third planet from the Sun and the only known planet to support life. Often called the Blue Planet, about 71% of its surface is covered by water. Earth has one natural satellite, the Moon, and completes one orbit around the Sun in approximately 365 days. Its atmosphere, liquid water, and moderate climate make it uniquely suited for sustaining a wide variety of life.",
                "Terrestrial",
                "12,742 km",
                "9.81 m/s²",
                "149.6 million km",
                "24 Hours",
                "15 °C"
        );

        Planet mars = new Planet(
                "Mars",
                "2 Moons",
                R.drawable.mars,
                "Mars, known as the Red Planet, has the largest volcano and canyon in the Solar System. It is a prime target in the search for signs of ancient life.",
                "Terrestrial",
                "6,779 km",
                "3.71 m/s²",
                "227.9 million km",
                "24.6 Hours",
                "-63 °C"
        );

        Planet jupiter = new Planet(
                "Jupiter",
                "95 Moons",
                R.drawable.jupiter,
                "Jupiter is the largest planet in the Solar System. It is a gas giant famous for the Great Red Spot, a massive storm larger than Earth.",
                "Gas Giant",
                "139,820 km",
                "24.79 m/s²",
                "778.5 million km",
                "9.9 Hours",
                "-145 °C"
        );

        Planet saturn = new Planet(
                "Saturn",
                "146 Moons",
                R.drawable.saturn,
                "Saturn is best known for its spectacular rings made of ice and rock. It is the second-largest planet in the Solar System.",
                "Gas Giant",
                "116,460 km",
                "10.44 m/s²",
                "1.43 billion km",
                "10.7 Hours",
                "-178 °C"
        );

        Planet uranus = new Planet(
                "Uranus",
                "28 Moons",
                R.drawable.uranus,
                "Uranus is an ice giant that rotates on its side, making it unique among the planets. Methane in its atmosphere gives it a pale blue color.",
                "Ice Giant",
                "50,724 km",
                "8.69 m/s²",
                "2.87 billion km",
                "17.2 Hours",
                "-224 °C"
        );

        Planet neptune = new Planet(
                "Neptune",
                "16 Moons",
                R.drawable.neptune,
                "Neptune is the farthest planet from the Sun and is famous for its powerful winds, which are the fastest in the Solar System.",
                "Ice Giant",
                "49,244 km",
                "11.15 m/s²",
                "4.50 billion km",
                "16.1 Hours",
                "-214 °C"
        );

        Planet pluto = new Planet(
                "Pluto",
                "5 Moons",
                R.drawable.pluto,
                "Pluto is a dwarf planet in the Kuiper Belt beyond Neptune. Though no longer classified as a major planet, it remains an important and fascinating world.",
                "Dwarf Planet",
                "2,377 km",
                "0.62 m/s²",
                "5.91 billion km",
                "6.4 Earth Days",
                "-229 °C"
        );

        planetsArrayList.add(mercury);
        planetsArrayList.add(venus);
        planetsArrayList.add(earth);
        planetsArrayList.add(mars);
        planetsArrayList.add(jupiter);
        planetsArrayList.add(saturn);
        planetsArrayList.add(uranus);
        planetsArrayList.add(neptune);
        planetsArrayList.add(pluto);

        // Adapter
        adapter = new PlanetAdapter(planetsArrayList, MainActivity.this);
        listView.setAdapter(adapter);
        // On click intent calling
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Planet selectedPlanet = planetsArrayList.get(position);
            Intent i = new Intent(MainActivity.this, PlanetDetailActivity.class);
            i.putExtra("planetName", selectedPlanet.getPlanetName());
            i.putExtra("moonCount", selectedPlanet.getMoonCount());
            i.putExtra("planetImage", selectedPlanet.getPlanetImage());
            i.putExtra("description", selectedPlanet.getDescription());
            i.putExtra("type", selectedPlanet.getType());
            i.putExtra("diameter", selectedPlanet.getDiameter());
            i.putExtra("gravity", selectedPlanet.getGravity());
            i.putExtra("distance", selectedPlanet.getDistance());
            i.putExtra("dayLength", selectedPlanet.getDayLength());
            i.putExtra("temperature", selectedPlanet.getTemperature());
            startActivity(i);
        });
    }

}