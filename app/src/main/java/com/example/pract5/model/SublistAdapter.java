package com.example.pract5.model;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pract5.R;
import com.example.pract5.databinding.ItemSublistBinding;

import java.util.List;

public class SublistAdapter extends RecyclerView.Adapter<SublistAdapter.ViewHolder> {

    private final List<SublistItem> sublistItems;

    public SublistAdapter(List<SublistItem> sublistItems) {
        this.sublistItems = sublistItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemSublistBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SublistItem item = sublistItems.get(position);
        holder.binding.name.setText(item.getName());
        holder.binding.classic.setText(item.getClassic());
        holder.binding.timeStartEnd.setText(item.getTimeStartEnd());
        holder.binding.date.setText(item.getDate());
        holder.binding.teacher.setText(item.getTeacher());
    }

    @Override
    public int getItemCount() {
        return sublistItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ItemSublistBinding binding;

        public ViewHolder(@NonNull ItemSublistBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
