package com.example.myapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class MyNewFragment extends Fragment {

    //private MyNewFragmentBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ViewModel dashboardViewModel =
                new ViewModelProvider(this).get(ViewModel.class);

        //binding = MyNewFragmentBinding.inflate(inflater, container, false);
        //View root = binding.getRoot();

        //final TextView textView = binding.MyNewFragmentBinding;
        //dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }


}
