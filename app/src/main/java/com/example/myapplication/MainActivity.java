package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    private Spinner spinner;
    private Integer[] images;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id. spinner);
        List<String>textSizes= Arrays.asList(getResources().getStringArray(R.array.font_sizes));
        int[] imgID =getResources().getIntArray(R.array.images);
        List<AnimalItem> aux=new ArrayList<>();
        int pos=0;
        Resources res = getResources();
        for (String i: textSizes){
            aux.add(new  AnimalItem(imgID[pos],i));
            pos++;
        }

        AnimalAdapter adapter=new AnimalAdapter(this,aux);
        spinner.setAdapter(adapter);

        // Make a Toast whenever the user selects something from the Spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String newItem = textSizes.get(i);
                Toast.makeText(getApplicationContext(), "You selected: " + newItem, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });


        Button changeFragmentButton = findViewById(R.id.button);
        changeFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the FragmentManager
                FragmentManager fragmentManager = getSupportFragmentManager();

                // Begin a fragment transaction
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                // Replace the existing fragment with the new one
                MyNewFragment newFragment = new MyNewFragment();
                fragmentTransaction.replace(R.id.fragment_container, newFragment);

                // Optional: Add the transaction to the back stack (for back navigation)
                fragmentTransaction.addToBackStack(null);

                // Commit the transaction
                fragmentTransaction.commit();
            }
        });

    }

}