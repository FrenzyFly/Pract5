package com.example.pract5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.pract5.databinding.FragSupBinding;

public class SupFrag extends Fragment {

    private FragSupBinding binding;

    private static final String TAG = "SupFrag";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PASS = "password";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragSupBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.supButton.setOnClickListener(view1 -> {
            String email = binding.etLogin.getText().toString();
            String pass = binding.etPassword.getText().toString();

            Bundle bundle = new Bundle();
            bundle.putString(KEY_EMAIL, email);
            bundle.putString(KEY_PASS, pass);

            Navigation.findNavController(view1)
                    .navigate(R.id.action_registrationFragment_to_loginFragment, bundle);
        });
    }
}