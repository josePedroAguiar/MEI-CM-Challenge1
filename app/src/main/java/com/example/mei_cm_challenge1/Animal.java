package com.example.mei_cm_challenge1;

public class Animal {
    private int id;
    private int imageResourceId;
    private String name;

    public Animal(int id, int imageResourceId, String name) {
        this.id = id;
        this.imageResourceId = imageResourceId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getName() {
        return name;
    }
}
