package com.example.mei_cm_challenge1;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment1 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private  ArrayList<Animal> animals;
    String[] animalIds ;
    int[] animalImages={R.drawable.frog, R.drawable.rhino, R.drawable.snail};
    String[] animalNames;

    public Fragment1() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment1.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment1 newInstance(String param1, String param2) {
        Fragment1 fragment = new Fragment1();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        Spinner spinner = view.findViewById(R.id.spinner);
        ImageView animalImageView = view.findViewById(R.id.imageView);
        TextView animalTextName = view.findViewById(R.id.text);


        //This portion of code probably should be in the activity
        Button buttonSwitchToFragment2 = view.findViewById(R.id.buttonSwitchFragment);
        buttonSwitchToFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the selected animal from the spinner
                int selectedAnimalId = animals.get(spinner.getSelectedItemPosition()).getId();

                // Create a Bundle to pass data to Fragment2
                Bundle bundle = new Bundle();
                bundle.putInt("animalId", selectedAnimalId);

                // Create a Fragment2 instance and set the arguments
                Fragment2 fragment2 = new Fragment2();
                fragment2.setArguments(bundle);

                // Navigate to Fragment2
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment2)
                        .addToBackStack(null)
                        .commit();
            }
        });




        // Create an ArrayAdapter using the string array and a default spinner layout
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    requireContext(),
                    android.R.layout.simple_spinner_item,
                    animalNames
            );
        // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
            spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Animal selectedAnimal = animals.get(i);
                String newItem = selectedAnimal.getName();
                animalImageView.setImageResource(selectedAnimal.getImageResourceId());
                animalTextName.setTextSize(40);
                animalTextName.setText(selectedAnimal.getName());



                // Set the image resource based on the selected animal
                if (animalImageView != null) {
                    animalImageView.setImageResource(selectedAnimal.getImageResourceId());
                    Toast.makeText(getActivity(), "Your id: " +selectedAnimal.getImageResourceId(), Toast.LENGTH_LONG).show();
                }



                Toast.makeText(getActivity(), "You frog id: "+ (R.drawable.frog), Toast.LENGTH_LONG).show();
                Toast.makeText(getActivity(), "You selected: " + newItem, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        return view;
    }

    private AnimalViewModel animalViewModel;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        //
        animalIds = getResources().getStringArray(R.array.animal_ids);

        animalNames = getResources().getStringArray(R.array.animal_names);

       animals = new ArrayList<>();
        for (int i = 0; i < animalIds.length; i++) {
            int id = Integer.parseInt(animalIds[i]);
            int imageResourceId = animalImages[i] ;
            String name = animalNames[i];
            animals.add(new Animal(id, imageResourceId, name));
        }


        animalViewModel = new ViewModelProvider(requireActivity()).get(AnimalViewModel.class);
        animalViewModel.setAnimals(animals);
    }


}