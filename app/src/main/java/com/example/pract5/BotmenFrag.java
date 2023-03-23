package com.example.pract5;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.example.pract5.databinding.FragBotmenBinding;

import java.util.Objects;

public class BotmenFrag extends Fragment {

    private FragBotmenBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragBotmenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        NavController navController = (
                (NavHostFragment) Objects.requireNonNull(getChildFragmentManager()
                        .findFragmentById(R.id.frag_botmen_container))
        ).getNavController();
        NavigationUI.setupWithNavController(binding.botnav, navController);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
