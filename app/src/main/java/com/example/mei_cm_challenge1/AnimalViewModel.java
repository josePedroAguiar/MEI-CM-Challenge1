package com.example.mei_cm_challenge1;

import android.view.View;
import android.widget.AdapterView;

import androidx.lifecycle.ViewModel;

public class AnimalViewModel extends ViewModel {
    // Define variables and methods to hold data for Fragment1


    private int selectedAnimalPosition;

    public void setSelectedAnimalPosition(int position) {
        selectedAnimalPosition = position;
    }

    public int getSelectedAnimalPosition() {
        return selectedAnimalPosition;
    }


}
