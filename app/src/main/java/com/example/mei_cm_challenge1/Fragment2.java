package com.example.mei_cm_challenge1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private AnimalViewModel animalViewModel;

    public Fragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment2 newInstance(String param1, String param2) {
        Fragment2 fragment = new Fragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animalViewModel = new ViewModelProvider(requireActivity()).get(AnimalViewModel.class);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_2, container, false);
        Bundle bundle = getArguments();
        ArrayList<Animal> animals = animalViewModel.getAnimals();
        int animalId=-1;

        if (bundle != null) {
             animalId = bundle.getInt("animalId", -1); // -1 is a default value if the ID is not found
            // Now you have the selected animal ID
        }

        TextView animalTextName = view.findViewById(R.id.text);
        animalTextName.setText("ID: ---------------------> " + animals.get(animalId).getName());

        // Inflate the layout for this fragment
        //This portion of code probably should be in the activity

        //View view2=inflater.inflate(R.layout.activity_main, container, false);
        Button buttonSwitchToFragment2 = view.findViewById(R.id.buttonSwitchFragment);
        buttonSwitchToFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment1 fragment1 = new Fragment1();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, fragment1)
                        .addToBackStack(null)
                        .commit();
            }
        });


        return view;
    }
}