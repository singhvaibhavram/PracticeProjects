package com.example.planetsapp;

// This class is acting as Model Class for our ListView
public class Planet {
    // Attributes
    private String planetName, moonCount;
    private int planetImage;
    private String description;
    private String type;
    private String diameter;
    private String gravity;
    private String distance;
    private String dayLength;
    private String temperature;

    // Constructor
    public Planet(String planetName, String moonCount, int planetImage, String description, String type, String diameter, String gravity, String distance, String dayLength, String temperature) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.planetImage = planetImage;
        this.description = description;
        this.type = type;
        this.diameter = diameter;
        this.gravity = gravity;
        this.distance = distance;
        this.dayLength = dayLength;
        this.temperature = temperature;
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

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public String getDiameter() {
        return diameter;
    }

    public String getGravity() {
        return gravity;
    }

    public String getDistance() {
        return distance;
    }

    public String getDayLength() {
        return dayLength;
    }

    public String getTemperature() {
        return temperature;
    }
}
