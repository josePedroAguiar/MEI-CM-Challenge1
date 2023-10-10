package com.example.mei_cm_challenge1;

import android.view.View;
import android.widget.AdapterView;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;


public class AnimalViewModel extends ViewModel {
    private ArrayList<Animal> animals;

    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}