package com.example.pract5.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.pract5.databinding.FragSubItemListBinding;
import com.example.pract5.data.db.entities.SublistItem;
import com.example.pract5.ui.stateholder.viewmodel.SublistItemVmod;

public class SubItemList extends Fragment {

    private FragSubItemListBinding binding;
    private SublistItemVmod viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState
    ) {
        binding = FragSubItemListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SublistItemVmod.class);
        parseArgs();
        observeViewModel();
    }

    private void parseArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int position = bundle.getInt(SublistFrag.KEY_POS);
            viewModel.getSublistItem(position);
        }
    }

    private void observeViewModel() {
        viewModel.sublistItem.observe(getViewLifecycleOwner(), new Observer<SublistItem>() {
            @Override
            public void onChanged(SublistItem item) {
                binding.name.setText(item.getName());
                binding.company.setText(item.getClassic());
                binding.dateStartEnd.setText(item.getDate());
                binding.languages.setText(item.getTeacher());
                binding.status.setText(item.getMark());
            }
        });
    }
}
