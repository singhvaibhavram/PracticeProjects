package com.example.planetsapp;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;

public class PlanetDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.planet_details);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Recieve data
        Intent intent = getIntent();

        String planetName = intent.getStringExtra("planetName");
        String moonCount = intent.getStringExtra("moonCount");
        int planetImage = intent.getIntExtra("planetImage", 0);
        String description = intent.getStringExtra("description");
        String type = intent.getStringExtra("type");
        String diameter = intent.getStringExtra("diameter");
        String gravity = intent.getStringExtra("gravity");
        String distance = intent.getStringExtra("distance");
        String dayLength = intent.getStringExtra("dayLength");
        String temperature = intent.getStringExtra("temperature");

        // Views
        ImageButton btnBack = findViewById(R.id.planetdetail_btn_back);

        ImageView imgPlanet = findViewById(R.id.planetdetail_image);

        TextView dtHeader = findViewById(R.id.planetdetail_header_title);
        TextView dtPlanetName = findViewById(R.id.planetdetail_planet_name);
        TextView dtMoonCount = findViewById(R.id.planetdetail_moon_count);
        TextView dtDescription = findViewById(R.id.planetdetail_description);

        TextView dtType = findViewById(R.id.planetdetail_type);
        TextView dtDiameter = findViewById(R.id.planetdetails_diameter);
        TextView dtGravity = findViewById(R.id.planetdetail_gravity);
        TextView dtDistance = findViewById(R.id.planetdetail_distancefromsun);
        TextView dtDayLength = findViewById(R.id.planetdetail_daylength);
        TextView dtTemperature = findViewById(R.id.planetdetail_temperature);

        // Display data
        imgPlanet.setImageResource(planetImage);

        dtHeader.setText(planetName);
        dtPlanetName.setText(planetName);
        dtMoonCount.setText(moonCount);

        dtDescription.setText(description);

        dtType.setText(type);
        dtDiameter.setText(diameter);
        dtGravity.setText(gravity);
        dtDistance.setText(distance);
        dtDayLength.setText(dayLength);
        dtTemperature.setText(temperature);

        // Back button
        btnBack.setOnClickListener(v -> finish());
    }
}


