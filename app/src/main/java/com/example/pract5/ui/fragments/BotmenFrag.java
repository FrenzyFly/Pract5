package com.example.pract5.ui.fragments;

import static androidx.navigation.Navigation.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.example.pract5.R;
import com.example.pract5.databinding.FragBotmenBinding;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

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
