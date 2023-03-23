package com.example.pract5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.pract5.databinding.FragSublistBinding;
import com.example.pract5.model.SublistAdapter;
import com.example.pract5.model.SublistItem;

import java.util.ArrayList;
import java.util.List;

public class SublistFrag extends Fragment {
    private FragSublistBinding binding;

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

        SublistAdapter adapter = new SublistAdapter(initList());
        binding.sublist.setAdapter(adapter);
    }

    private List<SublistItem> initList() {
        List<SublistItem> sublistItems = new ArrayList<>();

        String[] names = {"GEOGRAPHY", "HISTORY", "MATHEMATICS", "ENGLISH", "BIOLOGY", "SOCIAL STUDIES", "IT SCIENCE"};
        String[] classics = {"A-1", "A-2", "A-3", "A-4", "A-5", "B-1", "B-2", "B-3", "C-1", "C-2"};
        String[] time = {
                "Begins: 9:00\nEnds: 10:30",
                "Begins: 10:40\nEnds: 12:10",
                "Begins: 12:40\nEnds: 14:10"
        };
        String[] date = {"24.01.2023", "24.02.2023", "24.03.2023"};
        String[] teachers = {"Иванова А.А.", "Петрова Е.Е.", "Сидоров Б.Б."};

        for (int i = 0; i < 50; i++) {
            sublistItems.add(
                    new SublistItem(
                            names[(int) (Math.random() * names.length)],
                            classics[(int) (Math.random() * classics.length)],
                            time[(int) (Math.random() * time.length)],
                            date[(int) (Math.random() * date.length)],
                            teachers[(int) (Math.random() * teachers.length)]
                    )
            );
        }

        return sublistItems;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}
