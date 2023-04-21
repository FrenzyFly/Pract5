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
import androidx.navigation.Navigation;

import com.example.pract5.R;
import com.example.pract5.data.db.entities.SublistItem;
import com.example.pract5.databinding.FragSublistBinding;
import com.example.pract5.ui.stateholder.adapter.SublistAdapter;
import com.example.pract5.ui.stateholder.viewmodel.SublistVmod;

import java.util.List;

public class SublistFrag extends Fragment {
    private FragSublistBinding binding;
    public static final String KEY_POS = "position";

    private SublistVmod viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragSublistBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel = new ViewModelProvider(this).get(SublistVmod.class);
        viewModel.sublist.observe(getViewLifecycleOwner(), new Observer<List<SublistItem>>() {
            @Override
            public void onChanged(List<SublistItem> sublistItems) {
                SublistAdapter adapter = new SublistAdapter(sublistItems);
                adapter.onSubItemListClickListener = new SublistAdapter.OnSubItemListClickListener() {
                    @Override
                    public void onSubItemListClickListener(int position) {
                        Bundle bundle = new Bundle();
                        bundle.putInt(KEY_POS, position);
                        Navigation.findNavController(requireView())
                                .navigate(R.id.action_fragmentHackathonsList_to_hackathonItemList, bundle);
                    }
                };
                binding.sublist.setAdapter(adapter);
            }
        });


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
