package com.example.lifestyleapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.lifestyleapp.databinding.FragmentHomePageBinding;

public class HomeFragment extends Fragment implements View.OnClickListener{

    private FragmentHomePageBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentHomePageBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.btnCalcBmi.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            //TODO: change this to a popup or something
            case R.id.btn_CalcBmi:
                Toast toast;
                User user = ProfileFragment.user;
                // BMI = 703 × pounds/(inches)^2
                if (user == null || user.heightinches < 0 || user.heightfeet < 0 || user.weight < 0)
                    toast = Toast.makeText(getContext(), "Profile info is incomplete.", Toast.LENGTH_LONG);
                else
                    toast = Toast.makeText(getContext(), "BMI: " +
                            703 * user.weight/Math.pow(user.heightfeet*12 + user.heightinches,2),  Toast.LENGTH_LONG);
                toast.show();
                break;
        }
    }
}
