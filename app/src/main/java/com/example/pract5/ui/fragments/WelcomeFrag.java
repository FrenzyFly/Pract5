package com.example.pract5.ui.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.pract5.R;
import com.example.pract5.databinding.FragWelcomeBinding;

public class WelcomeFrag extends Fragment {
    private FragWelcomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragWelcomeBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.createAccount.setOnClickListener(view1 ->
                Navigation.findNavController(view1).navigate(R.id.action_greetingFragment_to_registrationFragment));

        binding.createAccount.setOnClickListener(view1 ->
                Navigation.findNavController(view1).navigate(R.id.action_greetingFragment_to_registrationFragment));

        binding.logIn.setOnClickListener(view1 ->
                Navigation.findNavController(view1).navigate(R.id.action_greetingFragment_to_loginFragment));

    }
}
