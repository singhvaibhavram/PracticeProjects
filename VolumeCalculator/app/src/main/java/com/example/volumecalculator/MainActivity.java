package com.example.volumecalculator;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    ArrayList<Shape> shapeArrayList;
    private static CustomAdapter adapter;

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

        gridView = findViewById(R.id.grid_view);
        shapeArrayList = new ArrayList<>();

        Shape cube = new Shape(R.drawable.cube, "Cube");
        Shape sphere = new Shape(R.drawable.sphere, "Sphere");
        Shape cylinder = new Shape(R.drawable.cylinder, "Cylinder");
        Shape prism = new Shape(R.drawable.prism, "Prism");

        shapeArrayList.add(cube);
        shapeArrayList.add(sphere);
        shapeArrayList.add(cylinder);
        shapeArrayList.add(prism);

        adapter = new CustomAdapter(shapeArrayList, MainActivity.this);
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);
    }
}