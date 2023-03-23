package com.example.pract5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.pract5.databinding.ActivityStartBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
