package com.example.planetsapp;

// This class is acting as Model Class for our ListView
public class Planet {
    // Attributes
    private String planetName, moonCount;
    private int planetImage;

    // Constructor
    public Planet(String planetName, String moonCount, int planetImage) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.planetImage = planetImage;
    }

    // Getters & Setters

    public String getPlanetName() {
        return planetName;
    }

    public String getMoonCount() {
        return moonCount;
    }

    public int getPlanetImage() {
        return planetImage;
    }
}
